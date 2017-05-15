'use strict';
//service
angular.module("angular-kata").factory("GitHub",["$http",function($http){
	
	var getUser = function getUser(username){
		return $http.get("https://api.github.com/users/" + username).then(function successHandler(response) {
			return response.data;
		});
	};
	
	var getRepos = function(repos_url){
		$http.get(repos_url).then(function(response) {
				return response.data;
			});
	};
	
	var publicAPI = {
		getUser : getUser,
		getRepos : getRepos
	};
	
	
	return publicAPI;
}]);
