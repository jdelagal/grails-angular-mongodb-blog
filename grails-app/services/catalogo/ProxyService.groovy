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
        factory.setAddress("http://94656m.sanidad.msc:8001/soa-infra/services/default/InventarioProyect!1.0*soa_0be81abf-2515-4dda-bcd2-916bf49dba53/bpel_inventario_client_ep")
        def service = (BPELInventario) factory.create()
        Client client = ClientProxy.getClient(service)
        HTTPConduit http = (HTTPConduit) client.getConduit()
        http.getProxyAuthorization().setUserName('jdelagala')
        http.getProxyAuthorization().setPassword('Zamarro25')
        HTTPClientPolicy httpClientPolicy = http.getClient(); 
        http.getClient().setProxyServer('proxy-sanidad.msc.es')
        http.getClient().setProxyServerPort(8080)

        setUpClientProperties('proxy-sanidad.msc.es', 8080, httpClientPolicy, connectionTimeOut)

		InventarioRequest req = new InventarioRequest()    
		req.setCodigoProducto('codigo1')  
		req.setNombreProducto('nombre1')  
		req.setCategoria('categoria1')  

        
		InventarioResponse res = service.process(req)
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
