package com.imooc.oa.global;

import java.util.ArrayList;
import java.util.List;

public class Constant {
  //职务
  public static final String POST_STAFF="General Staff";
  public static final String POST_FM="Department Manager";
  public static final String POST_GM="General Manager";
  public static final String POST_CASHIER="Accountant";
  public static List<String> getPosts(){
    List<String> list = new ArrayList<String>();
    list.add(POST_STAFF);
    list.add(POST_FM);
    list.add(POST_GM);
    list.add(POST_CASHIER);
    return list;
  }

  //费用类别
  public static List<String> getItems(){
    List<String> list = new ArrayList<String>();
    list.add("Transportation");
    list.add("Catering");
    list.add("Accommodation");
    list.add("Office");
    return list;
  }

  //报销单状态
  public static final String CLAIMVOUCHER_CREATED="Newly Created";
  public static final String CLAIMVOUCHER_SUBMIT="Submitted";
  public static final String CLAIMVOUCHER_APPROVED="Approved";
  public static final String CLAIMVOUCHER_BACK="Declined";
  public static final String CLAIMVOUCHER_TERMINATED="Rejected";
  public static final String CLAIMVOUCHER_RECHECK="Pending Review";
  public static final String CLAIMVOUCHER_PAID="Paid";
  //审核额度
  public static final double LIMIT_CHECK=3000.00;

  //处理方式
  public static final String DEAL_CREATE="Create";
  public static final String DEAL_SUBMIT="Submit";
  public static final String DEAL_UPDATE="Edit";
  public static final String DEAL_BACK="Decline";
  public static final String DEAL_REJECT="Reject";
  public static final String DEAL_PASS="Approve";
  public static final String DEAL_PAID="Pay";
}
