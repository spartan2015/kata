package stackandqueue;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class QueueUsingStacks {

	LinkedList<Integer> s1 = new LinkedList<>();
	LinkedList<Integer> s2 = new LinkedList<>();
	
	@Test
	public void test(){
		QueueUsingStacks queue = new QueueUsingStacks();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		assertTrue(1 == queue.dequeue());
		queue.enqueue(4);
		assertTrue(2 == queue.dequeue());
		queue.enqueue(5);
		assertTrue(3 == queue.dequeue());
		assertTrue(4 == queue.dequeue());
		assertTrue(5 == queue.dequeue());
	}
	
	public void enqueue(Integer e){
		s1.push(e);
	}
	
	public Integer dequeue(){
		if (s2.size() == 0 && s1.size() == 0) return null;
		if (s2.size() == 0 && s1.size() > 0){
			while(s1.size() > 0){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
}
