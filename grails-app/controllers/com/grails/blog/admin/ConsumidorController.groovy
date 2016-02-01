package com.grails.blog.admin

import com.grails.blog.Consumidor
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class ConsumidorController {
    
    def springSecurityService

    static namespace = 'adminV1'
    static responseFormats = ['json', 'xml']
    static allowedMethods = [delete: "DELETE", save: "POST", update: "PUT"]

    def index() {
        def consumidorList = Consumidor.findAll()

        respond consumidorList.collect{it as Consumidor}.sort {
            it.consumidor
        }
    }

    def show(String id) {
        Consumidor consumidorList = Consumidor.findById(id) as Consumidor
        respond consumidorList, [excludes: ['class']]
    }    

    @Transactional
    def delete(Consumidor paramList) {
        if (paramList == null) {
            notFound()
            return
        }
        paramList.delete()
        render status: NO_CONTENT
    }    

    @Transactional
    def save(Consumidor consumidorInstance) {
        if (consumidorInstance == null) {
            notFound()
            return
        }

        if (consumidorInstance.hasErrors()) {
            respond consumidorInstance.errors, view:'create'
            return
        }

        consumidorInstance.save flush:true

        respond consumidorInstance, [status: CREATED]
    }    


    @Transactional
    def update(Consumidor consumidorInstance) {
        if (consumidorInstance == null) {
            notFound()
            return
        }

        if (consumidorInstance.hasErrors()) {
            respond consumidorInstance.errors, view:'edit'
            return
        }

        consumidorInstance.save flush:true

        respond consumidorInstance, [status: OK]
    }

    protected void notFound() {
        render status: NOT_FOUND
    }    

}

