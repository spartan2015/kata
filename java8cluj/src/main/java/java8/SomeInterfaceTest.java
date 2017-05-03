package java8;

public interface SomeInterfaceTest {

	static final int MAX = 1;
	
	default void doerDefault(){
		System.out.println("default method");
	}
	
	static void doerStatic(){
		System.out.println("static method");
	}
	
}
