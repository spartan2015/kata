package chapter6.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicRegexp {
	
	public static void main(String[] args) {
		
		String source = "abaaaba";
		Pattern pattern = Pattern.compile("a(b)");
		
		Matcher matcher = pattern.matcher(source);
		printString(source);
		while(matcher.find()){
			System.out.println(matcher.start() + ": " + matcher.group());
			System.out.println("subgroup: " + matcher.groupCount() + " group 1: " + matcher.group(1));
		}
		
	}
	
	public static void printString(String string){
		for(int i = 0; i<string.length(); i++){
			System.out.print(string.charAt(i) + "\t");
		}
		System.out.println();
		for(int i =0; i< string.length(); i++){
			System.out.print(i + "\t");
		}
		System.out.println();
	}

}
