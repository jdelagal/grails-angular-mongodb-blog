'use strict';

/* Controllers */

var servicioController = angular.module('gambApp');

servicioController.controller('ServicioListController', ['$scope','ServicioApi',
    function ($scope, ServicioApi) {

       	$scope.servicios = ServicioApi.Servicio.query() ;
        console.log("Loading Servicios ", $scope.servicios);

    }]);
