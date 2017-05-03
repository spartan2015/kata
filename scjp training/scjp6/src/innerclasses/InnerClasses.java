package innerclasses;

class MyOuter{
	private int x = 10;
	
	class MyInner{
		public void seeOuter(){
			System.out.println("MyOuter x accessed through simple x is: " + x);
			// access outer class reference - SPECIAL SYNTAX
			System.out.println(MyOuter.this);
		}
	}
	
	public void instantiateInner(){
		// first type of instantiating an inner class
		MyInner mi = new MyInner();
		mi.seeOuter();		
	}
}


public class InnerClasses {

	
	public static void main(String[] args) {
		MyOuter mo = new MyOuter();
		mo.instantiateInner();

		// second type of instantiating an inner class - SPECIAL SYNTAX
		MyOuter.MyInner mi = mo.new MyInner();
		mi.seeOuter();
	
	}

}
