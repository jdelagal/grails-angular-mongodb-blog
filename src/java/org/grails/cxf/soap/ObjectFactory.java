
package org.grails.cxf.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.grails.cxf.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InventarioResponse_QNAME = new QName("http://blog.soa.ejemplos/Inventario", "inventarioResponse");
    private final static QName _InventarioRequest_QNAME = new QName("http://blog.soa.ejemplos/Inventario", "inventarioRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.grails.cxf.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InventarioRequest }
     * 
     */
    public InventarioRequest createInventarioRequest() {
        return new InventarioRequest();
    }

    /**
     * Create an instance of {@link InventarioResponse }
     * 
     */
    public InventarioResponse createInventarioResponse() {
        return new InventarioResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.soa.ejemplos/Inventario", name = "inventarioResponse")
    public JAXBElement<InventarioResponse> createInventarioResponse(InventarioResponse value) {
        return new JAXBElement<InventarioResponse>(_InventarioResponse_QNAME, InventarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventarioRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.soa.ejemplos/Inventario", name = "inventarioRequest")
    public JAXBElement<InventarioRequest> createInventarioRequest(InventarioRequest value) {
        return new JAXBElement<InventarioRequest>(_InventarioRequest_QNAME, InventarioRequest.class, null, value);
    }

}
