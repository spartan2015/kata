'use strict';

angular.module("angular-kata").controller("NamedController", ["$scope",
function($scope) {
	$scope.someClick = function() {
		console.log("directive click");
	};
}]);

angular.module("angular-kata").directive("withNamedController", {
		restrict : 'E',
		replace : true,
		template : '<div ng-click="someClick()">With Named Controller</div>',
		controller : "NamedController"
	}
); 