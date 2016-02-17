package org.grails.cxf.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2016-02-17T10:49:25.493+01:00
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "https://franl2p.wordpress.com/", name = "ProductosServices")
@XmlSeeAlso({ObjectFactory.class})
public interface ProductosServices {

    @WebResult(name = "productos", targetNamespace = "")
    @RequestWrapper(localName = "buscarProductos", targetNamespace = "https://franl2p.wordpress.com/", className = "org.grails.cxf.soap.BuscarProductos")
    @WebMethod
    @ResponseWrapper(localName = "buscarProductosResponse", targetNamespace = "https://franl2p.wordpress.com/", className = "org.grails.cxf.soap.BuscarProductosResponse")
    public java.util.List<org.grails.cxf.soap.ProductoData> buscarProductos(
        @WebParam(name = "nombre", targetNamespace = "")
        java.lang.String nombre
    );

    @WebResult(name = "producto", targetNamespace = "")
    @RequestWrapper(localName = "buscarProductoPorId", targetNamespace = "https://franl2p.wordpress.com/", className = "org.grails.cxf.soap.BuscarProductoPorId")
    @WebMethod
    @ResponseWrapper(localName = "buscarProductoPorIdResponse", targetNamespace = "https://franl2p.wordpress.com/", className = "org.grails.cxf.soap.BuscarProductoPorIdResponse")
    public org.grails.cxf.soap.ProductoData buscarProductoPorId(
        @WebParam(name = "productoId", targetNamespace = "")
        java.lang.String productoId
    );
}