package com.demo.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInterceptorConfig extends HandlerInterceptorAdapter {
	
	static Logger log = Logger.getLogger(UserInterceptorConfig.class.getName());
	
	private static final long MAX_INACTIVE_SESSION_TIME = 30*6 * 10000;
	
	@Autowired
	private HttpSession session;
	
	public static boolean isUserLogged(HttpServletRequest request) {
	    try {
	        return request.getSession().getAttribute("isUserLoggedIn").equals(new Boolean("true"));
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	@Override
	public boolean preHandle(
	  HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    log.info("Pre handle method - check handling start time");
	    long startTime = System.currentTimeMillis();
	    request.setAttribute("executionTime", startTime);
	    
	    if (isUserLogged(request)) {
	        session = request.getSession();
	        log.info("Time since last request in this session: {} ms"+" "+
	          (System.currentTimeMillis() - request.getSession().getLastAccessedTime()));
	        if (System.currentTimeMillis() - session.getLastAccessedTime()
	          > MAX_INACTIVE_SESSION_TIME) {
	            log.warn("Logging out, due to inactive session");
	            SecurityContextHolder.clearContext();
	            request.logout();
	            response.sendRedirect("/DemoSpring_Prac/logout");
	        }
	    }
	    return true;
	}
	
	@Override
	public void postHandle(
	  HttpServletRequest request, 
	  HttpServletResponse response,
	  Object handler, 
	  ModelAndView model) throws Exception {
	    log.info("Post handle method - check execution time of handling");
	    long startTime = (Long) request.getAttribute("executionTime");
	    log.info("Execution time for handling the request was: {} ms"+" "+
	      (System.currentTimeMillis() - startTime));
	}

}
