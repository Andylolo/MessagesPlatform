package com.cxins.cn.message.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JMSSender {
    private JmsTemplate jmsTemplate;
    private Logger logger = Logger.getLogger(this.getClass().getName());
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public JMSSender() {
    }
     public void sendMessage(final String msg){
    	 getJmsTemplate().send(new MessageCreator(){
	            public Message createMessage(Session session) throws JMSException {
	                TextMessage message = session.createTextMessage();
	                message.setText(msg);
	                logger.info("send message: " + msg+" JMSMessageID:"+message.getJMSMessageID());
	                return message;
	            }
	        });
    	 //getJmsTemplate().convertAndSend(message);//传递对象
    	 //MapMessage extends Message
     }
	 public void sendMessage() {
	        getJmsTemplate().send(new MessageCreator(){
	            public Message createMessage(Session session) throws JMSException {
	                TextMessage message = session.createTextMessage();
	                message.setText("this is my jms test");
	                return message;
	            }
	        });
	    }
	
	
}
