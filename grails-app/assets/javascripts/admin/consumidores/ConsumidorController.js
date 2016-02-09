'use strict';

/* Controllers */

var consumidorController = angular.module('gambApp');

consumidorController.controller('ConsumidorListController', ['$scope','ConsumidorApi', '$location', 'testService',
    function ($scope, ConsumidorApi, $location, testService) {

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

        console.log("Intento de llamada soap ");
        testService.Process().then(function(response){
           $scope.response = response;
           console.log ('response '+response);
        });
    }]);

consumidorController.controller('ConsumidorDetailController', ['$scope', '$routeParams', '$location', 'ConsumidorApi',
    function ($scope, $routeParams, $location, ConsumidorApi) {
        $scope.consumidor = {}
        $scope.servicio = {}

        if ($routeParams.consumidorId) {
            ConsumidorApi.Consumidor.get({consumidorId: $routeParams.consumidorId}, function (consumidor) {
                console.log("Consumidor Object.");
                $scope.consumidor = consumidor;
            });
        }

        $scope.saveConsumidor = function () {
            console.log("Admin añadiendo Consumidor", $scope.consumidor);
            var consumidor = $scope.consumidor;
            consumidor.servicio = $routeParams.servicioId
            console.log("consumidor.servicioId", consumidor.servicio);
            var res = ConsumidorApi.Consumidor.save({servicio: consumidor.servicio}, consumidor,
                function (resp) {
                    console.log("success " + resp);
                    $location.path('/consumidores/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                    $scope.consumidor.errors = resp.data.errors;
                });
            console.log(res);
        };

        $scope.updateConsumidor = function () {
            console.log("Admin actualizando consumidor ", $scope.consumidor);
            var consumidor = $scope.consumidor;
            var res = ConsumidorApi.Consumidor.update({consumidorId: $scope.consumidor.id}, consumidor,
                function (resp) {
                    console.log("success " + resp);
                    $location.path('/consumidores/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                    $scope.consumidor.errors = resp.data.errors;
                });
            console.log(res);
        };   
    }]);