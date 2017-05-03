package stackandqueue;

import java.util.LinkedList;
import java.util.stream.IntStream;

import org.junit.Test;

public class HanoiTest {

	@Test
	public void hanoi() {
		LinkedList[] stacks = { new LinkedList(), new LinkedList(), new LinkedList() };
		stacks[0].push(3);
		stacks[0].push(2);
		stacks[0].push(1);

		hanoi(3, stacks[0], stacks[1], stacks[2]);
		IntStream.rangeClosed(1,3).forEach(i->{
			System.out.println(stacks[2].pop());
		});
	}

	private void hanoi(int n, LinkedList from, LinkedList using, LinkedList to) {
		if (n == 0) return;
		hanoi(n - 1, from, to, using);		
		to.push(from.pop());
		hanoi(n - 1, using, from, to);
	}

}
