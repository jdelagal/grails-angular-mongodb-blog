package catalogo

import grails.transaction.Transactional

import javax.jws.WebService

import org.grails.cxf.soap.servicio.ServicioServices
import org.grails.cxf.soap.servicio.UpdateServicioByEstado
import org.grails.cxf.soap.servicio.UpdateServicioByEstadoResponse

import org.grails.cxf.utils.EndpointType


@Transactional
@WebService(targetNamespace = 'http://www.msssi.es/catalogo/base/ServicioServices',
    name = 'UpdateDatosServicioService',
    serviceName = 'UpdateDatosServicioService',
    portName = 'ServicioServices')
class UpdateDatosServicioService implements ServicioServices {
    
    static expose = EndpointType.JAX_WS_WSDL
    static soap12 = true
    static address = 'ServicioServices'

  void updateServicioByEstado(java.lang.String p1, javax.xml.ws.Holder<java.lang.String> p2, 
  							javax.xml.ws.Holder<java.lang.String> p3){
  	println "updateServicioByEstado"
  }
}