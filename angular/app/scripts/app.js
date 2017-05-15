'use strict';

/**
 * @ngdoc overview
 * @name kata1App
 * @description
 * # angular-kata
 *
 * Main module of the application.
 */
angular
  .module('angular-kata', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when("/repo/:username/:reponame",{
      	templateUrl : "views/repo.html",
      	controller : "RepoController"
      })
      .when("/directives",{
      	templateUrl : "views/directives.html",
      	controller : "DirectivesController"
      })
      .otherwise({
        redirectTo: '/'
      });
  });
