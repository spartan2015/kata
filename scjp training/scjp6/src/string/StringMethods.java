package string;

public class StringMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s = "abc";
		
		System.out.println(s.charAt(0));
		
		System.out.println(s.concat("def"));
		
		System.out.println(s.equalsIgnoreCase("ABC"));
		
		System.out.println(s.length());
		
		System.out.println(s.replace("a", "x"));
		
		System.out.println(s.substring(0,1));
		
		System.out.println(s.toLowerCase());
		
		System.out.println(s.toString());
		
		System.out.println(s.toUpperCase());
		
		System.out.println(" 1 ".trim());
		

	}

}
