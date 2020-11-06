package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.upgrade.common.interceptor.LoginInterceptor;

public class LoginInterceptor implements HandlerInterceptor {  

   private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
   
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      logger.info("[INTERCEPTOR] preHandle");
      
      //DS->Servlet 가기 이전에
      
      
      // spring 3.2 이상부터는 servlet-context.xml에서 <exclude-mapping-path> 를 통해 설정할 수 있다.
      if(request.getRequestURI().contains("/loginform.do") ||
         request.getRequestURI().contains("/ajaxlogin.do") ||
         request.getSession().getAttribute("login") != null
         ) {
    	  
    	  	//return 값이 true 일 경우에만, 해당 컨트롤러로 연결을 시켜준다
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
      //Controller->DS 갈 때
	   
      logger.info("[INTERCEOTOR] postHandle");
      
      if(modelAndView != null) {
    	  
    	  logger.info(modelAndView.getViewName());
      }

   }

   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      
	  //View가 rendering 된 후(prefix, suffix 붙이고, 데이터 넣어주고 html 형태로 바뀔 때!
      logger.info("[INTERCEPTOR] afterCompletion");

   }

}
