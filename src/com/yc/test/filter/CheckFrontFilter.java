package com.yc.test.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.Printer;
@WebFilter(filterName = "CheckFrontFilter",value="/front/*")
public class CheckFrontFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if(request.getSession().getAttribute("currentLoginMember") == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			out.print("<script>alert('请先登录...'); location.href='"+basePath+"login.html'</script>");
			out.flush();
			return;
		}
		//获取用户请求路径
		String path = request.getRequestURI();// /test/front/cart.html
		//获取请求项目名
		String base = request.getContextPath();//test
		path = path.replace(base, "");
		request.getRequestDispatcher("../WEB-INF" + path).forward(request, response);
        return;		
	}

}
