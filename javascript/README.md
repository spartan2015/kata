
Recommended reading: 

Stoyan Stefanov, JavaScript Patterns

https://github.com/rwaldron/idiomatic.js

Nicholas C. Zakas, High Performance JavaScript

https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide

www.ecma-internationa.org/ecma-262/5.1

wiki.ecmascript.org/doku.php?id=harmony:proposals

http://es6-features.org/#Constants


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

// execting a function in same line
(function(){console.log("a");}())

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
 

What is "this" rules ? Find function call site. Ask these rules.
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

	
var foo = (function NamedModule/*we can reference this function from inside the module now*/(){
	var o = { bar : "bar"};
	
	// my local var and function
	
	// then return api
	return {
		bar: function(){
			console.log(o.bar); // that have access through closure to my local/private var and methods
		}
	};
})();



Object orienting:

Common OO Pattterns
 
Singleton 1

var Router = function(){

	if (Router.__instance__){
		Router.__instance__;
	}
	
	Router.__instance__ = this;
	this.routes = {};
}

Router.prototype.setRoute = function(match, fn){
	this.routes[match] = fn;
}
 
Singleton 1

var Router = function(){
	if (Router.__instance__){
		Router.__instance__;
	}
	
	function setRoute(match, fn){
		this.routes[match] = fn;
	}
	
	var publicAPI = Router.__instance__={
		setRoute: setRoute
	};
	return publicAPI;
};
 
 
Test Singleton:

var router1  =new Router();
var router2 = new Router();
router1 === router2

Observer

function PageController(router){
	this.router = router;
	this.router.on("navigate"), this.fetchPage.bind(this));
}
PageController.prototype.fetchPage = function(d){
	$.ajax({
		url: d.page_url;
	})
	.done(this.loaded.bind(this, d.page_url));
};
PageController.prototype.loaded = function(d,u){
	// display page contet
	this.router.emit("pageLoaded",u);
}

var router = new Router();
var thepage = new PageController(router);




Inheritance vs behaviour delegation

Prototype mechanism:
Any object is build by a constructor function.
A constructor makes an object LINKED to its own prototype:

function Foo(who){
	this.me = who;
}
Foo.prototype.identify = function(){
	return "I am " + this.me;
};

var a1 = new Foo("a1");
var a2 = new Foo("a2");

a2.speak = function(){
	alert("Hello, " + this.identify() + ".");
}

a1.constructor === Foo;
a1.contructor === a2.constructor;
a1.__proto__ === Foo.prototype;
a1.__proto__ === a2.__proto__;

a1.__proto__ === Object.getPrototypeOf(a1);
a2.constructor === Foo;
a1.__proto__ == a2.__proto__;
a2.__proto__ == a2.contructor.prototype;

Constructor call:
	a brand new object is created
	the new object is linked to the prototype of the function
	the new object gets bound to the new object
	if that function does not return anything then a return this is implicitly returned

Shadowing:

a1.identify = function(){
	alert(Foo.prototype.identify.call(this));
}

How to do super instead:

a1.identify2 = function(){
	this.identify(); // super chain 
}
a1.identify3 = function(){
	this.identify2(); // super chain 
}


Another goodie: Linking objects with prototype

function Foo(who){
	this.me = who;
}
Foo.prototype.identify = function(){
	return "I am " + this.me;
};

function Bar(who){
	Foo.call(this,who);
}
// Bar.prototype = new Foo();
Bar.prototype = Object.create(Foo.prototype); // create new object - link it - but does not bind a constructor or return it
// constructor was borked (obstructed) by Object.create
Bar.prototype.speak = function(){
	alert(this.identify());
}
// but this means Bar.constructor is Foo;s constructor

var b1 = new Bar("b1");
var b2 = new Bar("b2");

b1.speak();
b2.speak();

// but things can be simplified
Objects Linked to Other Objects: OLOO (the opposite of inheritance)

var Foo = {
	init: function(who){
		this.me = who;
	},
	identify: function(){
		return "I am " + this.me;
	}
};

var Bar = Object.create(Foo);
Bar.speak = function(){
	alert(this.identify());
};

var b1 = Object.create(Bar);
b1.init("b1");
b1.speak();

if (!Object.create){ // pre es5
	Object.create = function(o){
			function F(){};
			F.prototype = o;
			return new F();
		}
	}
}





