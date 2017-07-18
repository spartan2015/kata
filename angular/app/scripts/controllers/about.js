'use strict';

/**
 * @ngdoc function
 * @name kata1App.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the kata1App
 */
angular.module('angular-kata')
  .controller('AboutCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });


angular.module('angular-kata')
  .directive('queryBuilder', ['$q',
    function ($q) {
      return {
        template: '<div>Hello Query</div>',
        restrict: 'E',
        controllerAs: 'vm',
        link : function($scope, element, attr){

        }
      }
    }]);


