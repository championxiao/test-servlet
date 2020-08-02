package com.yc.test.biz.impl;

import com.yc.test.biz.IOrderInfoBiz;
import com.yc.test.dao.IOrderInfoDao;
import com.yc.test.dao.impl.OrderInfoDaoImpl;
import com.yc.test.util.StringUtil;

public class OrderInfoBizImpl implements IOrderInfoBiz {

	@Override
	public int add(String cnos, double totalPrice) {
		if(StringUtil.checkNull(cnos)) {
			return -1;
		}
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.add(cnos, totalPrice);
				
	}

}
