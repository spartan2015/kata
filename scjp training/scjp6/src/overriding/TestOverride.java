package overriding;

public class TestOverride {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new b().doStuff2();

	}

}

class a {
	void doStuff(){
		System.out.println("a");
	}
	
	void doStuff2(){
		doStuff();
	}
}

class b extends a{
	void doStuff(){
		System.out.println("b");
	}
}