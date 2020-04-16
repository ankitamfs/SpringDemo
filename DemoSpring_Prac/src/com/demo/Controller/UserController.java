package com.demo.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Commander.EditCommander;
import com.demo.Commander.UserDetailsEditCommander;
import com.demo.Entity.User;
import com.demo.ServiceImpl.EmailService;
import com.demo.ServiceImpl.UserServiceImpl;

@Controller
public class UserController {

	static Logger log = Logger.getLogger(UserController.class.getName());
	
	@Value("${msg:Not Available}")
	private String myVar;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	EmailService emailService;
	
	//for userdetails page
	@RequestMapping(value="/editDetailsValidator", method = RequestMethod.POST)
	public String userDetailsPage(@Valid @ModelAttribute("userDetailsEditCommand")UserDetailsEditCommander e, BindingResult br,HttpServletRequest request, HttpServletResponse response, HttpSession session, Model m) {
		try {
			User userDetailsToEdit = userService.getUserDetailsToEdit(e.getId()); 
			long userByEmailId = userService.getUserByEmailId(e.getEmail());
			//long loggedInUserId = (long) session.getAttribute("id");
			if(br.hasErrors() || (userByEmailId!=0 && (userDetailsToEdit.getId()!= userByEmailId) ) )  
	        {
				if((userByEmailId!=0 && (userDetailsToEdit.getId()!= userByEmailId))){
					m.addAttribute("EmailError", "Email is already registerd!");
				}
	            return "userPage";  
	        } 
			
			//change the name for welcome message
			if(!session.getAttribute("name").equals(e.getName())) {
				request.getSession().setAttribute("name",e.getName());
			}
			
			//Call to service
			boolean updateProcess = userService.editUserProcess(e);
			if(updateProcess) {
				m.addAttribute("Message","Succesfully Updated!");
			} else {
				m.addAttribute("Message","Something went wrong!");
			}	
			
		}	catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			return "exceptionPage";
		} 
		return "userPage";
		
	}
	
}
