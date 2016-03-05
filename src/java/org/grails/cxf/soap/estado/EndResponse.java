
package org.grails.cxf.soap.estado;

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
 *         &lt;element ref="{http://www.msssi.es/catalogo/base}FinalResponse"/>
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
    "finalResponse"
})
@XmlRootElement(name = "endResponse", namespace = "http://xmlns.oracle.com/bpmn/bpmnProcess/EstadoServicio")
public class EndResponse {

    @XmlElement(name = "FinalResponse", required = true)
    protected EstadoType finalResponse;

    /**
     * Gets the value of the finalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link EstadoType }
     *     
     */
    public EstadoType getFinalResponse() {
        return finalResponse;
    }

    /**
     * Sets the value of the finalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoType }
     *     
     */
    public void setFinalResponse(EstadoType value) {
        this.finalResponse = value;
    }

}
