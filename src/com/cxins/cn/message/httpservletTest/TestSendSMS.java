package com.cxins.cn.message.httpservletTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class TestSendSMS {

	
	
	public String dd(String message){
		 
		  String url = "http://localhost:8080/MessagesPlatform/httpServer?message="+ message;
		  URL httpTest;
		  String resultMsg = null;
		  try {
		   message = URLEncoder.encode(message, "utf-8");
		   httpTest = new URL(url);
	       HttpURLConnection httpURLConnection = (HttpURLConnection)httpTest.openConnection();
	       httpURLConnection.connect();
	       System.out.println("返回连接状态："+httpURLConnection.getResponseCode());//200表示成功
		   BufferedReader in;
		   try {
		    in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		    String inputLine = null;
		    //得到返回信息的xml字符串
		    while ((inputLine = in.readLine()) != null)
		     if(resultMsg != null){
		      resultMsg += inputLine;
		     }else {
		      resultMsg = inputLine;
		     }
		    System.out.println("resultMsg:"+resultMsg);
		    in.close();
			httpURLConnection.disconnect();
		   } catch (MalformedURLException e) {
		    e.printStackTrace();
		   }
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	
		  return resultMsg;
	}
	public static void main(String[] args) {
		TestSendSMS sms=new TestSendSMS();
		//Server returned HTTP response code: 505 中间不可有空格
		sms.dd("这是log1测试消息");
		
		//到核心系统出现的编码问题解决方案
//      Jmstest sms=new Jmstest();
        //Server returned HTTP response code: 505 中间不可有空格
//        sms.dd("你妈喊你回家吃");		    //单数会出问题，需输入双数，原因在于已经被解码过的在返回去会出现不对应的情况
		//String s="给我一个吻";
	    //String b=URLDecoder.decode(URLEncoder.encode(s, "UTF-8"),"GB18030");	    
		//System.out.println(b);
       
		// String sa =URLDecoder.decode(URLEncoder.encode(b,"GB18030"),"UTF-8");
        
        //System.out.println(sa);

        //System.out.println("resultMsg:"+URLDecoder.decode(URLEncoder.encode(resultMsg,"GB18030"),"UTF-8"));
		//解析编码过程  中文--->UTF编码--->服务中以UTF-8解码--->汉字返回以UTF-8编码以GB18030解码
		//系统解析编码：GB18030
	}

}
