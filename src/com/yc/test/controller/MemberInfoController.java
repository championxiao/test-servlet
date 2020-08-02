package com.yc.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiDevice.Info;

import com.mysql.cj.Session;
import com.yc.test.biz.IMemberInfoBiz;
import com.yc.test.biz.impl.MemberInfoBizImpl;
import com.yc.test.entity.MemberInfo;
@WebServlet("/member")
public class MemberInfoController extends BasicServlet {

	private static final long serialVersionUID = -1977620794269577539L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("login".equals(op)) {
			login(request,response);
		}else if("info".equals(op)) {
			info(request,response);
		}
	}
	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj==null) {
			this.send(response,500, "",null);
			return;
		}
		this.send(response, 200,"",obj);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String vcode = String.valueOf(session.getAttribute("validatecode"));
		
		if(!code.equals(vcode)) {
			this.send(response, 500, "",null);
			return;
		}
		IMemberInfoBiz memberInfoBiz = new MemberInfoBizImpl();
		MemberInfo memberInfo = memberInfoBiz.login(account, pwd);
		if(memberInfo == null) {
			this.send(response, 501,"",null);
			return;
		}
		session.setAttribute("currentLoginMember", memberInfo);
		this.send(response, 200,"",null);
	    
	}
	

}
