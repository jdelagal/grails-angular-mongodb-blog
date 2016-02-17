package catalogo

import grails.transaction.Transactional

import javax.jws.WebService

import org.grails.cxf.soap.ProductoData
import org.grails.cxf.soap.ProductosServices
import org.grails.cxf.utils.EndpointType

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
    
    def List<ProductoData> buscarProductos(String nombre) {
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