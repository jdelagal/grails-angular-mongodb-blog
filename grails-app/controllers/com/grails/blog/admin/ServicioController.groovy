package com.grails.blog.admin

import com.grails.blog.Servicio
import grails.transaction.Transactional
/*
import org.grails.cxf.soap.ProductosServices
import org.apache.cxf.frontend.ClientProxyFactoryBean;
*/
import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class ServicioController {
    
    def springSecurityService
    /*prueba llamada a ProductosService.groovy
    def productosService
    
    def proxyService
   
    def solicitudServicioService
    */
    static namespace = 'adminV1'
    static responseFormats = ['json', 'xml']
    static allowedMethods = [delete: "DELETE", save: "POST", update: "PUT"]

    //def index(Integer max, Integer offset) {
    //    params.max = Math.min(max ?: 40, 50)
    //    params.offset = offset?:0
    def index() {
        def servicioList = Servicio.findAll()

        /*prueba llamada a ProductosService.groovy
        proxyService.callSOA()
        */
        
        respond servicioList.collect{it as Servicio}.sort {
            it.servicio
        }
    }

    def show(String id) {
        Servicio servicioInstance = Servicio.findById(id) as Servicio
        respond servicioInstance, [excludes: ['class']]
    }    

    @Transactional
    def delete(Servicio paramList) {
        if (paramList == null) {
            notFound()
            return
        }
        paramList.delete()
        render status: NO_CONTENT
    }    

    @Transactional
    def save(Servicio servicioInstance) {
        if (servicioInstance == null) {
            notFound()
            return
        }

        if (servicioInstance.hasErrors()) {
            respond servicioInstance.errors, view:'create'
            return
        }

        servicioInstance.save flush:true

        respond servicioInstance, [status: CREATED]
        /*
        solicitudServicioService.callSolicitudServicio(servicioInstance.servicio)
        */
    }    


    @Transactional
    def update(Servicio servicioInstance) {
        if (servicioInstance == null) {
            notFound()
            return
        }

        if (servicioInstance.hasErrors()) {
            respond servicioInstance.errors, view:'edit'
            return
        }

        servicioInstance.save flush:true

        respond servicioInstance, [status: OK]
    }

    protected void notFound() {
        render status: NOT_FOUND
    }    

}

