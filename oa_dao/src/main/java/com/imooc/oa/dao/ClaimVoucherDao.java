package com.imooc.oa.dao;

import com.imooc.oa.entity.ClaimVoucher;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherDao")
public interface ClaimVoucherDao {
  void insert (ClaimVoucher voucher);
  void update (ClaimVoucher voucher);
  void delete (Integer id);
  ClaimVoucher selectById(Integer id);
  List<ClaimVoucher> selectByCreator(String createSn);
  List<ClaimVoucher> selectByNextDealer(String dealSn);
}
