package chapter6.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitsRegex {

	
	public static void main(String[] args) {
		String source = "11hb3h21j3j21h31hj13";
		BasicRegexp.printString(source);
		
		Pattern pattern = Pattern.compile("\\d+");
		
		
		Matcher matcher = pattern.matcher(source);
		
		while(matcher.find()){
			System.out.println(matcher.start() + ": " + matcher.group());
		}
	}

}
