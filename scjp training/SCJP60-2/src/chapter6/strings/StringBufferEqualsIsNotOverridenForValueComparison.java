package chapter6.strings;

public class StringBufferEqualsIsNotOverridenForValueComparison {

	
	public static void main(String[] args) {
	
		
		StringBuffer sb1 = new StringBuffer("a");
		
		StringBuffer sb2 = new StringBuffer("a");
		
		System.out.println(sb1 == sb2 ); // EQUAL FALSE - NOT OVERRIDEN IN StringBuilder and StringBuffer

	}

}
