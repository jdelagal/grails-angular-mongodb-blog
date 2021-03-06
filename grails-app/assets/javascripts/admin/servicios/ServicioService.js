'use strict';

/* Services */

var servicioService = angular.module('gambApp');

servicioService.factory('ServicioApi', ['$resource',
    function ($resource) {
        return {
			Servicio: $resource('v1/servicios/:servicioId', {servicioId: '@id'},{
                'update': { method: 'PUT' }
            })
        };
    }]);