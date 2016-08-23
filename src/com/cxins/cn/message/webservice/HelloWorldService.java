package com.cxins.cn.message.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.springframework.web.context.ContextLoader;
import com.cxins.cn.message.jms.JMSSender;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloWorldService{

	 @WebMethod
	 public String beginWork(String info,String ho){		 
		 JMSSender producer=(JMSSender)ContextLoader.getCurrentWebApplicationContext().getBean("sender");
		 producer.sendMessage(info);
		 return "Thank you i got a message now ："+info +" and "+ho;
	 }
	@WebMethod
	public String sayHello(String arg0) {
		 return arg0 + "说:这是我的第一个web 服务";
	}


}
