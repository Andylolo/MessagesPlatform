package com.cxins.cn.message.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cxins.cn.message.jms.JMSSender;

public class SmsHTTPServer extends HttpServlet {

	/**
	 * 
	 */
	private JMSSender jmssender;
	private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(this.getClass().getName());
	//private Logger logger = Logger.getLogger(this.getClass().getName());
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("GB18030");//核心系统编码
        PrintWriter out = response.getWriter();
        String message = request.getParameter("message");
        logger.info("http receive message:"+message);
        if (message == null || "".equals(message) || message.length() <= 0) {
     //    logger.info("http call failed,参数短信描述信息message不能为空,程序退出");
        }else{
     //    logger.info("message:"+message);
    //     JSONObject obj = JSONObject.fromObject(message);
    //     SendMessage peopleinfo = (SendMessage) JSONObject.toBean(obj,SendMessage.class);
 
 		 out.append(message);
 		 ServletContext servletContext = this.getServletContext();  
 	     WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(servletContext);  
 	     jmssender = (JMSSender) context.getBean("sender"); 
 	     jmssender.sendMessage(message);
 	     logger.info("---http call success---");
        }
        out.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //	logger.info("进入post--------------");
        this.doGet(request, response);
    }
	public JMSSender getJmssender() {
		return jmssender;
	}
	public void setJmssender(JMSSender jmssender) {
		this.jmssender = jmssender;
	}

    
    
}
    
	
	
	

