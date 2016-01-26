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

dominioController.controller('DominioDetailController', ['$scope', '$routeParams', '$location', 'DominioApi',
    function ($scope, $routeParams, $location, DominioApi) {
        $scope.dominio = {}

        if ($routeParams.servicioId) {
            DominioApi.Dominio.get({dominioId: $routeParams.dominioId}, function (dominio) {
                console.log("Dominio Object ")
                $scope.dominio = dominio
            });
        }        
        $scope.saveDominio = function () {
            console.log("Admin añadiendo Dominio", $scope.dominio);
            var dominio = $scope.dominio;
            var res = DominioApi.Dominio.save({}, dominio,
                function (resp) {
                    console.log("success " + resp);
                    $location.path('/dominios/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                    $scope.dominio.errors = resp.data.errors;
                });
            console.log(res);
        };

        $scope.updateServicio = function () {
            console.log("Admin actualizando Dominio ", $scope.dominio);
            var dominio = $scope.dominio;
            var res = DominioApi.Dominio.update({dominioId: $scope.dominio.id}, dominio,
                function (resp) {
                    console.log("success " + resp);
                    $location.path('/dominios/');
                }, function (resp) {
                    console.log("failure errors " + Object.keys(resp));
                    $scope.dominio.errors = resp.data.errors;
                });
            console.log(res);
        };        
    }]);