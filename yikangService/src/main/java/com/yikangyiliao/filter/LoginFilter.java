package com.yikangyiliao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.yikangyiliao.base.utils.NetworkUtil;


public class LoginFilter implements Filter {

	private String strTokit="helloworld";
	
//	private Logger log=Logger.getLogger(LoginFilter.class);
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hsr=(HttpServletRequest)arg0;
		String requestURI=hsr.getRequestURI();
//		if(null != requestURI && !requestURI.equals("login.html")){
//			HttpSession session=hsr.getSession();
//			if(null == session.getAttribute("sessionToket")){
//				session.setAttribute("sessionToket",this.strTokit);
//				System.out.println("set session");
//				arg0.getRequestDispatcher("/login.html").forward(arg0, arg1);
//			}
//		}

//		paramMap.put("appId", appId);
//		paramMap.put("accessTiket", accessTiket);
		
		String appId=hsr.getParameter("appId");
		
		String accessTiket=hsr.getParameter("accessTiket");
		
		
		
		String hostIp=NetworkUtil.getIpAddress(hsr);
		//String host=request.getre
		
		
		arg2.doFilter(arg0, arg1);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
