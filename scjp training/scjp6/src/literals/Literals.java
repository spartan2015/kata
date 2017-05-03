package literals;

public class Literals {
	
	public static void main(String[] args) {
		int a = 021;
		// formula is: 8^0 * 0  + 1 * 8^1 = 0 + 8 = 8
		// formula is: 8^0 * 1  + 2 * 8^1 = 1 + 16 = 17
		System.out.println(a);
		
		int b= 0xa2;
		// 10 * 16^1 + 2 * 16^0 = 160 + 2 = 162  
		System.out.println(b);
		
		char c1 = 0x892;
		char c2 = 892;
		char c3 =  (char)65536;
		System.out.println("|" + c3 + ">");
		
		
//		Assigning Floating-Point Numbers                 Floating-point numbers have
//		slightly different assignment behavior than integer types.
		short s = 32277; // although an int literal, the compiler allows this
		// but for float it does NOT
		//float f = 1.0; // COMPILER ERROR if no f is specified 
		
		byte b1 = 1;
		b1 += 128; // there is cast because of that compund assignment
		
		byte b2 = 1;
		//byte b2 = b2 + 1; // wil not compile because the result of the add is an int wich is bigger than byte - you nedd cast!!!
		

	}

}
