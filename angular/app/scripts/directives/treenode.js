"use strict";

angular.module("angular-kata").controller("treenodeController", function($scope){
	
});

angular.module("angular-kata").directive("treenode", function() {
	return {
		restrict : "E",
		template : "<div ng-click='add()'><span>{{val}}.{{increment}}</span></div>",
		//controller: "treenodeController",
		scope: {
			val : "=",
			increment : "="
		},
		link : function($scope, element){
			$scope.element = element;
		},
		controller : function($scope, $compile) {
			$scope.increment = $scope.increment + 1;
			$scope.val = $scope.val || 1;
			
			$scope.next = function(){ return $scope.val + 1;};
			
			$scope.currentVal = function(){
				return $scope.val+'.'+$scope.increment;
			};
			
			$scope.add = function addNode(){
				var el = $compile("<treenode val=\"currentVal()\" increment=\"next()\" />" )( $scope );
        		$scope.element.append( el );	
			};
		}
	};
});
