package com.cxins.cn.message.webserviceTest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2016-08-19T11:22:34.962+08:00
 * Generated source version: 2.5.0
 * 
 */
@WebService(targetNamespace = "http://webservice.message.cn.cxins.com/", name = "HelloWorldService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorldService {

    @WebResult(name = "return", targetNamespace = "http://webservice.message.cn.cxins.com/", partName = "return")
    @WebMethod
    public java.lang.String sayHello(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "http://webservice.message.cn.cxins.com/", partName = "return")
    @WebMethod
    public java.lang.String beginWork(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        java.lang.String arg1
    );
}
