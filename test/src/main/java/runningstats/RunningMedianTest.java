package runningstats;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

import org.junit.Test;

import trees.structures.RedBlackTree;

public class RunningMedianTest {

	@Test
	public void test() {
		RunningMedian<Integer> rm = new RunningMedian<>();
		IntStream.rangeClosed(1, 24).forEach(i -> {
			rm.add(i);
			System.out.println(i + " median so far: " + rm.median());
		});
	}

	@Test
	public void tree() {
		RedBlackTree<Integer,Integer> tree = new RedBlackTree<>();
		IntStream.rangeClosed(1, 24).forEach(i -> {
			tree.put(i,i);
			System.out.println(i + " median so far: " + getMedian(tree));
		});
	}

	private Integer getMedian(RedBlackTree<Integer,Integer> tree) {
		if (tree.size() % 2 ==0){
			return null;
		}else {
			return tree.select(tree.size()/2+1);
		}
	}
}

class RunningMedian<E extends Comparable<E>> { // how about a Tree - get element at position( middle (depends on size%2)
	PriorityQueue<E> firstHalf = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
	PriorityQueue<E> secondHalf = new PriorityQueue<>();

	public void add(E element) {
		PriorityQueue<E> whereToAdd = null;
		if (firstHalf.size() == 0 && secondHalf.size() == 0) {
			whereToAdd = firstHalf;
		} else if (firstHalf.size() == 0 && less(element, secondHalf.peek())) {
			whereToAdd = firstHalf;
		} else if (less(element, firstHalf.peek())) {
			whereToAdd = firstHalf;
		} else {
			whereToAdd = secondHalf;
		}

		whereToAdd.add(element);

		if (Math.abs(firstHalf.size() - secondHalf.size()) > 1) {
			if (firstHalf.size() > secondHalf.size()) {
				secondHalf.add(firstHalf.remove());
			}else{
				firstHalf.add(secondHalf.remove());
			}
		}
	}

	public E median() {
		int combinedSize = firstHalf.size() + secondHalf.size();
		if (combinedSize % 2 == 0 || combinedSize < 3) {
			return null;
		} else if (firstHalf.size() > secondHalf.size()) {
			return firstHalf.peek();
		} else {
			return secondHalf.peek();
		}
	}

	private boolean less(E e1, E e2) {
		return e1.compareTo(e2) < 0;
	}

}