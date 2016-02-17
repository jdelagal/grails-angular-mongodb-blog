package catalogo

import grails.transaction.Transactional

import javax.jws.WebService

import org.grails.cxf.soap.ProductoData
import org.grails.cxf.soap.ProductosServices
import org.grails.cxf.utils.EndpointType

import org.grails.cxf.soap.BPELInventario
import org.apache.cxf.frontend.ClientProxyFactoryBean
import org.grails.cxf.soap.InventarioRequest
import org.grails.cxf.soap.InventarioResponse

@Transactional
@WebService(targetNamespace = 'https://franl2p.wordpress.com/ProductosServices',
    name = 'ProductosService',
    serviceName = 'ProductosService',
    portName = 'ProductosServices')
class ProductosService implements ProductosServices {
    
    static expose = EndpointType.JAX_WS_WSDL
    static soap12 = true
    static address = 'ProductosServices'

    def serviceMethod() {

    }

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
    
    def List<ProductoData> buscarProductos(String nombre) {
    	callSOA()
        List<ProductoData> lista = new LinkedList<ProductoData>();
        
        lista.add(crearProducto())
        lista
    }

    def ProductoData buscarProductoPorId(String productoId) {
        productoId == '001' ? crearProducto() : null;
    }
    
    def ProductoData crearProducto() {
        ProductoData producto = new ProductoData()
        
        producto.setProductoId('001')
        producto.setNombre('Blog')
        producto.setDescripcion('https://franl2p.wordpress.com')
        
        producto
    }
}