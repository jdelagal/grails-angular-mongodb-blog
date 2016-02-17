package catalogo

import grails.transaction.Transactional
import org.grails.cxf.soap.BPELInventario
import org.apache.cxf.frontend.ClientProxyFactoryBean
import org.grails.cxf.soap.InventarioRequest
import org.grails.cxf.soap.InventarioResponse

@Transactional
class ProxyService {

    def callSOA() {
    	ClientProxyFactoryBean factory = new ClientProxyFactoryBean()
        factory.setServiceClass(BPELInventario.class)
        factory.setAddress("http://94656m.sanidad.msc:8001/soa-infra/services/default/InventarioProyect!1.0*soa_0be81abf-2515-4dda-bcd2-916bf49dba53/bpel_inventario_client_ep")
        BPELInventario client = (BPELInventario) factory.create()
		InventarioRequest req = new InventarioRequest()    
		req.setCodigoProducto('codigo1')  
		req.setNombreProducto('nombre1')  
		req.setCategoria('categoria1')  
		InventarioResponse res = client.process(req)
    }
}
