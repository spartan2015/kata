'use strict';
/**
 *this is a good way to share a controller between multiple components
 * 
 * the controller is required, the controller could be a named controller on parent directive: controller: "NamedController" 
 */
angular.module("angular-kata").directive("RequireControllerDirective", {
	restrict : "E",
	required : "NamedController", // throws error if not found, link function gets a 4th parameter, the required controller
	//required : "^NamedController", // returns null
	template : "<div ng-click='someClick()'></div>"
});
