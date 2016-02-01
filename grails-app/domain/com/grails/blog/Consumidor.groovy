package com.grails.blog


class Consumidor {

	String consumidor
    String responsableConsumidor
    String emailContacto
    String canal
    String estado
    /*
    static hasMany = [necesidades: Necesidad, estados: EstadoConsumidor]
    static belongsTo = [servicio: Servicio]

    static constraints = {
		consumidor blank: false, unique: true
	}
	*/
}
