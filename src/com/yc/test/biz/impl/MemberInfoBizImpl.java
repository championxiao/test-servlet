package com.yc.test.biz.impl;

import com.yc.test.biz.IMemberInfoBiz;
import com.yc.test.dao.IMemberInfoDao;
import com.yc.test.dao.impl.MemberInfoDaoImpl;
import com.yc.test.entity.MemberInfo;
import com.yc.test.util.StringUtil;

public class MemberInfoBizImpl implements IMemberInfoBiz {

	@Override
	public MemberInfo login(String account, String pwd) {
		if(StringUtil.checkNull(account,pwd)) {
			return null;
		}
		IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		return memberInfoDao.login(account,pwd);
		
	}

	

	

}
