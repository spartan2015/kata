/*
1. "@"   (  Text binding / one-way binding )
2. "="   ( Direct model binding / two-way binding )
3. "&"   ( Behaviour binding / Method binding  )
*/
angular.module("angular-kata").directive("bindingIntoScope", function() {
  return {
    restrict : 'E',
    replace : true,
    scope: {
      a : "=",
      b : "@",
      c : "&"
    },
    link : function(scope) {

    }
  };
});
