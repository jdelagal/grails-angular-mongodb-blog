package com.grails.blog


class Servicio {

	String servicio
    String responsableServicio
    String emailContacto
    String estado


    /*
    static hasMany = [entregable: Entregable, consumidor: Consumidor, estado: EstadoServicio]
    static belongsTo = [dominio: Dominio]

    static constraints = {
		servicio blank: false, unique: true
	}
	*/
}
