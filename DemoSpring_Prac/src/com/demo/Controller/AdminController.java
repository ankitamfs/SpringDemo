package com.demo.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Commander.EditCommander;
import com.demo.Commander.LoginCommander;
import com.demo.Entity.User;
import com.demo.ServiceImpl.UserServiceImpl;

@Controller
public class AdminController {
	
	static Logger log = Logger.getLogger(AdminController.class.getName());
	
	@Autowired
	UserServiceImpl userService;
	
	//get user details
	@RequestMapping(value = {"/editUserCont/{id}"})
	public String getUserDetails(@PathVariable("id") long id,HttpServletRequest request, HttpServletResponse response, Model m) {
		EditCommander e = new EditCommander();		
		try {
			User user = userService.getUserDetailsToEdit(id);
			e.setId(id);
			e.setName(user.getName());
			e.setEmail(user.getEmail());
			e.setActive(user.isActive());
			e.setGender(user.getGender());
			e.setPhone(user.getPhone());
			e.setRole(user.getRole());
			e.setInterest(user.getInterest());
		}catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			return "exceptionPage";
		} 
		m.addAttribute("userEditCommand", e);
		return "editUser";
	}
	
	//handle edit request
	@RequestMapping(value="/editValidator",method=RequestMethod.POST)
	public String editDetails(@Valid @ModelAttribute("userEditCommand")EditCommander e, BindingResult br,HttpServletRequest request, HttpServletResponse response, Model m, HttpSession session) {
		try {
			System.out.println(br);
			User userDetailsToEdit = userService.getUserDetailsToEdit(e.getId()); 
			long userByEmailId = userService.getUserByEmailId(e.getEmail());
			long loggedInUserId = (long) session.getAttribute("id");
			if(br.hasErrors() || (userByEmailId!=0 && (userDetailsToEdit.getId()!= userByEmailId) ) )  
	        {
				if((userByEmailId!=0 && (userDetailsToEdit.getId()!= userByEmailId))){
					m.addAttribute("EmailError", "Email is already registerd!");
				}
	            return "editUser";  
	        }  
			//check if the logged in user is editing its own details			
		    if(userDetailsToEdit.getId() == loggedInUserId) {
				 request.getSession().setAttribute("name",e.getName());
			 }
			 
			//Call to service
			boolean updateProcess = userService.updateUserProcess(e);
			if(updateProcess) {
				m.addAttribute("Message","Succesfully Updated!");
			} else {
				m.addAttribute("Message","Something went wrong!");
			}	
		}
		catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			return "exceptionPage";
		} 
			return "adminPage";
	  }  
	
}
