'use strict';
angular.module("angular-kata").controller("RepoController",['$scope', '$routeParams',function($scope, $routeParams){
	$scope.username = $routeParams.username;
	$scope.reponame = $routeParams.reponame;	
}]);
