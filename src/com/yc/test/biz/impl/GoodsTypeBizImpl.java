package com.yc.test.biz.impl;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yc.test.biz.IGoodsTypeBiz;
import com.yc.test.dao.IGoodsTypeDao;
import com.yc.test.dao.impl.GoodsTypeDaoImpl;
import com.yc.test.entity.GoodsType;
import com.yc.test.util.StringUtil;

public class GoodsTypeBizImpl implements IGoodsTypeBiz{

	@Override
	public List<GoodsType> findAll() {
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.findAll();


		
	}

	@Override
	public int update(GoodsType type) {
		if(StringUtil.checkNull(type.getTname(),type.getPic())) {
			return -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.update(type);

	}

	@Override
	public int add(GoodsType type) {
		if(StringUtil.checkNull(type.getTname(),type.getPic())) {
			return -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.add(type);

	}

	@Override
	public int delete(String tno) {
		if(StringUtil.checkNull(tno)) {
			return -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();

		return goodsTypeDao.delete(tno);
	}

}
