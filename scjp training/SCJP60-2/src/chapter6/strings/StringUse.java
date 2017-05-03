package chapter6.strings;

public class StringUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// ALL WRAPPERS + STRINGS are immutable !!!
		
		Integer i1 = 1;
		Integer i2 = i1;
		
		i1 += 1;
		System.out.println("i2 == i1: "  + (i2 == i1) + ", i1=" + i1 +", i2 = " + i2); // INTEGER IMMUTABLE TEST
		
		// String methods:
		
		String s = "abc";
		// 1. charAt(int index)
		System.out.println("1. charAt(0) " + s.charAt(0));
		
		// 2. concat(String s)
		System.out.println("2. concat(\"def\") " + s.concat("def")); // pay attention - actually there are 3 strings involved here, 2 just created with concat(String s);
		
		// 3. equalsIgnoreCase(String s)
		System.out.println("3. equalsIgnoreCase(String s) " + s.equalsIgnoreCase("ABC"));
	
		// 4. length() - this is interesting - an array Object has a public property named array.length - without ()
		System.out.println("4. s.length() " + s.length());
		
		// 5.1 replace(char c, char c)
		System.out.println("5.1 replace(char c, char c)" + s.replace('a', 'X'));
		
		// 5.2 replace(CharSequence cs, CharSequence cs) - a char sequence: StringBuffer, StringBuilder, CharBuffer, String, javax.swing.Segment
		System.out.println("5.2 replace(CharSequence cs, CharSequence cs)" + s.replace(new StringBuffer("a"), new StringBuffer("X")));
		
		// 5.3 replaceAll(String rexex, String replacement)
		System.out.println("5.3 replaceAll(String rexex, String replacement)" + s.replaceAll("[a]{1,1}", "X"));
		
		// 6.1 s.substring(int begin)
		System.out.println("6.1 s.substring(int begin) " + s.substring(0));
		
		// 6.2 s.substring(int begin,int until)
		System.out.println("6.2 s.substring(int begin,int until) " + s.substring(0,2));
		
		// 7. s.toLowerCase()
		System.out.println("7. s.toLowerCase() " + s.toLowerCase());
		
		// 8. s.toString()
		System.out.println("8. s.toString() " + s.toString());
		
		// 9. s.toUpperCase()
		System.out.println("9. s.toUpperCase() " + s.toUpperCase());
		
		// 10. s.trim()
		System.out.println("10. s.trim() " + s.trim());
	}

}
