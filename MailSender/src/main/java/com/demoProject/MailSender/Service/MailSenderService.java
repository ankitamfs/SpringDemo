package com.demoProject.MailSender.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.demo.Entity.MailObject;

@Service
public class MailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String email; 
	
	public void sendEmail(MailObject user) {
	    SimpleMailMessage msg = new SimpleMailMessage();
	    msg.setTo(email);
	
	    msg.setSubject(user.getHeader());
	    msg.setText(user.getBody());
	
	    javaMailSender.send(msg);
	}
}
