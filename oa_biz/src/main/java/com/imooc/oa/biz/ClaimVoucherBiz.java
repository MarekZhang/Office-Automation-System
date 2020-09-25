package com.imooc.oa.biz;

import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;

import java.util.List;

public interface ClaimVoucherBiz {
  void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> voucherItems);
  ClaimVoucher getVoucherById(int id);
  List<ClaimVoucherItem> getVoucherItems(int cvid);
  List<DealRecord> getDealRecords(int cvid);
  List<ClaimVoucher> getMyVouchers(String mySn);
  List<ClaimVoucher> getDealingVouchers(String mySn);
  void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> voucherItems);
  void submitVoucher(int id);
  void operateVoucher(DealRecord dealRecord);
}
