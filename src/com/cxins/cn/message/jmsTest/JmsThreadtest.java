package com.cxins.cn.message.jmsTest;

import java.util.concurrent.CountDownLatch;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class JmsThreadtest {
    
	public static void main(String[] args) throws InterruptedException {  
		CountDownLatch latch=new CountDownLatch(3);
		Resquest res1=new Resquest("Tom request",latch,1000);
		Resquest res2=new Resquest("Jam request",latch,1500);
		Resquest res3=new Resquest("Andy request",latch,500);
		res1.start();
		res2.start();
		res3.start();
		latch.await();
		System.out.println("request finished ");  
	}
	
	static class Resquest extends Thread{  
        private String info;
        private JMSProducer producer=null;
        private CountDownLatch latch; 
        private int workTime;
        public Resquest(String info,CountDownLatch latch,int workTime){
        	this.info=info;
        	this.producer=new JMSProducer();
        	this.latch=latch;  
        	this.workTime=workTime;
        }
        public void run(){  
             try {
            	System.out.println(info+" open");
//            	for(int i=1;i<7;i++){
//            		producer.send(info+i);
//            		try {
//						Thread.sleep(workTime);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}  
//            	}
				producer.open();
            	for(int i=1;i<7;i++){
            		producer.sendMessage(info+i);
            		try {
						Thread.sleep(workTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
            	}
				producer.close();
				System.out.println(info+" close");
				latch.countDown();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
        }  
           
    }  
	
}
