package amazon;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * given a string output if brackets are balanced
 * 
 * 
 * @author vasil
 *
 */
public class Q1 {

	private static final List<Character> OPENING_BRACKETS_AS_LIST = Arrays.asList('(', '{', '[', '<');
	private static final List<Character> CLOSING_BRACKETS_AS_LIST = Arrays.asList(')', '}', ']', '>');

	public static int hasBalancedBrackets(String str) {
		if (str == null || str.length() == 0)
			return 1;

		Stack<Character> bracketsStack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (isOpeningBracket(currentChar)) {
				bracketsStack.push(currentChar);
			} else if (isClosingBracket(currentChar)) {
				if (bracketsStack.size() ==0 |  !matchOpenCloseBracket(bracketsStack.pop(), currentChar)) {
					return 0;
				}
			}
		}

		if (bracketsStack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

	private static boolean matchOpenCloseBracket(char openingBracket, char char2) {
		switch (openingBracket) {
		case '(': return char2==')';
		case '[': return char2==']';
		case '{': return char2=='}';
		case '<': return char2=='>';
		}
		return false;
	}

	private static boolean isClosingBracket(char currentChar) {
		return CLOSING_BRACKETS_AS_LIST.contains(currentChar);
	}

	private static boolean isOpeningBracket(char currentChar) {
		return OPENING_BRACKETS_AS_LIST.contains(currentChar);
	}

	
	
	@Test
	public void test1() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("(h[e{lo}!]~)()()()(")));
	}

	@Test
	public void test2() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("]")));
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(hasBalancedBrackets("[](){}<>")));
		
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("[")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("(")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("{")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("<")));
		
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("<{>")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("<{>}")));
		assertEquals(Integer.valueOf(1), Integer.valueOf(hasBalancedBrackets("<{}>")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("<[>}")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(hasBalancedBrackets("<[}>")));
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(hasBalancedBrackets(null)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(hasBalancedBrackets("")));
	}

	@Test
	public void tb1() {
		assertTrue(isOpeningBracket('('));
		assertTrue(isOpeningBracket('['));
		assertTrue(isOpeningBracket('{'));
		assertTrue(isOpeningBracket('<'));
		assertFalse(isOpeningBracket(' '));
	}

	@Test
	public void tb2() {
		assertFalse(isOpeningBracket(')'));
		assertFalse(isOpeningBracket(']'));
		assertFalse(isOpeningBracket('}'));
		assertFalse(isOpeningBracket('>'));
		assertFalse(isOpeningBracket('-'));
	}
	
	@Test
	public void sameBracketTest(){
		assertTrue(matchOpenCloseBracket('(', ')'));
		assertTrue(matchOpenCloseBracket('[', ']'));
		assertTrue(matchOpenCloseBracket('{', '}'));
		assertTrue(matchOpenCloseBracket('<', '>'));
		assertFalse(matchOpenCloseBracket(']', '['));
		assertFalse(matchOpenCloseBracket('(', ']'));
	}
	
}
