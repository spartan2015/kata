package chapter3;

public class BoxingThenWideningWorksBecauseofISA {

	
	public static void main(String[] args) {
		 /*
		 * - you can do boxing the widening(the IS-A on resulting object)
		 */
		byte b = 5;
		go(b); // 1. box to Byte - Byte IS-A Object - works
	}
	
	static void go(Object obj){
		System.out.println("object");
	}

}
