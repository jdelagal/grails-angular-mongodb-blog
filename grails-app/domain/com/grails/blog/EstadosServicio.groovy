package com.grails.blog


class EstadosServicio {

	String estado


    static constraints = {
        estado blank: false, unique: true
    }
}
