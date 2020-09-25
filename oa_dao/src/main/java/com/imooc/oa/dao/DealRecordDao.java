package com.imooc.oa.dao;

import com.imooc.oa.entity.DealRecord;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dealRecordDao")
public interface DealRecordDao {
  void insert(DealRecord record);
  List<DealRecord> selectByCVId(Integer cvid);
}
