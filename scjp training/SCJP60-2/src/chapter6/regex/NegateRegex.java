package chapter6.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NegateRegex {
	
	public static void main(String[] args) {

		String source = "abcdefghijklmnoprstuvxyz";
		BasicRegexp.printString(source);
		
		Pattern pattern = Pattern.compile("[^a-c]");
		
		
		Matcher matcher = pattern.matcher(source);
		
		while(matcher.find()){
			System.out.println(matcher.start() + ": " + matcher.group());
		}

	}

}
