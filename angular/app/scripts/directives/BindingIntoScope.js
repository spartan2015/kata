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
      a : "=", // FUNCTIONS ALSO - PASSED BY REFERENCE LIKE THIS
      b : "@",
      c : "&"  // hmmm...provides a way to execute an expression in the context of the parent scope...
    },
    link : function(scope) {

    }
  };
});
