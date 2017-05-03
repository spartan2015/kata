package chapter6.regs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyExample {

	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("abcdef");
		while(m.find()){
			System.out.println((m.start()+1) + m.group());
		}

	}

}
