package com.grails.blog.admin

import com.grails.blog.Servicio
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class ServicioController {
    def springSecurityService

    static namespace = 'adminV1'
    static responseFormats = ['json', 'xml']
    static allowedMethods = [index: "GET"]

    def index(Integer max, Integer offset) {
        params.max = Math.min(max ?: 40, 50)
        params.offset = offset?:0
        def servicioList = Servicio.findAll()

        //respond servicioList.collect{it as Servicio}
        respond servicioList.collect{it as Servicio}
    }
}

