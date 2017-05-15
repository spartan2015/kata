'use strict';

angular.module("angular-kata").directive("withController",function(){
	return {
		restrict : 'E',
		replace : true,
		template : '<div ng-click="someClick()">With Controller</div>',
		controller : function($scope){
			$scope.someClick = function(){
				console.log("directive click");
			};
		}
	}; 
});