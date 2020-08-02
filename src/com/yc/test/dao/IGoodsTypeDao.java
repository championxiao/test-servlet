package com.yc.test.dao;

import java.util.List;

import com.yc.test.entity.GoodsType;

public interface IGoodsTypeDao {
	public List<GoodsType> findAll();
	public int update(GoodsType type);
	public int add(GoodsType type);
	public int delete(String tno);

}
