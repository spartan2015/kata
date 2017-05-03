package chapter5;

public class SwithChanlange {

	
	public static void main(String[] args) {
	
		/*
		 * 1. the switch evaluation only byte, short, char, int and ENUM
		 * 
		 * 2. the swithc must be a COMPILE CONSTANT: either literal, enum, or !!!!FINAL ASSIGNED !VARIABILE!!!! like final int x = 1;
		 * 
		 * 3. if enum is involved, in case you set only the constant, and all case must pass the IS-A test
		 * 
		 */
		
		int x = 1;
		
		final int y =1; // good for switch
		
		final int z; // ILLEGAL CONSTANT FOR SWITCH - not assigned on declaration
		z = 3;
		
		switch(season.A){		
		case A: // //THE LEGAL WAY			
			break;
		
		/*
		 ase season.A:{ // ILEGAL - must put only the ENUM constant			
			break;
		
		 */
		case 1:break; // ILLEGAL - if enum used you must use IS-A
		
		case x: break; // ILLEGAL - must be COMPILE TIME CONSTANT (ASSIGNED ON DECLARATION)
		
		case y: break; // LEGAL - y is an final and assigned on declaration final int y = 1;
		
		case z:break;
		
		}
		
		
		/**
		 * daca folosesti un byte iar constantele din CASE depasesc byte-urile - NU COMPILEAZA - EROARE DE COMPILARE
		 */
		
		byte b = 127;
		switch(b){
		case 1://OK
		case 128: // COMPILE ERROR - the compiler knows that 128 is not a byte			
		}
		
		
		/**
		 * another COMPILE ERROR regarding swithc is using duplicat constants
		 */
		
		switch(1){
		case 2:
		case 2: // DUPLICATE CASE COMPILE ERROR
		}
		
		
		/**
		 * WATHC FOR DEFAULT FALL THROUGH - default can be first but if swithc enters the default
		 * he FALLS THROUGH until BREAK is found
		 */
		switch(1){
		default: System.out.println(1); // if you enter here IT FALLS THROUGH UNTIL BREAK so it prints: 1 2 3
		case 2: System.out.println(2);
		case 3: System.out.println(3);
		}
		
		
		
	}
	
	enum season{
		A,B,C
	}

}
