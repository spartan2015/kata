'use strict';

angular.module("angular-kata").directive("withTemplate",function(){
	return {
		restrict : 'E',
		replace : true,
		template : '<div>Templated</div>'
		//templateUrl : "withTemplate.html"
	}; 
});