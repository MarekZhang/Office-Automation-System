package com.imooc.oa.controller;

import com.imooc.oa.biz.ClaimVoucherBiz;

import com.imooc.oa.dto.ClaimVoucherDTO;
import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.global.Constant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
  @Resource(name = "claimVoucherBiz")
  private ClaimVoucherBiz claimVoucherBiz;

  @RequestMapping("/to_add")
  public String toAdd(Map<String, Object> map) {
    map.put("items", Constant.getItems());
    map.put("claimVoucherDTO", new ClaimVoucherDTO());

    return "claimVoucher_add";
  }

  //使用ClaimVoucherDTO 传值
  @RequestMapping("/add")
  public String save(HttpSession session, ClaimVoucherDTO claimVoucherDTO) {
    Employee employee = (Employee) session.getAttribute("SessionEmployee");
    ClaimVoucher claimVoucher = claimVoucherDTO.getClaimVoucher();
    List<ClaimVoucherItem> list = claimVoucherDTO.getItems();
    claimVoucher.setCreateSn(employee.getSn());
    claimVoucherBiz.save(claimVoucher, list);
    return "redirect:deal";
  }

  @RequestMapping("/detail")
  public String detail(int id, Map<String, Object> map) {
    map.put("claimVoucher", claimVoucherBiz.getVoucherById(id));
    map.put("claimVoucherItems", claimVoucherBiz.getVoucherItems(id));
    map.put("dealRecord", claimVoucherBiz.getDealRecords(id));

    return "claimVoucher_detail";
  }

  @RequestMapping("/self")
  public String myVoucher(HttpSession session, Map<String, Object> map) {
    Employee employee = (Employee) session.getAttribute("SessionEmployee");
    String mySn = employee.getSn();
    map.put("myVouchers", claimVoucherBiz.getMyVouchers(mySn));

    return "claimVoucher_mine";
  }

  @RequestMapping("/deal")
  public String dealVouchers(HttpSession session, Map<String, Object> map) {
    Employee employee = (Employee) session.getAttribute("SessionEmployee");
    String mySn = employee.getSn();
    map.put("dealVouchers", claimVoucherBiz.getDealingVouchers(mySn));

    return "claimVoucher_deal";
  }

  @RequestMapping("/to_update")
  public String toUpdate(int id, Map<String, Object> map) {
    //the category of fee claim
    map.put("items", Constant.getItems());
    ClaimVoucherDTO claimVoucherDTO = new ClaimVoucherDTO();
    claimVoucherDTO.setClaimVoucher(claimVoucherBiz.getVoucherById(id));
    claimVoucherDTO.setItems(claimVoucherBiz.getVoucherItems(id));
    map.put("claimVoucherDTO", claimVoucherDTO);

    return "claimVoucher_update";
  }

  @RequestMapping("/update")
  public String update(HttpSession session, ClaimVoucherDTO claimVoucherDTO) {
    Employee employee = (Employee) session.getAttribute("SessionEmployee");
    String mySn = employee.getSn();
    claimVoucherDTO.getClaimVoucher().setCreateSn(mySn);
    claimVoucherBiz.update(claimVoucherDTO.getClaimVoucher(), claimVoucherDTO.getItems());

    return "redirect:deal";
  }

  @RequestMapping("/submit")
  public String submit(int id) {
    claimVoucherBiz.submitVoucher(id);
    return "redirect:deal";
  }

  @RequestMapping("/to_check")
  public String toCheck(int id, Map<String, Object> map) {
    map.put("claimVoucher", claimVoucherBiz.getVoucherById(id));
    map.put("claimVoucherItems", claimVoucherBiz.getVoucherItems(id));
    map.put("dealRecord", claimVoucherBiz.getDealRecords(id));
    DealRecord dealRecord = new DealRecord();
    dealRecord.setClaimVoucherId(id);
    map.put("record", dealRecord);

    return "claimVoucher_check";
  }

  @RequestMapping("/check")
  public String check(HttpSession session, DealRecord record) {
    Employee employee = (Employee) session.getAttribute("SessionEmployee");
    String mySn = employee.getSn();
    record.setDealSn(mySn);
    claimVoucherBiz.operateVoucher(record);

    return "redirect:deal";
  }
}
