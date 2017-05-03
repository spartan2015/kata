package chapter3.wrapperClasses;

public class Wrapper {

	
	public static void main(String[] args) {
	
		
		Integer i1 = Integer.valueOf("1"); // creates a wrapper object of type Integer
		Integer i2 = Integer.valueOf("10",8); // specify radix - numeric base
		System.out.println(i2);
		
		Float f1 = Float.valueOf("3.14f"); // observe the "f" - respects standard java literal convention
		System.out.println(f1);

	}

}
