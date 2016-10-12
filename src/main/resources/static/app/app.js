'use strict';
var myApp = myApp || {};
 
(function(){
    myApp.factories = angular.module('myAppFactories', []),
    myApp.controllers = angular.module('myAppControllers', [ 'myAppFactories', 'ngRoute' ]),
    myApp.app = angular.module('myApp', [ 'ngRoute', 'myAppControllers']);
})();