package algos2.exercises;

import java.util.Arrays;
import java.util.Stack;

public class InsertParenthesis {

	public String insert(String string) {

		Stack<String> operands = new Stack<>();
		Stack<String> operators = new Stack<>();
		Stack<String> parenthesis = new Stack<>();

		for (int i = 0; i < string.length(); i++) {
			String c = string.charAt(i) + "";
			if (Arrays.asList("+", "-", "*").contains(c)) {
				operators.push(c);
			} else if (c.equals(")")) {
				parenthesis.push("(");
				parenthesis.push(")");
			} else {
				operands.push(c);
			}
		}
		
		return string;
	}
}
