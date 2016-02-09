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
    }])

.factory("testService", ['$soap',function($soap){
    var base_url = "http://localhost:8001/soa-infra/services/default/PruebaSelect/select_client_ep?WSDL";

    return {
        Process : function(){
            return $soap.post(base_url,'process');
        }
    }
}]);