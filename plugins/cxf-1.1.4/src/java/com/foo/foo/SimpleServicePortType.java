package com.foo.foo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2014-05-08T09:46:05.186-05:00
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://demo.client.cxf/", name = "SimpleServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface SimpleServicePortType {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "simpleMethod2", targetNamespace = "http://demo.client.cxf/", className = "com.foo.foo.SimpleMethod2")
    @WebMethod
    @ResponseWrapper(localName = "simpleMethod2Response", targetNamespace = "http://demo.client.cxf/", className = "com.foo.foo.SimpleMethod2Response")
    public com.foo.foo.SimpleResponse simpleMethod2(
        @WebParam(name = "request", targetNamespace = "")
        com.foo.foo.SimpleRequest request
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "simpleMethod1", targetNamespace = "http://demo.client.cxf/", className = "com.foo.foo.SimpleMethod1")
    @WebMethod
    @ResponseWrapper(localName = "simpleMethod1Response", targetNamespace = "http://demo.client.cxf/", className = "com.foo.foo.SimpleMethod1Response")
    public com.foo.foo.SimpleResponse simpleMethod1(
        @WebParam(name = "request", targetNamespace = "")
        com.foo.foo.SimpleRequest request
    );
}
