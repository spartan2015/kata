package strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringIsRotationOf {

	@Test
	public void test(){
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		
		assertTrue(isRotation(str1,str2));
		
		assertTrue(isRotationVersion2(str1,str2));
	}

	private boolean isRotationVersion2(String str1, String str2) {
		if (str1.length() != str2.length() && str1.length() ==0){
			return false;
		}
		return (str1+str1).indexOf(str2)>=0;
	}
	
	private boolean isRotation(String str1, String str2) {
		return isCharRotation(str1.toCharArray(), str2.toCharArray(), 0);
	}

	private boolean isCharRotation(char[] charArray, char[] charArray2, int start) {
		if (start > charArray.length-1){
			return false;
		}
		for(int i = 0; i < charArray.length; i++){
			int actualCol = start + i > charArray.length-1 ? start + i-charArray.length: start+i;
			if (charArray[actualCol] != charArray2[i]){
				return isCharRotation(charArray, charArray2, start+1);
			}
		}
		return true;
	}	
}