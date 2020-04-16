/*
 * package com.demo.Filter;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.Date; import java.util.StringTokenizer;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.FilterConfig; import javax.servlet.ServletException; import
 * javax.servlet.ServletRequest; import javax.servlet.ServletResponse; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.apache.commons.lang3.exception.ExceptionUtils; import
 * org.apache.log4j.Logger;
 * 
 * import com.demo.ServiceImpl.UserServiceImpl;
 * 
 * public class SessionFilter implements Filter{
 * 
 * static Logger log = Logger.getLogger(SessionFilter.class.getName());
 * 
 * private ArrayList<String> urlList; private String avoidUrls =
 * "/login,/signup,/loginValidator,/logout";
 * 
 * @Override public void destroy() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void doFilter(ServletRequest req, ServletResponse res,
 * FilterChain chain) throws IOException, ServletException { try {
 * HttpServletRequest request = (HttpServletRequest) req; HttpServletResponse
 * response = (HttpServletResponse) res;
 * 
 * //Get the relative path String url = request.getServletPath(); boolean
 * allowedRequest = false;
 * 
 * //If the path is inside avoidURLs then don't do filter just chainOut
 * if(urlList.contains(url)) { allowedRequest = true; }
 * 
 * //If the path is not inside the avoidURLS then do redirect if
 * (!allowedRequest) { HttpSession session = request.getSession(false);
 * if(session == null || (session != null &
 * session.getAttribute("isUserLoggedIn")== null)){
 * request.setAttribute("Message","Kindly Login to view page!");
 * response.sendRedirect("login"); } } //Do the chaining chain.doFilter(req,
 * res); } catch(Exception exe) { log.info(exe.getMessage()+ new Date()+
 * ExceptionUtils.getStackTrace(exe)); req.setAttribute("errorMessage", exe);
 * 
 * req.getRequestDispatcher("/WEB-INF/views/jsp/exceptionPage.jsp")
 * .forward(req, res);
 * 
 * } }
 * 
 * @Override public void init(FilterConfig filterConfig) throws ServletException
 * {
 * 
 * // TODO Auto-generated method stub String urls = avoidUrls ; StringTokenizer
 * token = new StringTokenizer(urls, ",");
 * 
 * urlList = new ArrayList<String>();
 * 
 * while (token.hasMoreTokens()) { urlList.add(token.nextToken()); }
 * 
 * }
 * 
 * }
 */