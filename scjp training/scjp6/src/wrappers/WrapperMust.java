package wrappers;

public class WrapperMust {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// wrapper objects: Integer, Character, Short, Byte, Boolean, Long, Float, Double,
		// ARE IMMUTABLE
		//construct wrapper object: contructor, .valueOf(primitive or String)
		
		Integer i = new Integer(1);
		Integer i1 = new Integer("1");
		Integer i2 = Integer.valueOf(1);
		Integer i3 = Integer.valueOf("1");
		
		// conversion:
		Integer i4 = new Integer(4);
		byte b = i4.byteValue();
		short s = i4.shortValue();
		long l = i4.longValue();
		float f = i4.floatValue();
		double d = i4.doubleValue();
		
		// parsing a String using Wrapper CLASS - RETURNS PRIMITIVE
		int a = Integer.parseInt("1");
		
		
		// ONLY LONG AND INTEGER ONLY!!!!!
		
		// Long and Integer provider an Interesting .toString()
		System.out.println(Long.toString(10,2)); // get the binnary representation of that thing - uuuu - this is great for 
		// port programming: serial and parallel
		System.out.println(Integer.toString(10,2));
		// the reverse would be
		System.out.println(0x10); // convert hex to decimal
		

		System.out.println(Integer.toBinaryString(16));
		System.out.println(Integer.toHexString(16));
		System.out.println(Integer.toOctalString(16));
	}

}
