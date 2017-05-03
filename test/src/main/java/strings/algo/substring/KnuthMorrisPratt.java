package strings.algo.substring;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * complexity m+n
 * 
 * good for highly self repetitive patterns - not that many in practice - brute force will do for most
 * 
 * it never backs up in the input string
 * 
 * good for input streams - of undetermined length
 * 
 * boyer mooer is n/m typically - so much better 
 * 
 * 
 * building the dfa - m*r
 * 
 * @author vasil
 *
 */
public class KnuthMorrisPratt {

	@Test
	public void test(){
		assertEquals(Integer.valueOf(7), Integer.valueOf(search("ababad","abababaababad")));
	}
	
	@Test
	public void skipToTest(){
		assertTrue(0 == skipTo("aba",2,'b'));
		assertTrue(0 == skipTo("ababc",2,'b'));
		assertTrue(0 == skipTo("ababac",2,'a')); 
	}
	
	private int search(String pattern, String text) {
		int i =0;
		int j = 0;
		int M = pattern.length();
		int N = text.length();
		for(i=0, j=0; i <N && j < M; i++,j++){
			if (text.charAt(i)!=pattern.charAt(j)){
				j = skipTo(pattern, j, text.charAt(i));
			}
		}
		if (j==M) return i-j;
		return -1;
	}
	
	/**
	 * cache this so you don't need to compute it twice
	 * you'll have efficient knuth algo 
	 * 
	 * @param pattern
	 * @param x
	 * @param mismatchChar
	 * @return
	 */
	private int skipTo(String pattern, int x, char mismatchChar){
		int lastIndexOfmismatchCharInPattern = x;
		while((lastIndexOfmismatchCharInPattern =  pattern.lastIndexOf(mismatchChar,lastIndexOfmismatchCharInPattern))!=-1){
			for(int i = lastIndexOfmismatchCharInPattern, j=x; i >=0; i--,j--){
				if (pattern.charAt(i) != pattern.charAt(j)){
					continue;
				}				
			}
			System.out.println(lastIndexOfmismatchCharInPattern);
			return lastIndexOfmismatchCharInPattern;
		}
		return 0;
	}
	
	private int[][] constructSkipMap(String pattern){
		int R = 256;
		int[][] skipMap = new int[R][pattern.length()];
		char firstCharacter = pattern.charAt(0);
		skipMap[firstCharacter][0] = 1;
		
		for(int previousSkipToPosition = 0, indexInPattern = 1; indexInPattern < pattern.length(); indexInPattern++){
			// initially all jump to 0;
			for(int everyCharacter =0; everyCharacter < R; everyCharacter++){
				skipMap[everyCharacter][indexInPattern] = skipMap[everyCharacter][previousSkipToPosition]; 
			}
			
			// matching character just increments
			int currentCharacterInPattern = (int)pattern.charAt(indexInPattern);
			matchingCharacterJustGoesToTheNext(skipMap, indexInPattern, currentCharacterInPattern);
			
			// previousCharacterToSkipTo - this previous may be of another character - will reflect above when this change
			// previousSkipToPosition is effective only for characters that repeat themselves - and are in the pattern - only here
			// the possibility of skipping applies - the chars not in the pattern - always skip to 0
			//  so it depends on the previous characters skip to position- as many sa they may by and always increments
			previousSkipToPosition = skipMap[currentCharacterInPattern][previousSkipToPosition];
		}
		
		return skipMap;
	}

	private int matchingCharacterJustGoesToTheNext(int[][] skipMap, int indexInPattern, int currentCharacterInPattern) {
		return skipMap[currentCharacterInPattern][indexInPattern] = indexInPattern + 1;
	}
	
}
