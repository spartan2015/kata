package strings.algo;

import org.junit.Test;

public class Count {

	@Test
	public void test(){
		
		Alphabet alphabet = new DefaultStringAlphabet("ABCD");
		int[] count = new int[alphabet.R()];
		
		String someInput = "ABCDABCD";
		for(int i =0; i< someInput.length(); i++){
			char ch = someInput.charAt(i);
			
			if (alphabet.contains(ch)){
				count[alphabet.toIndex(ch)]++;
			}
		}
		
		for(int i =0; i<alphabet.R(); i++){
			System.out.println(alphabet.toChar(i) + " = " + count[i]);
		}
	}
	
}
