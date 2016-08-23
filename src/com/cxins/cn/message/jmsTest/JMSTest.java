package com.cxins.cn.message.jmsTest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.MessageCreator;

import com.cxins.cn.message.jms.JMSSender;
import com.cxins.cn.message.utils.ApplicationContextUtil;


public class JMSTest {
	 public static void main(String[] args) {
	        JMSSender jmsSender = (JMSSender)ApplicationContextUtil.getBean("sender");
     
	        while (true) {
	            // jmsSender.sendMessage();
	            jmsSender.getJmsTemplate().send(new MessageCreator(){
	            public Message createMessage(Session session) throws JMSException {
	                TextMessage message = session.createTextMessage();
	                message.setText("张三");
	               System.out.println("--------发送消息：张三");
	                return message;
	            }
	        });
	            System.out.println("done sending message");
	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
