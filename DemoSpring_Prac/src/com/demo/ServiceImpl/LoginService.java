package com.demo.ServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public String checkUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String name = "";
		session=request.getSession(false);  
        if(session!=null){  
        	name = (String)session.getAttribute("name");
        }
		return name;
		
	}
}
