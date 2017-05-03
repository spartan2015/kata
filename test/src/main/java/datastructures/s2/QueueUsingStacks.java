package datastructures.s2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class QueueUsingStacks<E> {

	Stack<E> put = new Stack<>();
	Stack<E> get = new Stack<>();
	
	@Test
	public void test(){
		QueueUsingStacks<Integer> q = new QueueUsingStacks<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		assertEquals(Integer.valueOf(1), q.dequeue());
		assertEquals(Integer.valueOf(2), q.dequeue());
		
		q.enqueue(4);
		
		assertEquals(Integer.valueOf(3), q.dequeue());
		assertEquals(Integer.valueOf(4), q.dequeue());
	}

	private E dequeue() {
		if (get.size() == 0){
			while(put.size()!=0){
				get.push(put.pop());
			}
		}
		return get.pop();
	}

	private void enqueue(E e) {
		put.push(e);
	}
	
}
