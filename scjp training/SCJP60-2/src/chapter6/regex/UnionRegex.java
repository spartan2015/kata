package chapter6.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnionRegex {

	public static void main(String args[]){
		
		String source = "abcdefg";
		BasicRegexp.printString(source);
		
		Pattern pattern = Pattern.compile("[a-c[b-e]]"); // union of sets by nested brackets
		
		
		Matcher matcher = pattern.matcher(source);
		
		while(matcher.find()){
			System.out.println(matcher.start() + ": " + matcher.group());
		}

		
	}
	
}
