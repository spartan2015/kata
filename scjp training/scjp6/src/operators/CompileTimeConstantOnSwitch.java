package operators;

public class CompileTimeConstantOnSwitch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int a = 1; // THIS IS COMPILE TIME CONSTANT
		final int b; // this is not
		b = 2; //even so
		
		switch(1){
		case a: break;
		//case b: break; //ERROR!!! this will not compile - not a compile time constant
		}
		

	}

}
