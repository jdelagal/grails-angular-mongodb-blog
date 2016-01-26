package com.grails.blog.admin

import com.grails.blog.Dominio
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class DominioController {
    
    def springSecurityService

    static namespace = 'adminV1'
    static responseFormats = ['json', 'xml']
    static allowedMethods = [delete: "DELETE", save: "POST", update: "PUT"]

    def index() {
        def dominioList = Dominio.findAll()

        respond dominioList.collect{it as Dominio}.sort {
            it.dominio
        }
    }

    @Transactional
    def delete(Dominio paramList) {
        if (paramList == null) {
            notFound()
            return
        }
        paramList.delete()
        render status: NO_CONTENT
    }  

    protected void notFound() {
        render status: NOT_FOUND
    }    

}

