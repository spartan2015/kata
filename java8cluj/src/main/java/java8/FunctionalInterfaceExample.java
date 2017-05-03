package java8;

@FunctionalInterface
public interface FunctionalInterfaceExample {

	// one abstract
	void doer();
	
	// many default of statics
	public default void list(){
		System.out.println("list");
	}
	// as many statics as you wish
	static void sing(){
		System.out.println("sing");
	}
}
