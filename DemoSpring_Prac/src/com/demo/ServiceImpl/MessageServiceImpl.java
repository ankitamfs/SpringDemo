package com.demo.ServiceImpl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.demo.Entity.MailObject;
import com.demo.ServiceInf.MessageSenderInf;

@Service
public class MessageServiceImpl implements MessageSenderInf{
	@Autowired
    JmsTemplate jmsTemplate;
	
	@Override
    public void sendMessage(MailObject obj) {
 
        jmsTemplate.send(new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(obj);
                    return objectMessage;
                }
            });
    }
}
