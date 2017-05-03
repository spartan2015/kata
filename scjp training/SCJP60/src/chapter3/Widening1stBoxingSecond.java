package chapter3;

public class Widening1stBoxingSecond {

	public static void main(String args[]){
		
		byte b = 127;
		go(b);
		
		/*
		 * 1. Widening
		 * 2. Boxing - even Object takes precedence
		 * 3. Var-arg
		 * 
		 * !!! YOU CAN'T WIDEN WRAPPER OBJECT - because no inherintance exists between them, Short and Integer have no inheritance
		 * so no widening is posible
		 */
		
		
	}
	
	static void go(double d){
		System.out.println("double - 1st Widening, 2nd Boxing");
	}
	
	static void go(Integer d){
		System.out.println("Integer");
	}
	
	static void go(byte... b){
		System.out.println("byte vargs");
	}
	
}
