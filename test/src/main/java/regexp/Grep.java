package regexp;

import java.util.Scanner;

public class Grep {
	public static void main(String[] args) {
		String regexp = "(.*" + args[0] + ".*)";
		NFA nfa = new NFA(regexp);
		Scanner in = new Scanner(System.in);
		String line = null;
		while(in.hasNextLine()){
			line = in.nextLine();
			if (nfa.match(line)){
				System.out.println(line);
			}
		}
	}
}
