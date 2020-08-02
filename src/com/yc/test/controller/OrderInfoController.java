package com.yc.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.test.biz.IOrderInfoBiz;
import com.yc.test.biz.impl.OrderInfoBizImpl;

@WebServlet("/order")
public class OrderInfoController extends BasicServlet {

	private static final long serialVersionUID = 7099805038461468641L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String op = request.getParameter("op");
	    if("add".equals(op)) {
	    	add(request,response);
	    }
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnos = request.getParameter("cnos");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		int result = orderInfoBiz.add(cnos, totalPrice);
		if(result>0) {
			this.send(response, 200,"", null);
		}
		this.send(response, 500, null, null);
	}

}
