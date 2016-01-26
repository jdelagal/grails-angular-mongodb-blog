'use strict';

/* Controllers */

var dominioController = angular.module('gambApp');

dominioController.controller('DominioListController', ['$scope','DominioApi', '$location', 
    function ($scope, DominioApi, $location) {

       	$scope.dominios = DominioApi.Dominio.query() ;
        console.log("Cargando Dominios ", $scope.dominios);

        $scope.deleteDominio= function (id) {
            console.log("Borrando Dominio ", id);
            DominioApi.Dominio.delete({dominioId: id},
                function (resp) {
                	console.log ("traza id: "+ id);
                    console.log("success " + resp);
                    $location.path('/dominios/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                });
        };

    }]);