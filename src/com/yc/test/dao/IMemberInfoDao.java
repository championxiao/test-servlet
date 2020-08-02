package com.yc.test.dao;

import com.yc.test.entity.MemberInfo;

public interface IMemberInfoDao {
	public MemberInfo login(String account,String pwd);

}
