
package org.grails.cxf.soap.servicio;

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

    private final static QName _UpdateServicioByEstado_QNAME = new QName("http://www.msssi.es/catalogo/base/", "updateServicioByEstado");
    private final static QName _UpdateServicioByEstadoResponse_QNAME = new QName("http://www.msssi.es/catalogo/base/", "updateServicioByEstadoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.grails.cxf.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateServicioByEstadoResponse }
     * 
     */
    public UpdateServicioByEstadoResponse createUpdateServicioByEstadoResponse() {
        return new UpdateServicioByEstadoResponse();
    }

    /**
     * Create an instance of {@link UpdateServicioByEstado }
     * 
     */
    public UpdateServicioByEstado createUpdateServicioByEstado() {
        return new UpdateServicioByEstado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateServicioByEstado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.msssi.es/catalogo/base/", name = "updateServicioByEstado")
    public JAXBElement<UpdateServicioByEstado> createUpdateServicioByEstado(UpdateServicioByEstado value) {
        return new JAXBElement<UpdateServicioByEstado>(_UpdateServicioByEstado_QNAME, UpdateServicioByEstado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateServicioByEstadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.msssi.es/catalogo/base/", name = "updateServicioByEstadoResponse")
    public JAXBElement<UpdateServicioByEstadoResponse> createUpdateServicioByEstadoResponse(UpdateServicioByEstadoResponse value) {
        return new JAXBElement<UpdateServicioByEstadoResponse>(_UpdateServicioByEstadoResponse_QNAME, UpdateServicioByEstadoResponse.class, null, value);
    }

}
