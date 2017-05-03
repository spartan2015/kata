package auboxing;

public class WideningOfPrimitives {
	public static void main(String[] args){
		// the rules is: if no exact match then find the smallest bigger of what is available
		// in primitive case, widening happens before any boxing - if it can be by the above rule
		// wide then box then var-arg
		byte b = 127;
		short s = 32565;
		int i = 1;
		long l = 1;
		float f= 1;
		double d = 1;
		
		doer(b);
		doer(s);
		doer(i);
		doer(l);
		doer(f);
		doer(d);
		
		// boxing beats var-arg
		doer(i,i);
		
		// Wrapper objeects have no relation between them - a Short is NOT != an Integer - no widening possible in this case
	}
	
	static void doer(int i){
		System.out.println("int");
	}
	static void doer(long i){
		System.out.println("long");
	}
	
	static void doer(double i){
		System.out.println("double");
	}
	
	static void doer(Integer i){
		System.out.println("Integer");
	}
	
	static void doer(Integer i, Integer y){
		System.out.println("Integer, Integer");
	}
	
	static void doer(int... i){
		System.out.println("int...");
	}
}
