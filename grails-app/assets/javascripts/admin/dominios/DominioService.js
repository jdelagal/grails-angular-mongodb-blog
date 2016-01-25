'use strict';

/* Dominios */

var dominioService = angular.module('gambApp');

dominioService.factory('DominioApi', ['$resource',
    function ($resource) {
        return {
            Dominio: $resource('v1/dominios', {}, {
                'dom': { method: 'GET', url: 'v1/dominios/dom' }
            })
        };
    }]);