package strings.algo.substring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * this one here takes n M worst case but full Boyer Moore has linear time guarantee cause of correct table build
 * 
 * average performance: n/m - the best - but worse case n*m - hm...
 * 
 * based on the ideea that we can backup in the inpput text - would need buffers in inputstreams of the size of the pattern
 * 
 * scanning from right to left - on first mismatch we can decide where to jump - with either j or i 
 * 
 * @author vasil
 *
 */
public class BoyerMooreSubstringSearch {

	@Test
	public void test1(){
		assertEquals(Integer.valueOf(0), Integer.valueOf(search("elefant","elefant")));		
	}
	
	@Test
	public void test2(){
		assertEquals(Integer.valueOf(3), Integer.valueOf(search("elefant","123elefant")));
		
	}
	
	@Test
	public void test3(){
		assertEquals(Integer.valueOf(9), Integer.valueOf(search("elefant","123elefanelefant")));
	}
	
	@Test
	public void test4(){
		assertEquals(Integer.valueOf(15), Integer.valueOf(search("needle","findinahaystackneedle")));
	}
	

	private int search(String pattern, String text) {
		int M = pattern.length();
		int N = text.length();
		for(int i = M-1; i < N ;i++){
			int lastIndexInPattern = M-1;
			int j = lastIndexInPattern;
			for(; j >=0 && i < N; j--){
				int indexToMatchInText = i-(lastIndexInPattern-j);
				if (pattern.charAt(j)!=text.charAt(indexToMatchInText)){
					i = skipTo(pattern, text, indexToMatchInText, j);
					j = lastIndexInPattern+1;// plus 1 because of continue goes to j-- in for
					continue;
				}
			}
			if (j == -1){ return i-(lastIndexInPattern);}
		}
		
		return -1;
	}

	/**
	 * my correct try to boyer-moore skip
	 * @param pattern
	 * @param text
	 * @param i
	 * @param j
	 * @return
	 */
	private int skipTo(String pattern,String text, int i, int j) {
		char cText = text.charAt(i);
		int lastIndexOf = pattern.lastIndexOf(cText);
		if (lastIndexOf!=-1){
			return i+ (pattern.length() - 1 - lastIndexOf);
		}else{
			return i+ pattern.length();
		}
	}
	
}
