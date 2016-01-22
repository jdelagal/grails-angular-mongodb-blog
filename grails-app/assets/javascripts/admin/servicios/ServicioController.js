'use strict';

/* Controllers */

var servicioController = angular.module('gambApp');

servicioController.controller('ServicioListController', ['$scope','ServicioApi', '$location', 
    function ($scope, ServicioApi, $location) {

       	$scope.servicios = ServicioApi.Servicio.query() ;
       	$scope.orderPropServicio = 'servicio';
        console.log("Cargando Servicios ", $scope.servicios);

        $scope.deleteServicio = function (id) {
            console.log("Borrando Servicio ", id);
            ServicioApi.Servicio.delete({servicioId: id},
                function (resp) {
                	console.log ("traza id: "+ id);
                    console.log("success " + resp);
                    $location.path('/servicios/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                });
        };

    }]);

servicioController.controller('ServicioDetailController', ['$scope', '$routeParams', '$location', 'ServicioApi',
    function ($scope, $routeParams, $location, ServicioApi) {
        $scope.servicio = {}
        $scope.saveServicio = function () {
            console.log("Admin añadiendo servicio", $scope.servicio);
            var servicio = $scope.servicio;
            var res = ServicioApi.Servicio.save({}, servicio,
                function (resp) {
                    console.log("success " + resp);
                    $location.path('/servicios/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                    $scope.servicio.errors = resp.data.errors;
                });
            console.log(res);
        };
    }]);