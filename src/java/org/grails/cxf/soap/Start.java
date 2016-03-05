
package org.grails.cxf.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.msssi.es/catalogo/base}InitialRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "initialRequest"
})
@XmlRootElement(name = "start", namespace = "http://xmlns.oracle.com/bpmn/bpmnProcess/EstadoServicio")
public class Start {

    @XmlElement(name = "InitialRequest", required = true)
    protected EstadoType initialRequest;

    /**
     * Gets the value of the initialRequest property.
     * 
     * @return
     *     possible object is
     *     {@link EstadoType }
     *     
     */
    public EstadoType getInitialRequest() {
        return initialRequest;
    }

    /**
     * Sets the value of the initialRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoType }
     *     
     */
    public void setInitialRequest(EstadoType value) {
        this.initialRequest = value;
    }

}
