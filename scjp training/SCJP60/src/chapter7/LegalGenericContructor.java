package chapter7;

public class LegalGenericContructor {

	<T> LegalGenericContructor(T arg){ // GENERIC CONSTRUCTOR
		System.out.println(arg.getClass());
	}
}
