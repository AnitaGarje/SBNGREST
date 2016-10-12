'use strict';
(function() {
    myApp.controllers.config([ '$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            controller : 'UserController',
            templateUrl : '/app/view/users.html'
        }).otherwise('/');
    } ]);
})();