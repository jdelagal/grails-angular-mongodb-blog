
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

    private final static QName _IntermediateRequest_QNAME = new QName("http://www.msssi.es/catalogo/base", "IntermediateRequest");
    private final static QName _FinalResponse_QNAME = new QName("http://www.msssi.es/catalogo/base", "FinalResponse");
    private final static QName _InitialRequest_QNAME = new QName("http://www.msssi.es/catalogo/base", "InitialRequest");
    private final static QName _ID_QNAME = new QName("http://www.msssi.es/catalogo/base", "ID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.grails.cxf.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Start }
     * 
     */
    public Start createStart() {
        return new Start();
    }

    /**
     * Create an instance of {@link EstadoType }
     * 
     */
    public EstadoType createEstadoType() {
        return new EstadoType();
    }

    /**
     * Create an instance of {@link EndResponse }
     * 
     */
    public EndResponse createEndResponse() {
        return new EndResponse();
    }

    /**
     * Create an instance of {@link MensajeBaseType }
     * 
     */
    public MensajeBaseType createMensajeBaseType() {
        return new MensajeBaseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.msssi.es/catalogo/base", name = "IntermediateRequest")
    public JAXBElement<EstadoType> createIntermediateRequest(EstadoType value) {
        return new JAXBElement<EstadoType>(_IntermediateRequest_QNAME, EstadoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.msssi.es/catalogo/base", name = "FinalResponse")
    public JAXBElement<EstadoType> createFinalResponse(EstadoType value) {
        return new JAXBElement<EstadoType>(_FinalResponse_QNAME, EstadoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.msssi.es/catalogo/base", name = "InitialRequest")
    public JAXBElement<EstadoType> createInitialRequest(EstadoType value) {
        return new JAXBElement<EstadoType>(_InitialRequest_QNAME, EstadoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.msssi.es/catalogo/base", name = "ID")
    public JAXBElement<String> createID(String value) {
        return new JAXBElement<String>(_ID_QNAME, String.class, null, value);
    }

}
