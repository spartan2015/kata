'use strict';

angular.module("angular-kata").directive("dtdParent", function() {
	return {
		restrict : "E",
		template : "<div>Hello main <dtd-child child-line='parentLine'></dtd-child> {{fromChildToParent}}</div>",
		controller : function($scope) {
			$scope.parentLine = "the parent";
			
			return $scope; // if you don't want to return the 'this' which would also be useful for parent to child communication
		}
	};
});

angular.module("angular-kata").directive("dtdChild", function() {
	return {
		restrict : "E",
		require : "^dtdParent", // yes linking directly to the parent direct
		template : "<div>Child: {{childLine}}</div>",
		scope : {
			childLine : "="
		},
		link : function(scope, element, attrs, ctrl){
			ctrl.fromChildToParent="aloha";
		}
	};
}); 