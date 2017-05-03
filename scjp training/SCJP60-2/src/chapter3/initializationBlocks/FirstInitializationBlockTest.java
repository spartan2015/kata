package chapter3.initializationBlocks;

public class FirstInitializationBlockTest {

	
	public static void main(String[] args) {
		new B();

	}

}


class A{
	
	static{
		System.out.println("A static init block");
	}
	{
		System.out.println("A init block");
	}
	A(){
		System.out.println("A construct");
	}
	
}
class B extends A{
	static{
		System.out.println("B static init block");
	}
	{
		System.out.println("B init block");
	}
	B(){
		System.out.println("B construct");
	}
}