package chapter10.b;

public class B extends chapter10.a.A{

	public static void main(String[] args){
		
		System.out.println(		new B().b		 ); // access a an inherited (initially protected member) from inside same class
		
	}
	
	
}

class C{
	
	static void tester(){
		System.out.println(new B().b); // not possible from outside the class - normal behaviour but a little unatural in the main there with a new object
	}
	
}