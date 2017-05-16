"use-strict";

angular.module("angular-kata").directive("withLink",function(){
	return {
		restrict : 'E',
		replace : true,
	
		link : function(scope, element, attrs, ctrl){
			scope.title = "3rd";
			scope.values = scope.values || [];
			scope.values.push("3rd");
		}
	}; 
});