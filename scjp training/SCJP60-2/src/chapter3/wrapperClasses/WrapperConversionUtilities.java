package chapter3.wrapperClasses;

public class WrapperConversionUtilities {

	
	public static void main(String[] args) {
	
		// I - CONVERSION - each wrapper has 6 methods xxxValue() to convert to any primitive
		Double d1 = new Double("3.14");
				
		System.out.println(d1.byteValue());
		System.out.println(d1.shortValue());
		System.out.println(d1.intValue());
		System.out.println(d1.longValue());
		System.out.println(d1.floatValue());
		System.out.println(d1.doubleValue());
		
		

		// II - Parsing string and return primitive: parseXXX();
		
		double d2 = Double.parseDouble("3.1441");
		
		
		// III - toString
		
		System.out.println(d1.toString());
		
		// HERE IS THE KICK - you can toString with RADIX - ONLY INTEGER AND LONG
		
		for(int i = 0; i < 11; i++){
			System.out.println(Integer.toString(i, 2));
		}
		
		
	}

}
