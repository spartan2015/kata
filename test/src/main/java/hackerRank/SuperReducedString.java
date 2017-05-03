package hackerRank;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class SuperReducedString {

	@Test
	public void t1(){
		assertEquals("abd", reduce("aaabccddd"));
		assertEquals("Empty String", reduce("aa"));
		assertEquals("Empty String", reduce("baab"));
	}

	public static void main(String[] args) {
        System.out.println(reduce(new Scanner(System.in).next()));
    }
	
	private static String reduce(String string) {
		StringBuilder sb = new StringBuilder(string);
		boolean removed = false;
		do{
			removed= removeDupes(sb);
		}while(removed);
		if (sb.length() == 0){
			return "Empty String";
		}else{
			return sb.toString();
		}
	}

	private static boolean removeDupes(StringBuilder sb) {
		for(int i =1; i< sb.length(); i++){
			if (sb.charAt(i-1) == sb.charAt(i)){
				sb.delete(i-1, i+1);
				return true;
			}
		}
		return false;
	}
	
}
