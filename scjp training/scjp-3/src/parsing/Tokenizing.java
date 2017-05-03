package parsing;

import java.util.Arrays;

public class Tokenizing {
	public static void main(String[] args){
		String[] s = "a1s1d".split("\\d");
		System.out.println(Arrays.toString(s));
		
		String[] s1 = "a1s1d".split("[a-x]");
		System.out.println(Arrays.toString(s1));
	}
}
