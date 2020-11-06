package com.hw.mvc.common.interceptor;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	
	private Logger logger = (Logger) LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("[INTERCEPTOR] preHandle");
		
		if(request.getRequestURI().contains("/loginform.do") ||
		         request.getRequestURI().contains("/ajaxlogin.do") ||
		         request.getSession().getAttribute("login") != null
		         ) {
		    	  
		            return true;
		      }
		 if(request.getSession().getAttribute("login") == null) {
	    	  response.sendRedirect("loginform.do");
	      }
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		
		   logger.info("[INTERCEOTOR] postHandle");
		      
		      if(modelAndView != null) {
		    	  
		    	  logger.info(modelAndView.getViewName());
		      } 	

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		 logger.info("[INTERCEPTOR] afterCompletion");

	}

}
