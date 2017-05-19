'use strict';

/**
 * @ngdoc overview
 * @name kata1App
 * @description
 * # angular-kata
 *
 * Main module of the application.
 */
angular.module('angular-kata', ['ngAnimate', 'ngAria', 'ngCookies', 'ngMessages', 'ngResource', 'ngRoute', 'ngSanitize', 'ngTouch']).config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/main.html',
		controller : 'MainCtrl',
		controllerAs : 'main'
	}).when('/about', {
		templateUrl : 'views/about.html',
		controller : 'AboutCtrl',
		controllerAs : 'about'
	}).when("/repo/:username/:reponame", {
		templateUrl : "views/repo.html",
		controller : "RepoController"
	}).when("/directives", {
		templateUrl : "views/directives.html",
		controller : "DirectivesController"
	}).when("/treenode", {
		templateUrl : "views/treenode.html",
		controller : "treenodeController"
	}).otherwise({
		redirectTo : '/'
	});

	$locationProvider.hashPrefix('');
});

angular.module('angular-kata').controller("genericController", function($scope) {
	//
	angular.forEach([1, 2, 3, 4], function(e) {
		console.log(e);
	});

	//
	$scope.$on("ev1", function(e, data) {
		console.log(data);
	});
	$scope.$broadcast("ev1", "Hello Event World");
	//
	
	 $scope.items = [{name: "1"},{name: "2"}];
	 $scope.item = {name: "1"};
	 $scope.onSelect = function(item){
	 	console.log(item);
	 	
	 };
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
});

