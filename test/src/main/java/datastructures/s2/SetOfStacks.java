package datastructures.s2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import org.junit.Test;

public class SetOfStacks<E> {
	List<Stack<E>> stacks = new ArrayList<>();
	int maxCapacity = 5;

	public void push(E e) {
		ensureCapacity();
		getLast().push(e);
	}

	private Stack<E> getLast() {
		return stacks.get(stacks.size() - 1);
	}

	private void ensureCapacity() {
		if (stacks.isEmpty() || getLast().size() == maxCapacity) {
			stacks.add(new Stack<E>());
		}
	}

	public E pop() {
		if (stacks.isEmpty())
			return null;
		E tmp = getLast().pop();
		removeEmpty();
		return tmp;
	}

	private void removeEmpty() {
		if (getLast().size() == 0 && stacks.get(0) != getLast()) {
			stacks.remove(stacks.size() - 1);
		}
	}

	public E popAt(int i) {
		if (i > stacks.size() - 1)
			return null;
		E element = stacks.get(i).pop();
		rollOver(i);
		return element;
	}

	private void rollOver(int i) {
		if (i < stacks.size() - 1) {
			for (int j = i + 1; j < stacks.size(); j++) {
				stacks.get(j - 1).push(stacks.get(j).elementAt(0));
				stacks.get(j).remove(0);
			}
		}
		removeEmpty();
	}
	
	@Test
	public void test(){
		SetOfStacks<Integer> set = new SetOfStacks<>();
		IntStream.rangeClosed(0,99).forEach(i->{
			set.push(i);
		});
		IntStream.rangeClosed(0,99).forEach(i->{
			assertEquals(Integer.valueOf(99-i),set.pop());
		});
		
		IntStream.rangeClosed(0,14).forEach(i->{
			set.push(i);
		});
		assertEquals(Integer.valueOf(9), set.popAt(1));
		assertEquals(Integer.valueOf(10), set.popAt(1));
		assertEquals(Integer.valueOf(11), set.popAt(1));
		assertEquals(Integer.valueOf(12), set.popAt(1));
		assertEquals(Integer.valueOf(13), set.popAt(1));
		assertEquals(Integer.valueOf(14), set.popAt(1));
		assertEquals(Integer.valueOf(8), set.popAt(1));
		
	}
}
