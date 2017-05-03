package chapter5;

public class Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 1;
		
		final int compileTimeConstant = 3; // PAY ATTENTION TO THE ASSIGNATION - THIS MAKES IT A COMPILE TIME CONSTANT !!!!!!!!!!!
		
		switch(a){
			case 1: System.out.println("1");
			case 2: System.out.println("2");
			case compileTimeConstant: System.out.println("3"); // THAT MEANS final &&&& ASSIGNED VALUE = compile time constant		 
		}
		
		switch(Day.M){
		case M: System.out.println("M"); // FII ANTENA, daca am enum in switch(enum) atunci in case-uri vor fi doar constantele, fara path la enum, doar M, NUUU Day.M
		}

		
		/**
		 * COMPILE TIME CONSTANT ERROR:
		 */
		final int x;
		x = 1;
		switch(1){
			case x: System.out.println("1"); // COMPILE ERROR: case expression must be CONSTANT EXPRESSION
		}
		
		/**
		 * if you use a small unit like byte, the constant must be of same type, AT COMPILE TIME
		 * Look at the following ERROR!:
		 */
		
		byte y = 1;
		switch(y){
			case 1: System.out.println("1");
			case 128: System.out.println("128 not possible, possible LOSS OF PRECISION on CAST"); // TYPE MISMATCH, CANNOT CONVERT FROM INT TO A BYTE
		}
		
		
		
		/**
		 * IT IS ILLEGAL TO HAVE MORE THAN ONE CASE WITH THE SAME VALUE 
		 */
		
		switch(1){
		case 1: System.out.println("1");
		case 1: System.out.println("1 same"); // COMPILE TIME ERROR: DUPLICATE CASE !!!!
		}
		
		
		/*
		 * BOXING IS OK
		 */
		switch(Integer.valueOf("1")){ // OK
			case 1: System.out.println("1");
		}
	}

	enum Day{M,T,W,TH,F,S,Su}
}
