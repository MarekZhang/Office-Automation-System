package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.ClaimVoucherBiz;
import com.imooc.oa.dao.ClaimVoucherDao;
import com.imooc.oa.dao.ClaimVoucherItemDao;
import com.imooc.oa.dao.DealRecordDao;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.global.Constant;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

@Service("claimVoucherBiz")
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {
  @Resource(name="claimVoucherDao")
  ClaimVoucherDao claimVoucherDao;

  @Resource(name="claimVoucherItemDao")
  ClaimVoucherItemDao claimVoucherItemDao;

  @Resource(name="dealRecordDao")
  DealRecordDao dealRecordDao;

  @Resource(name="employeeDao")
  EmployeeDao employeeDao;

  public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> voucherItems) {
    claimVoucher.setCreateTime(new Date());
    claimVoucher.setStatus(Constant.CLAIMVOUCHER_CREATED);
    claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
    claimVoucherDao.insert(claimVoucher);

    for(ClaimVoucherItem voucherItem : voucherItems) {
      voucherItem.setClaimVoucherId(claimVoucher.getId());
      claimVoucherItemDao.insert(voucherItem);
    }
  }

  public ClaimVoucher getVoucherById(int id) {
    return claimVoucherDao.selectById(id);
  }

  public List<ClaimVoucherItem> getVoucherItems(int cvid) {
    return claimVoucherItemDao.selectByCVId(cvid);
  }

  public List<DealRecord> getDealRecords(int cvid) {
    return dealRecordDao.selectByCVId(cvid);
  }

  public List<ClaimVoucher> getMyVouchers(String mySn) {
    return claimVoucherDao.selectByCreator(mySn);
  }

  public List<ClaimVoucher> getDealingVouchers(String mySn) {
    return claimVoucherDao.selectByNextDealer(mySn);
  }

  public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> voucherItems) {
    claimVoucher.setCreateTime(new Date());
    claimVoucher.setStatus(Constant.CLAIMVOUCHER_CREATED);
    claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
    //find all previous items in this claim voucher
    List<ClaimVoucherItem> previousItems = claimVoucherItemDao.selectByCVId(claimVoucher.getId());
    //delete all items which doest not exist in the new Items list
    for (ClaimVoucherItem previousItem : previousItems) {
      boolean isDeleted = true;
      for (ClaimVoucherItem voucherItem : voucherItems) {
        if(voucherItem.getId()==previousItem.getId())
          isDeleted = false;
      }
      if(isDeleted)
        claimVoucherItemDao.delete(previousItem.getId());
    }

    //add updated voucher items to the database
    for (ClaimVoucherItem voucherItem : voucherItems) {
      voucherItem.setClaimVoucherId(claimVoucher.getId());
      //if the voucher item has already existed in the database, then update the information
      if(voucherItem.getId()!= null && voucherItem.getId() > 0)
        claimVoucherItemDao.update(voucherItem);
      else
        claimVoucherItemDao.insert(voucherItem);
    }

    claimVoucherDao.update(claimVoucher);
  }

  public void submitVoucher(int id) {
    ClaimVoucher claimVoucher = claimVoucherDao.selectById(id);
    Employee employee = employeeDao.select(claimVoucher.getCreateSn());
    Employee depManager = employeeDao.selectByDepAndPos(employee.getDepartmentSn(), Constant.POST_FM).get(0);
    claimVoucher.setNextDealSn(depManager.getSn());
    claimVoucher.setStatus(Constant.CLAIMVOUCHER_SUBMIT);
    claimVoucherDao.update(claimVoucher);

    DealRecord record = new DealRecord();
    record.setClaimVoucherId(id);
    record.setDealSn(employee.getSn());
    record.setDealTime(new Date());
    record.setDealWay(Constant.DEAL_SUBMIT);
    record.setDealResult(Constant.CLAIMVOUCHER_SUBMIT);
    dealRecordDao.insert(record);
  }

  public void operateVoucher(DealRecord dealRecord) {
    Employee employee = employeeDao.select(dealRecord.getDealSn());
    ClaimVoucher claimVoucher = claimVoucherDao.selectById(dealRecord.getClaimVoucherId());
    String dealWay = dealRecord.getDealWay();

    if(dealWay.equals(Constant.DEAL_PASS)){
      if(claimVoucher.getTotalAmount() <= 5000 || employee.getPost().equals(Constant.POST_GM)){
        dealRecord.setDealResult(Constant.CLAIMVOUCHER_APPROVED);

        claimVoucher.setNextDealSn(employeeDao.selectByDepAndPos(null, Constant.POST_CASHIER).get(0).getSn());
        claimVoucher.setStatus(Constant.CLAIMVOUCHER_APPROVED);
      }else{
        dealRecord.setDealResult(Constant.CLAIMVOUCHER_RECHECK);

        claimVoucher.setNextDealSn(employeeDao.selectByDepAndPos(null, Constant.POST_GM).get(0).getSn());
        claimVoucher.setStatus(Constant.CLAIMVOUCHER_RECHECK);
      }
    }else if(dealWay.equals(Constant.DEAL_BACK)){
      dealRecord.setDealResult(Constant.CLAIMVOUCHER_BACK);

      claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
      claimVoucher.setStatus(Constant.CLAIMVOUCHER_BACK);
    }else if(dealWay.equals(Constant.DEAL_REJECT)){
      dealRecord.setDealResult(Constant.CLAIMVOUCHER_TERMINATED);

      claimVoucher.setNextDealSn(null);
      claimVoucher.setStatus(Constant.CLAIMVOUCHER_TERMINATED);
    }else if(dealWay.equals(Constant.DEAL_PAID)){
      dealRecord.setDealResult(Constant.CLAIMVOUCHER_PAID);

      claimVoucher.setNextDealSn(null);
      claimVoucher.setStatus(Constant.CLAIMVOUCHER_PAID);
    }

    dealRecord.setDealTime(new Date());
    claimVoucherDao.update(claimVoucher);
    dealRecordDao.insert(dealRecord);
  }
}
