package com.demoProject.MailSender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.MailObject;
import com.demoProject.MailSender.Service.MailSenderService;

@RestController
public class TestController {
	
	@Autowired
	MailSenderService mailSender;
	
	@RequestMapping(value ="/getUser/",method = RequestMethod.GET)
	public MailObject getUserByID() {
		//test Mail send
		MailObject user = new MailObject("ankita@gmail.com","Mail header","Mail Body");
		mailSender.sendEmail(user);
		return user;
	}
}

