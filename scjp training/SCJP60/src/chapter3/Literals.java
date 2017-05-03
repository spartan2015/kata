/**
 * Capitolul 3 din SCJP 6.0 - Literali
 * 
 * @author Vasile IRIMIA
 */
package chapter3;


public class Literals{
	
	public static void main(String args[]){
		
		// automatic narrow by compiler since all literals are ints
		byte a = -128; // -128 - 127
		// is same as
		byte a11 = (byte)-128;
		
		// all expression based on int or smaller result in int
		byte x1 = 8;
		byte x2 = 2;
		// WEIRD
		//byte x3 = x1 + x2; // COMPILER ERROR
		byte x4 = (byte)(x1 + x2);
		
		
		char b = 65535; // 0 - 65535 - this is UNICODE 16 bits - UTF-16
		char c1 = '\u004E';
		System.out.println(c1);
		
		
		
		 // RIDICULOUS but LEGAL
		char c2 = (char) 70000; // left most bits are lost - it circles
		System.out.println("char c2 = (char) 70000 = " + (int)c2);
		char c3 = (char)-1; //
		System.out.println("char c3 = (char)-1 = " + (int)c3);
		
		
		
		short c = 5; // all literals numeric are INT - then trunctated to fit short
		// short is -32768 to 32767
				
		Short sh = 32767; // auto boxing 
		
		int d = 4; // from - 2 140 000 000 to + 2 140 000 000
		
		long g = 4; // int fits in long
		
		float e = (float)3.1; // all comma numeric are DOUBLE
		
		double f = 23333.33333; 
		
		
		
		// INTEGER LITERALS IN THREE WAYS:
		int a1 = 10; // baza 10
		
		long a2 = 01211111111111111111111L;// octal - 0-7 -------- !!! 22  digits after 0
		int a3 = 0xA; // hex - 0-9-A-F // ----------- !!! 16 digits after 0x
		
		System.out.println("10 in octal: " + 012);
		System.out.println("10 in hex: " + 0xA);
		
		
		
		/// WATH FOR THE COMMA "," in numbers 25,5 - COMPILE ERROR
		
		
		boolean sex = true;
		
		
		
		// IMPLICIT variable cast - assign a smaller to a bigger
		int y1 = 100;
		long y2 = a;
		
		// EXPLICIT CAST - asign bigger to smaller
		float f1 = 100.1F;
		int f2 = (int)f1; // narrowing with explicit cast
		
		
		
		
		// WEIRD
		long lo1 = 130L;
		byte lo2 = (byte) lo1;
		// gues what - is spits -126 - it loses the leftmost bits - only rightmost 8 bits remain - IT CIRCLES
		System.out.println("long lo1 = 129L;byte lo2 = (byte) lo1; = " + lo2);
		
		
		
		
	}
	
}