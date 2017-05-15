'use strict';

angular.module("angular-kata").directive("myDirective", function() {
	return {
		restrict : 'E',
		replace : true,

		link : function(scope) {
			scope.title = "1st";
			scope.values = scope.values || [];
			scope.values.push("1st");
		}
	};
});
/**
 *
 * 1 template per directive name
 * multiples directives per directive name
 *
 */
angular.module("angular-kata").directive("myDirective", function() {
	return {
		restrict : 'E',
		replace : true,
		link : function(scope) {
			scope.title = "2nd";
			scope.values = scope.values || [];
			scope.values.push("2nd");
		}
	};
});

angular.module("angular-kata").directive("myDirective", function() {
	return {
		restrict : 'E',
		replace : true,

		link : function(scope) {
			scope.title = "3rd";
			scope.values = scope.values || [];
			//scope.values.push("3rd");
		}
	};
}); 