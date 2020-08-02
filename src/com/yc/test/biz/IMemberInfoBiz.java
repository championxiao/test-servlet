package com.yc.test.biz;

import com.yc.test.entity.MemberInfo;

public interface IMemberInfoBiz {
	public MemberInfo login(String account,String pwd);

}