Async Patterns:


Callback

setTimeout(function(){
	console.log("callback");
}, 1000); // async

callback hell:
setTimeout(function(){
	console.log("callback");
		setTimeout(function(){
		console.log("callback");
			setTimeout(function(){
			console.log("callback");
		}, 1000); // async
	}, 1000); // async
}, 1000); // async

even here the same hell:
function one(cb){
	console.log("one");
	setTimeout(cb, 1000);
}
function two(cb){
	console.log("two");
	setTimeout(cb,1000);
}
same:
function getData(d, cb){
	setTimeout(function(){cb(d);},1000);
}
getData(10, function(d){
	console.log(d);
	getData(20, function(d){
		console.log(d);
		getData(30,function(d){
			console.log(d);
		});
	});
});


Generators and co-routines (ES6)
:run to completion invariant of javascript - true in general - not true of generators

function* gen(){
	console.log("Hello");
	yield null;
	console.log("World");
}
var it = gen();
it.next(); // prints hello
it.next(); // print world

function* gen(){
	var num = 0;
	while(true){
		console.log("" + num++);
		yield null;
	}
}
var g = gen();
for(let i = 0; i < 5; i++){
	g.next(); // print next
}

Coroutines:
var run = coroutine(function* (){
	var x = 1+ (yield null);
	var y = 2 + (yield null);
	yield ( x + y);
});

run();




Promises - the solution to the callback hell

jQuery style:

var wait = jQuery.Deferred();
var p = wait.promise();

p.done(function(value){
	console.log(value);
});

setTimeout(function(){
	wait.resolve(Math.random());
},1000);

function waitForMillis(n){
	var d = $.Deferred();
	setTimeout(d.resolve, n);
	return d;
}

waitForMillis(1000).then(function(){
	console.log(1);
})
.then(function(){
	waitForMillis(1000).then(
		function(){
			console.log(2)
		}
	);
});


ES6 promises

function getData(d){
	return new Promise(function(resolve,reject){
		setTimeout(function(){ resolve(d);},1000);
	});
}

getData(10)
.then(function(d){
	console.log(d);
	return getData(d);
})
.then(function(answer){
	console.log(answer);
})
;


Asenquence Lib: automatically chained promises

ASQ()
.then(function(done){
})
.gate(function(done){
}, function(done){
})
.then(function(done){
})
;

function getData(d){
	return ASQ(
		function(done){
			setTimeout(function(){
				done(d);
			},1000);
		}
	);
}


ASQ()
.waterfall(
	function(done){ getData(10).pipe(done);},
	function(done){ getData(30).pipe(done);},
)
.seq(function(num1,num2){ return getData(x+y);})
.val(function(answer){
	console.log(answer);
})
;


With generators and promisses

function getData(d){
	return ASQ(
		function(done){
			setTimeout(function(){
				done(d);
			},1000);
		}
	);
}


ASQ()
.runner(function*(){
	var x = 1 + (yield getData(10));
	var y = 1 + (yield getData(30));
	var answer = yield ( getData("Meaning of life " + (x + y)));
	return answer;
})
.val(function(answer){
	console.log(answer);
});
;



function fakeAjax(file, done){
	var fake_responses = {
		"file1": "the first text",
		"file2": "the second text",
		"file3": "the third text"
	};
	var randomDelay = (Math.round(Math.random()*1E4) % 8000) + 100;
	console.log("Requesting: " + url);
	
	setTimeout(function(){
			cb(fake_responses[url]);
		},
		randomDelay
	);
	
	return file;
}

function output(text){
	console.log(text);
}

function getFile(file){
	return ASQ(function(done){
		fakeAjax(file,done);
	});
}

ASQ()
.seq().apply(
	null, 
	["file1","file2"]
		.map(getFile)
		.map(function(sq){
			return function(){
				return sq.val(output);
			};
		)	
	})
)
.val(function(){
	output("Complete!");
})
;

Or with promisses

function getFile(file){
	return new Promise(function(resolve,reject){
		fakeAjax(file, resolve);
	});
}

["file1","file2"]
		.map(getFile)
		.reduce(
			function(chain, filePromise){
				return chain.then(function(){
					return filePromise;
				});
			},
			Promise.resolve()
		)
		.then(function(){
			
		})
