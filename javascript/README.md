
Recommended reading: 

Stoyan Stefanov, JavaScript Patterns

https://github.com/rwaldron/idiomatic.js

Nicholas C. Zakas, High Performance JavaScript

https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide

www.ecma-internationa.org/ecma-262/5.1

wiki.ecmascript.org/doku.php?id=harmony:proposals


Topics: 
1. Scope

function scope only*
finding declaration of variables and functions

var foo = "bar"; // global window
function bar(){ // global window
	console.log(this);
	var foo="baz"; // var makes it function local - remove var to point to window.foo (the scope of the function that is)
}
bar();
console.log(foo);

function baz(foo){ 
	foo = "bam";
}
baz();
console.log(foo);

// !!! strict mode vs non strict mode
function baz(){
	bam = "yo"; // if not in strict mode this will be auto created - could cause unintentional leakage
}

// declaration scope
var foo = function bar(n){ 
// useful for recursion on scope limitation
// useful for debug (documents the otherwise anon)
	console.log(n);
	if (n == 0) return;
	if (!n){
		n=2;
	}	
	bar(n-1); // called from within itself only
};
// bar will not be available further
foo(2); //can't do that - why ? // can't send params damn

// hidding stuff in anon function scope
(function bar(n){console.log(n);})()




// catch is blocked scope
try{
}catch(e){
	// e is block scoped
}

ES6 - block scope: let() 
var foo = "foo";
(function(){
	var foo = "foo2";
	console.log(foo); // out: foo2
})();

vs

(function(bar){
	var foo = bar;
})(foo);
console.log(foo); // out: foo

vs

(function SelfDocumentedName(){
	throw new Error('aha');
})();

LET:

(function selfDocumenting(){
	for(let i=0; i < 2; i++){ // instead of for(var i=0; i < 2; i++) 
		console.log(i);
	}
	console.log(i); // ReferenceError: i is not defined
	
	if (true){
		let bar=bar; // now in if scope
	}
	console.log(bar); // ReferenceError
})();

- let keyword does not hoist - manually put the lets at the top - cause that var could be created in the middle of the block instead of first


1.1 Nested Scope

1.2 Hoisting: declaration happens first - on compilation - then execution follows (in order)

a = c+d();
var c = e();
var d = function(){
	return 2;
};
function e(){
	return 1;
}

Is seen by js as:

function e(){
	return 1;
}
var c 
var d
a = c + d(); //both declared but undefined
c = e();
d = function(){
	return 2;
}


//useless but This compiles ok cause declartion hoisting - declaration happens before execution 
function a(){
	b();
}
function b(){
	a(); 
}



Interesting:

(function(){

	function a(){
		console.log("a()");
	}
		
	return a;
})()();


(function(){
	var rest = "ABCD".split("");
	let obj = {};
	for(let i = 0; i < rest.length; i++){
		(function(i){
			
			window[rest[i]] = function(){ // create a function that executes a yet not defined function
				obj.log(rest[i]);
				if (i < rest.length-1){
					obj[rest[i+1]]();
				}
			};
			
		})(i);
	}
	obj['A'](); // now execute the chain created
})();

1.3 this - the exectution context
when
where
how - the function is called


function foo(){
	console.log(this.bar);
}

foo(); // this = strict ? undefined : window|GlobalObjectInNode 
var o1 = {foo:foo, bar:"asd"};
o1.foo();

Explicit this binding
foo.call(window); 
foo.call(obj);
foo.call(apply);

Forcing a "hard binding":

function foo(){
 console.log(this.bar);
}

var obj={ bar: "bar"};
foo = function(){ foo.call(obj);};

foo();  // bar
foo.call({}); // still bar

Utility:
function bind(fn, o){
	return function(){
		fn.call(o);
	};
}

foo = bind(foo,obj);

Or:

if (!Function.prototype.bind2){
	Function.prototype.bind2 = function(o){
		var fn = this; // the function!
		return function(){
			return fn.apple(o,arguments);
		}
	}
}
foo = foo.bind2(obj);

But this is built in: Function.prototype.bind();


Another goodie:
function foo(){
	this.baz = "baz";
	console.log(this.bar + " " + baz);
}
var f = new foo();

var bar = "bar";
var baz = new foo(); // constructor call
Constructor call:
	a brand new object is created
	the new object is linked to a different object
	the new object gets bound to the new object
	if that function does not return anything then a return this is implicitly returned

The new keyword overrides any binding of the function - even hard binding
 

What is "this" rules ? Find function call site. Ask these rulesL
	new rule
	explicit apply or call
	implicit - from context
	default rule


1.4 Closure

a function remembers its lexical scope even if executed outside that lexical scope

if (!Function.prototype.bind2){
	Function.prototype.bind2 = function(o){
		var fn = this; // the function!
		return function(){
			return fn.apple(o,arguments); // access to lexical scope outside
		}
	}
}

Which needs to be taken care of in a loop:

for(var i = 0; i < 3; i++){
	setTimeout(function(){
		console.log(i);
	},100);
}
Must be handled as:
for(let i = 0; i < 3; i++){ // yes let will bind to a new scope with each iteration
	setTimeout(function(){
		console.log(i);
	},100);
}
or
for(var i = 0; i < 3; i++){
	(function(){
		setTimeout(function(){
			console.log(i);
		},100);
	})(i);
}
	
Closure is usefull to make modules:
	
	
var foo = (function(){
	var o = { bar : "bar"};
	
	// my local var and function
	
	// then return api
	return {
		bar: function(){
			console.log(o.bar); // that have access through closure to my local/private var and methods
		}
	};
})();
