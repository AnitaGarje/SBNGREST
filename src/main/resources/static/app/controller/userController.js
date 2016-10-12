'use strict';
(function() {
    var UserController = function($scope, GenericFactory) {
        $scope.users = [],
        $scope.user = {gender:'M'};
        var me = this;
         
        me.doGetUsers = function(){
            GenericFactory.getMethod({
            	method:'GET',
                url : '/users',
                successCB : function(result) {
                    $scope.users = result;
                }
            });
        }
         
        $scope.doDeleteUser = function(id){
        	//console.log("Id to be deleted"+id);
            GenericFactory.getMethod({
            	method:'DELETE',
                url : '/users',
                data : id,
                successCB : function(result) {
                    me.doGetUsers();
                }
            });
        }
         
        $scope.doEditUser = function(id){
        	//console.log("Id to be Edited"+id);
            for (var i = 0; i < $scope.users.length; i++) {
                if($scope.users[i].id === id){
                    $scope.user = $scope.users[i];
                    break;
                }
            }
        }
         
        me.createUser = function(){
            GenericFactory.getMethod({
            	method:'PUT',
                url : '/users',
                data : $scope.user, 
                successCB : function(result) {
                    me.doGetUsers();
                }
            });
        }
         
        me.updateUser = function(){
        	
            GenericFactory.getMethod({
            	method:'POST',
                url : '/users',
                data : $scope.user, 
                successCB : function(result) {
                    me.doGetUsers();
                }
            });
        }
         
        $scope.doSubmit = function(){
            if($scope.users.id !== ''){
                me.updateUser();
            }else{
                me.createUser();
            }
        }
         
        $scope.reset = function(){
            $scope.user = {gender:'M'};
            $scope.userForm.$setPristine();
        }
         
        function init() {
            me.doGetUsers();
        }
        init();
         
    };
 
    myApp.controllers.controller('UserController', [ '$scope', 'GenericFactory', UserController ]);
})();