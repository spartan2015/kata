"use strict";

angular.module("angular-kata").controller("treenodeController", function($scope){
	
});

angular.module("angular-kata").directive("treenode", function() {
	return {
		restrict : "E",
		template : "<div ng-click='add()'><span>{{val}}</span></div>",
		//controller: "treenodeController",
		scope: {
			val : "@",	
		},
		link : function($scope, element){
			$scope.element = element;
		},
		controller : function($scope, $compile) {
			$scope.val = $scope.val;
			$scope.nextInc = 0; 
			
			$scope.add = function addNode(){
				$scope.nextInc++;
				$scope.asStr = $scope.val + "." +$scope.nextInc;
				var el = $compile("<treenode val=\""+$scope.asStr+"\" />" )( $scope );
        		$scope.element.append( el );	
			};
		}
	};
});
