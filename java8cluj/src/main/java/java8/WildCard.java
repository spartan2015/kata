package java8;

import java.util.List;

public class WildCard {

	class A{}
	class B extends A{}
	class C extends B{}
	
	<X> X m1(List<X super B> list){ return null; } // super is specific to wildcard so only use <? super B> 
	
	<X> X m2(List<? super B> list){ return null; }
	
	<X extends B> X m3(List<X> list){ return null; } // wildcard declaration gotcha - if you want a boundary 
	
}
