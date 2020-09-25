package com.imooc.oa.dao;

import com.imooc.oa.entity.ClaimVoucherItem;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {
  void insert(ClaimVoucherItem item);
  void delete(Integer id);
  void update(ClaimVoucherItem item);
  List<ClaimVoucherItem> selectByCVId(Integer cvid);
}
