
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

    private final static QName _BuscarProductos_QNAME = new QName("https://franl2p.wordpress.com/", "buscarProductos");
    private final static QName _BuscarProductoPorIdResponse_QNAME = new QName("https://franl2p.wordpress.com/", "buscarProductoPorIdResponse");
    private final static QName _BuscarProductoPorId_QNAME = new QName("https://franl2p.wordpress.com/", "buscarProductoPorId");
    private final static QName _BuscarProductosResponse_QNAME = new QName("https://franl2p.wordpress.com/", "buscarProductosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.grails.cxf.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscarProductoPorIdResponse }
     * 
     */
    public BuscarProductoPorIdResponse createBuscarProductoPorIdResponse() {
        return new BuscarProductoPorIdResponse();
    }

    /**
     * Create an instance of {@link BuscarProductos }
     * 
     */
    public BuscarProductos createBuscarProductos() {
        return new BuscarProductos();
    }

    /**
     * Create an instance of {@link BuscarProductoPorId }
     * 
     */
    public BuscarProductoPorId createBuscarProductoPorId() {
        return new BuscarProductoPorId();
    }

    /**
     * Create an instance of {@link BuscarProductosResponse }
     * 
     */
    public BuscarProductosResponse createBuscarProductosResponse() {
        return new BuscarProductosResponse();
    }

    /**
     * Create an instance of {@link ProductoData }
     * 
     */
    public ProductoData createProductoData() {
        return new ProductoData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://franl2p.wordpress.com/", name = "buscarProductos")
    public JAXBElement<BuscarProductos> createBuscarProductos(BuscarProductos value) {
        return new JAXBElement<BuscarProductos>(_BuscarProductos_QNAME, BuscarProductos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductoPorIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://franl2p.wordpress.com/", name = "buscarProductoPorIdResponse")
    public JAXBElement<BuscarProductoPorIdResponse> createBuscarProductoPorIdResponse(BuscarProductoPorIdResponse value) {
        return new JAXBElement<BuscarProductoPorIdResponse>(_BuscarProductoPorIdResponse_QNAME, BuscarProductoPorIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductoPorId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://franl2p.wordpress.com/", name = "buscarProductoPorId")
    public JAXBElement<BuscarProductoPorId> createBuscarProductoPorId(BuscarProductoPorId value) {
        return new JAXBElement<BuscarProductoPorId>(_BuscarProductoPorId_QNAME, BuscarProductoPorId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://franl2p.wordpress.com/", name = "buscarProductosResponse")
    public JAXBElement<BuscarProductosResponse> createBuscarProductosResponse(BuscarProductosResponse value) {
        return new JAXBElement<BuscarProductosResponse>(_BuscarProductosResponse_QNAME, BuscarProductosResponse.class, null, value);
    }

}
