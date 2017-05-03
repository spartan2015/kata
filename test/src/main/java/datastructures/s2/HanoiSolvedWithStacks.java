package datastructures.s2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class HanoiSolvedWithStacks {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();;
	Stack<Integer> s3 = new Stack<>();;

	@Test
	public void test() {

		s1.push(3);
		s1.push(2);
		s1.push(1);

		hanoi(3, s1, s2, s3);

		assertEquals(Integer.valueOf(1), s3.pop());
		assertEquals(Integer.valueOf(2), s3.pop());
		assertEquals(Integer.valueOf(3), s3.pop());
	}

	private void hanoi(int n, Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
		if (n ==0) return;
		hanoi(n - 1, s1, s3, s2);
		s3.push(s1.pop());
		hanoi(n - 1, s2, s1, s3);
	}

}
