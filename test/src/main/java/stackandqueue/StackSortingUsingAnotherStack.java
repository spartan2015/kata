package stackandqueue;

import java.util.LinkedList;

import org.junit.Test;

public class StackSortingUsingAnotherStack {

	@Test
	public void test() {
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(1);
		stack.push(4);
		stack.push(2);
		stack.push(3);
		stack = sort(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	private LinkedList<Integer> sort(LinkedList<Integer> stack) {
		LinkedList<Integer> aux = new LinkedList<>();
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			if (aux.peek() != null) {
				while (aux.peek() != null && tmp > aux.peek()) {
					stack.push(aux.pop());
				}
			}
			aux.push(tmp);
		}
		return aux;
	}

}
