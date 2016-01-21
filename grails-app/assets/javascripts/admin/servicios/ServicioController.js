'use strict';

/* Controllers */

var servicioController = angular.module('gambApp');

servicioController.controller('ServicioListController', ['$scope','ServicioApi',
    function ($scope, ServicioApi) {

       	$scope.servicios = ServicioApi.Servicio.query() ;
       	$scope.orderPropServicio = 'servicio';
        console.log("Cargando Servicios ", $scope.servicios);

        $scope.deleteServicio = function (id) {
            console.log("Borrando Servicio ", id);
            ServicioApi.Servicio.delete({servicioId: id},
                function (resp) {
                	console.log ("traza id: "+ id);
                    console.log("success " + resp);
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                });
        };

    }]);
