package algos2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class DijkstraArithmenticExpressionInterpreter {

	@Test
	public void test(){
		assertEquals(Integer.valueOf(4) ,parse("( 1 + ( 1 * 3 ) )"));
		
		assertEquals(Integer.valueOf(12) ,parse("( 1 + ( ( 1 * 3 ) + ( 4 * 2 ) ) )"));
		
		assertEquals(Integer.valueOf(9) ,parse("( 1 + ( 2 * ( 3 + 1 ) ) )"));
	}
	
	public static Integer parse(String expression){
		String[] inputArray = expression.split("\\s");
		Stack<Integer> values = new Stack<>();
		Stack<String> operators = new Stack<>();

		for (String string : inputArray) {
			if ("(".equals(string))
				;
			else if ("+".equals(string))
				operators.push(string);
			else if ("*".equals(string))
				operators.push(string);
			else if (")".equals(string)) {
				Integer lastValue = values.pop();
				String lastOp = operators.pop();
				switch (lastOp) {
				case "+":
					lastValue += values.pop(); break;
				case "*":
					lastValue *= values.pop(); break;
				}
				values.push(lastValue);
			} else
				values.push(Integer.valueOf(string));

		}
		return values.pop();
	}

}
