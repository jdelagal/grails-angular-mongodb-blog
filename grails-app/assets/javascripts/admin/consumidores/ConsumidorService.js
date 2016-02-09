'use strict';

/* Consumidores */

var consumidorService = angular.module('gambApp');

consumidorService.factory('ConsumidorApi', ['$resource',
    function ($resource) {
        return {
			Consumidor: $resource('v1/consumidores/:consumidorId', {consumidorId: '@id'},{
                'update': { method: 'PUT' }
            })
        };
    }]);