package catalogo

import grails.transaction.Transactional

import org.grails.cxf.soap.estado.EstadoServicioPortType
import org.grails.cxf.soap.estado.Start
import org.grails.cxf.soap.estado.EstadoType
import org.grails.cxf.soap.estado.ObjectFactory
import org.grails.cxf.soap.estado.MensajeBaseType
import org.grails.cxf.soap.estado.EstadoServicioPortTypeCallBack
import org.grails.cxf.soap.estado.EndResponse

import org.apache.cxf.frontend.ClientProxyFactoryBean
import org.apache.cxf.endpoint.Client
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.transport.http.HTTPConduit
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy

@Transactional
class SolicitudServicioService {

    long connectionTimeOut = 10000L

    def callSolicitudServicio() {
        
    	ClientProxyFactoryBean factory = new JaxWsProxyFactoryBean()
        factory.setServiceClass(EstadoServicioPortType.class)


        Properties props = new Properties()
        File propsFile = new File('application.properties')
        props.load(propsFile.newDataInputStream())

        def estadoServicio = props.getProperty('estadoServicio')
        factory.setAddress("${estadoServicio}")
        def service = (EstadoServicioPortType) factory.create()
        Client client = ClientProxy.getClient(service)
        HTTPConduit http = (HTTPConduit) client.getConduit()
        /*
        def username = props.getProperty('username')
        def password = props.getProperty('password')
        def proxyhost = props.getProperty('proxyhost')
        
        http.getProxyAuthorization().setUserName("${username}")
        http.getProxyAuthorization().setPassword("${password}")
        */
        HTTPClientPolicy httpClientPolicy = http.getClient(); 

        //setUpClientProperties("${proxyhost}", 8080, httpClientPolicy, connectionTimeOut)
        setUpClientProperties(null, null, httpClientPolicy, connectionTimeOut)

		Start req = new Start()   
		EstadoType estadoType = new EstadoType()
		estadoType.setID("3")  
		estadoType.setFecha("fecha")
		estadoType.setUsuario("admin")
		estadoType.setEstado("Solicitud")
		estadoType.setMensaje("mensaje")
		req.setInitialRequest(estadoType)

		EndResponse res = service.start(req)
        //EstadoType estadoTypeRes = res.getFinalResponse()
        //def mensaje = estadoTypeRes.getMensaje

        //println "mensaje: ${mensaje}"
    }


    def setUpClientProperties(String proxyHost, Integer proxyPort, HTTPClientPolicy httpClientPolicy, long timeout) { 
        httpClientPolicy.setReceiveTimeout(timeout); 
        httpClientPolicy.setAllowChunking(false); 
        httpClientPolicy.setConnectionTimeout(timeout); 
        httpClientPolicy.setAcceptEncoding("UTF-8"); 
        if (proxyHost != null && proxyPort != null){ 
            httpClientPolicy.setProxyServer(proxyHost); 
            httpClientPolicy.setProxyServerPort(proxyPort); 
        } 
    } 
}
