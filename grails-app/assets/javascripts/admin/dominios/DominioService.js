'use strict';

/* Dominios */

var dominioService = angular.module('gambApp');

dominioService.factory('DominioApi', ['$resource',
    function ($resource) {
        return {
			Dominio: $resource('v1/dominios/:dominioId', {dominioId: '@id'},{
                'update': { method: 'PUT' }
            })
        };
    }]);