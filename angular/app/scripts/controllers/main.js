'use strict';

/**
 * @ngdoc function
 * @name kata1App.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the kata1App
 */
angular.module('angular-kata').controller('MainCtrl', ["GitHub","$scope", "$http","$interval",
function(GitHub, $scope, $http,$interval) {
	$scope.name = "John";

	$scope.users = ["a", "b", "c"];

	$scope.find = function findUserHandler(username) {
		console.log(username);
	
		GitHub.getUser(username).then(function(user){
			$scope.user = user;
			
			GitHub.getRepos(user.repos_url).then(function(repos){
				$scope.repos = repos;
			});
		});		
	};

	$scope.directives = ["ng-app", "ng-controller", "ng-class", "ng-disabled", "ng-if", "ng-keypress", "ng-mouseleave", "ng-repeat", "ng-bind", "ng-click", "ng-focus", "ng-include", "ng-keyup", "ng-mousemove", "ng-style", "ng-blur", "ng-copy", "ng-hide", "ng-init", "ng-model", "ng-mouseover", "ng-switch", "ng-change", "ng-dblclick", "ng-href", "ng-keydown", "ng-mouseenter", "ng-paste", "ng-transclude"];

	$scope.countdown = 5;
	$scope.startCountdown = function() {
		$interval(function(){ $scope.countdown++; },1000,10);
	};
	
	$scope.services = ["$routeParams","anchorScroll","$http","$interval","$timeout","$log","$animate","$location","$browser","$window"];
}]);
