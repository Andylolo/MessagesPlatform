package com.cxins.cn.message.webserviceTest;

public class MyWebserviceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 HelloWorldServiceService ss = new HelloWorldServiceService();
	     HelloWorldService port = ss.getHelloWorldServicePort(); 
	     System.out.println(port.beginWork("give me five","nice"));

	     
	     //核心系统 JDK1.5 环境中解决方案
//	        try {  
	            //访问方式1 correct
//				String url = "http://10.167.10.88:8080/MessagesPlatform/HelloWorldService?wsdl" ;  
//				Client client = new Client(new URL(url));
////				String result = (String) client.invoke("beginWork",  
////	                    new Object[] {"张三丰"})[0];
//				Object[] name = new Object[] {"Time","Andy"};
//				Object[] result1 =  client.invoke("beginWork",name); 
//				for(Object a:result1){
//					System.out.println(a.toString()+" | ");
//				}
				
				
				//System.out.println(result1+" "+result);
				
	        	//visit method two：Could not invoke service.. Nested exception is org.codehaus.xfire.fault.XFireFault: Message part {http://DefaultNamespace}sayHello was not recognized.  (Does it exist in service WSDL?)
//				String url = "http://10.167.10.88:8080/MessagesPlatform/HelloWorldService";  
//		        Service service = new ObjectServiceFactory().create(HelloWorldService.class) ;  
//		        XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire()) ;  
//		        HelloWorldService send = (HelloWorldService) factory.create(service,url) ;  
//		        String str1=send.sayHello("Andy");
//		        String str2=send.beginWork("开始工作");
//		        System.out.println(str1+" "+str2);
				
				//java.lang.NoClassDefFoundError: javax.jws.WebService
//	        	Service serviceModel = new AnnotationServiceFactory().create(HelloWorldService.class);
//	        	HelloWorldService client = (HelloWorldService)new XFireProxyFactory().create(serviceModel, url);
//	        	System.out.println(client.beginWork("张无忌"));
	 
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
	}

}
