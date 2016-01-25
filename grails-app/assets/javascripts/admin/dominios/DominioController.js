'use strict';

/* Controllers */

var dominioController = angular.module('gambApp');

dominioController.controller('DominioController', ['$scope', 'DominioApi',
    function ($scope, DominioApi) {
        $scope.dominio = DominioApi.Dominio.dom();
        console.log("Cargando Dominios ", $scope.dominio);
    }]);
