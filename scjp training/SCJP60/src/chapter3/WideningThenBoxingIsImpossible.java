package chapter3;

public class WideningThenBoxingIsImpossible {
	
	public static void main(String[] args) {
		/* 
		 * !!! COMPILER ERROR IF you need widening from short to int and then boxing to Integer - compiler
		 * can't do widening then boxing
		 */

		
		int a = 1;
		go(a); // NOT POSSIBLE - boxing results in a Integer - Integer IS NOT A Long
	}
	
	static void go(Long l){
		System.out.println("long");
	}

}
