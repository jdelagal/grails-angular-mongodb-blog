package catalogo

import grails.transaction.Transactional
import org.grails.cxf.soap.BPELInventario
import org.apache.cxf.frontend.ClientProxyFactoryBean
import org.grails.cxf.soap.InventarioRequest
import org.grails.cxf.soap.InventarioResponse

import org.apache.cxf.endpoint.Client
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.transport.http.HTTPConduit
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy

@Transactional
class ProxyService {
    long connectionTimeOut = 10000L

    def callSOA() {
        
    	ClientProxyFactoryBean factory = new JaxWsProxyFactoryBean()
        factory.setServiceClass(BPELInventario.class)


        Properties props = new Properties()
        File propsFile = new File('application.properties')
        props.load(propsFile.newDataInputStream())

        def bpel_inventario_client_ep = props.getProperty('bpel_inventario_client_ep')
        factory.setAddress("${bpel_inventario_client_ep}")
        def service = (BPELInventario) factory.create()
        Client client = ClientProxy.getClient(service)
        HTTPConduit http = (HTTPConduit) client.getConduit()

        def username = props.getProperty('username')
        def password = props.getProperty('password')
        def proxyhost = props.getProperty('proxyhost')
        
        http.getProxyAuthorization().setUserName("${username}")
        http.getProxyAuthorization().setPassword("${password}")
        HTTPClientPolicy httpClientPolicy = http.getClient(); 

        setUpClientProperties("${proxyhost}", 8080, httpClientPolicy, connectionTimeOut)

		InventarioRequest req = new InventarioRequest()    
		req.setCodigoProducto('codigo1')  
		req.setNombreProducto('nombre1')  
		req.setCategoria('categoria1')  


		InventarioResponse res = service.process(req)
        def descripcion = res.getDetalle()

        println "detalle: ${detalle}"
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
