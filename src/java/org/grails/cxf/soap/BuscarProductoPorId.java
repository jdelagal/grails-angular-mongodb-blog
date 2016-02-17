
package org.grails.cxf.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para buscarProductoPorId complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="buscarProductoPorId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarProductoPorId", propOrder = {
    "productoId"
})
public class BuscarProductoPorId {

    protected String productoId;

    /**
     * Obtiene el valor de la propiedad productoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductoId() {
        return productoId;
    }

    /**
     * Define el valor de la propiedad productoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductoId(String value) {
        this.productoId = value;
    }

}
