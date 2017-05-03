package chapter6;

public class StringBuilderAndStringBuffer {
	
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("A");
		
		/**
		 * APPEND
		 */
		sb.append("bX");
		
		/**
		 * DELETE
		 */
		sb.delete(2, 3);
		
		/**
		 * INSERT - spune asa - incepand cu POZITIA X insereaza.
		 */
		sb.insert(2, "c");
		
		System.out.println(sb);
		
		/**
		 * REVERSE
		 */
		System.out.println(sb.reverse());
		

	}

}
