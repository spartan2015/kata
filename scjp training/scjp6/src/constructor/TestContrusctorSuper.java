package constructor;

public class TestContrusctorSuper {
	public static void main(String[] args){
		new b();
	}
}

class a{
	{System.out.println("a");}
	a(){
		System.out.println("aa");
	}	
}

class b extends a{
	{
		// here the compiler INSERTS THE SUPER() call
		System.out.println("b");}
	b(){
		System.out.println("bb");	
	}
}
