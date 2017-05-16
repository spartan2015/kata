'use strict';
/**
 * ng-style, ng-show, ng-hide, ng-cloak, ng-show="ready", ng-bind instead of {{}}
 * to get valid html use class or comment type of directives 
 * 
 * ng-show="editMode (scope variable)"
 * 
 * directive - shared scope mode if they don't declare a controller on them
 * inherited scope: set "scope: true"
 * isolated scope - scope : { student : "=" }
 * 
 *
 * 
 * <my-directive /> => <div data-my-directive> or better <div class="my-directive"> 
 * 
 * use data prefix for attributes: data-ng-app, data-ng-controller, data-ng-repeat
 */
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