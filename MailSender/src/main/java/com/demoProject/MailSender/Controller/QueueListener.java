package com.demoProject.MailSender.Controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.demo.Entity.MailObject;
import com.demoProject.MailSender.Service.MailSenderService;

@Component
public class QueueListener {
	
	@Autowired
	MailSenderService mailSender;
	
	@JmsListener(destination = "MailQueue")
	public void receiveMessage(final Message jsonMessage) throws JMSException {
		String messageData = null;
		System.out.println("Received message " + jsonMessage);
		if(jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			messageData = textMessage.getText();
			System.out.println(messageData);
		} else if(jsonMessage instanceof ObjectMessage) {
			
			try {
				ObjectMessage objMsg = (ObjectMessage) jsonMessage;
				Object obj = objMsg.getObject();
				MailObject user = (MailObject)obj;
				mailSender.sendEmail(user);
			} catch (JMSException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
