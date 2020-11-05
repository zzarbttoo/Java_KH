package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//넘어오는 요소보다 하위 요소여서 바꿔주는 중
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n* remoteAddr " + remoteAddr) // client ip 주소 : 0:0:0:0:0:0:0:1 (ipv6)
		.append("\n* uri : "+ uri)
		.append("\n* url : " + url)
		.append("\n* queryString : " + queryString)
		.append("\n* referer : " + referer ) //이전 페이지(보내는 페이지) url
		.append("\n* agent : " + agent + "\n"); //사용자 정보(browser, os...)
		
		logger.info("LOG FILTER\n" + sb);
		
		//이거 엄청 중요함	
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}

}
