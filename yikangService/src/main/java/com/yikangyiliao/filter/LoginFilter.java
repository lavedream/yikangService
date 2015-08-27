package com.yikangyiliao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.yikangyiliao.base.utils.AccessTiketCheckout;
import com.yikangyiliao.base.utils.NetworkUtil;


public class LoginFilter implements Filter {

	
	private Logger log=Logger.getLogger(LoginFilter.class);
	
	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest hsr=(HttpServletRequest)arg0;
		String requestURI=hsr.getRequestURI();
//		if(null != requestURI && !requestURI.equals("/service/login")){
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
		log.debug("登陆ip-->"+hostIp);
		
		//在登陆时，对ip 做登陆限制
		
		
		if((null != appId && appId.length()>1 && null != accessTiket && accessTiket.length()>0) || requestURI.equals("/service/login") ){
			try {
				if(requestURI.equals("/service/login")){
					arg2.doFilter(arg0, arg1);
				}else if(AccessTiketCheckout.checkAccessTiketLayout(accessTiket, hsr)){
					arg2.doFilter(arg0, arg1);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("登陆ip-->"+hostIp);
				e.printStackTrace();
			}
			
		}else{
			arg1.setCharacterEncoding("utf-8");
			arg1.getWriter().println("{'status':'999999','message':'数据校验失败!'}");
		}

		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
