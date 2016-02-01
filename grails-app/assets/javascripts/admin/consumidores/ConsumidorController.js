'use strict';

/* Controllers */

var consumidorController = angular.module('gambApp');

consumidorController.controller('ConsumidorListController', ['$scope','ConsumidorApi', '$location', 
    function ($scope, ConsumidorApi, $location) {

       	$scope.consumidores = ConsumidorApi.Consumidor.query() ;

        console.log("Cargando Consumidores ", $scope.consumidores);

        $scope.deleteConsumidor = function (id) {
            console.log("Borrando Consumidor ", id);
            ConsumidorApi.Consumidor.delete({consumidorId: id},
                function (resp) {
                	console.log ("traza id: "+ id);
                    console.log("success " + resp);
                    $location.path('/consumidores/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                });
        };

    }]);