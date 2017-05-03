package parsingtext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {

	
	public static void main(String[] args) {
		finder("abaaaba","ab");
		finder("0123","\\d");
		finder("0123","\\d*");
		finder("01 23","\\s");
		finder("01 23","\\w"); // letter, digits or underscore
		
		finder("abcdef","[a-c]");
		finder("abcdef","[^a-c]"); // negation with ^ - the xor in java, the negation in regexp
		finder("abcdef","[[a-c][c-d]]"); // union of sets - nested brackets
		finder("abcdef","[a-c&&c-x]"); // && intersection of sets
		
		finder("12 0x 0x12 0Xf 0xg","0[xX][0-9a-fA-F]");
		finder("12 0x 0x12 0Xf 0xg","0[xX][0-9a-fA-F]+");
		
		finder("proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java","proj1[^,]*");
		
		// GREEDY QUANTIFIERS
		finder("yyxxxyxx",".*xx"); // THIS IS GREADY
		
		finder("yyxxxyxx",".*?xx"); // RELUCTANT
	}
		
	static void finder(String s, String pattern){
		System.out.println("String: " + s + ", pattern: " + pattern);
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		
		while(m.find()){
			System.out.println("Found at: " + m.start() + "\t" + m.group());
		}
		System.out.println();
	}

}
