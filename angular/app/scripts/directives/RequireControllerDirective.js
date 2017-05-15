'use strict';

angular.module("angular-kata").directive("RequireControllerDirective", {
	restrict : "E",
	required : "NamedController", // throws error if not found, link function gets a 4th parameter, the required controller
	//required : "^NamedController", // returns null
	template : "<div ng-click='someClick()'></div>"
});
