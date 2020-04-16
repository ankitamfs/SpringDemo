package com.demo.ServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	/*
	 * @Autowired private JavaMailSender mailSender;
	 * 
	 * @Autowired private SimpleMailMessage preConfiguredMessage;
	 */
	  
	  public void sendPreConfiguredMail(String message) 
	    {
		/*
		 * SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
		 * mailMessage.setText(message); mailSender.send(mailMessage);
		 */
	    }
}
