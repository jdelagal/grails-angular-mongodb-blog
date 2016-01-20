'use strict';

/* App Module */

var gambApp = angular.module('gambApp', [
    'http-auth-interceptor',
    'ngRoute',
    'ngSanitize',
    'ngResource',
    'ui.bootstrap',
    'angulartics',
    'angulartics.google.analytics'
]);

gambApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'views/dashboard/index.html',
                controller: 'DashboardController'
            }).
            when('/login', {
                templateUrl: 'views/auth/login.html',
                controller: 'LoginController'
            }).
            when('/pages', {
                templateUrl: 'views/page/list.html',
                controller: 'PageListController'
            }).            
            when('/users/profile', {
                templateUrl: 'views/user/edit.html',
                controller: 'UserDetailController'
            }).
            when('/users/password', {
                templateUrl: 'views/user/password.html',
                controller: 'UserPasswordController'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);


function getLocalToken() {
    return sessionStorage["authToken"];
}

function setLocalToken(value) {
    sessionStorage["authToken"] = value;
}

function getHttpConfig() {
    return {
        headers: {
            'X-Auth-Token': getLocalToken()
        }
    };
}

function getAuthenticateHttpConfig() {
    return {
        ignoreAuthModule: true
    };
}

gambApp.run(['$rootScope', '$http', '$location',
    function ($rootScope, $http, $location) {
        $http.defaults.headers.common['X-AUTH-TOKEN'] = getLocalToken();

        $rootScope.$on('event:auth-loginRequired', function () {
            console.log('showing login form');
            $location.path('/login');
        });
        $rootScope.$on('event:auth-loginFailed', function () {
            console.log('showing login error message');
            $('#login-error').show();
        });
        $rootScope.$on('event:auth-loginConfirmed', function () {
            console.log('redirecting to home');
            $http.defaults.headers.common['X-AUTH-TOKEN'] = getLocalToken();
            $location.path('/');
        });
        $rootScope.$on('event:auth-logoutRequest', function () {
            console.log('Logging out user');
            delete $http.defaults.headers.common["X-AUTH-TOKEN"]
            $rootScope.isAuthenticated = false;
            $rootScope.currentUser = null;
            sessionStorage.clear();
            $location.path("/login")
        });
    }]);

console.log('gamb app load complete');