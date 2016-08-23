package com.cxins.cn.message.jms;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class JMSReceiver implements MessageListener,ExceptionListener {
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	public JMSReceiver() {
		
    }
	@Override
	public void onMessage(Message message) {
		 TextMessage text = (TextMessage)message;
	        try {
	            message.acknowledge();//Acknowledges all consumed messages of the session of this consumed message.
	            logger.info("received the following message: " + text.getText());
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	    }
	@Override
	public void onException(JMSException e) {
		// 用来处理连接异常，可重建连接，日志记录等
		logger.info("JMSException message: " + e.getMessage());
		
	}

}
