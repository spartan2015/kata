angular.module('angular-kata').controller("genericController", function($scope) {
	
	$scope.$on("ev1", function(e, data) {
		console.log(data);
	});
	$scope.$broadcast("ev1", "Hello Event World");
	

});