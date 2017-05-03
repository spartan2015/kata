package algos2.exercises;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class BalancingParenthesis {

	@Test
	public void t() {

		assertTrue(valid("[()]{}{[()()]()}"));
		assertFalse(valid("[(])"));

	}

	private boolean valid(String string) {
		Stack<Character> parenthesis = new Stack<Character>();
		char o = 0;
		
		for (char c : string.toCharArray()) {

			switch (c) {
			case '}':
				o = parenthesis.pop();
				if (o != '{'){
					return false;
				}
				break;
			case ']':
				o = parenthesis.pop();
				if (o != '['){
					return false;
				}
				break;
			case ')':
				o = parenthesis.pop();
				if (o != '('){
					return false;
				}
				break;
			default:
				parenthesis.push(c);
				break;
			}
		}

		if (parenthesis.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}

}
