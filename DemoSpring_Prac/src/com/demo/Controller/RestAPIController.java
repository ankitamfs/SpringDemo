package com.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.User;
import com.demo.Entity.UserDTO;
import com.demo.Entity.UserDTO2;
import com.demo.ServiceImpl.UserServiceImpl;

@RestController
public class RestAPIController {
	
	@Autowired
	UserServiceImpl userService;
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id){
		UserDTO user = userService.getUserDetailsById(id);
		System.out.println(user);
		if(user == null) {
			 return new ResponseEntity("User with id " + id 
	                    + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	/*
	 * @RequestMapping(value = "/userRM/{id}", method = RequestMethod.GET) public
	 * ResponseEntity<?> getUserRM(@PathVariable("id") long id){ User user =
	 * userService.getUserDetailsByIdRM(id); System.out.println(user); if(user ==
	 * null) { return new ResponseEntity("User with id " + id + " not found",
	 * HttpStatus.NOT_FOUND); } return new ResponseEntity<User>(user,
	 * HttpStatus.OK); }
	 */
	
	@RequestMapping(value = "/getallUsers", method = RequestMethod.GET)
	public List<UserDTO2> getAllUserRM(){
		return (List<UserDTO2>) userService.getAllUserDetailsRM();
	}
	
	
	
}
