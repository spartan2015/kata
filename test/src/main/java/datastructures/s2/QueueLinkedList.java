package datastructures.s2;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

public class QueueLinkedList<E> {
	Node<E> head;
	Node<E> tail;
	int count;

	static class Node<T> {
		Node<T> next;
		T value;

		Node(T val) {
			this.value = val;
		}
	}
	
	public void enqueue(E e){
		Node<E> newNode = new Node<>(e);
		if (head == null){
			head = newNode;
		}else{
			Node<E> addTo = head;
			while(addTo.next!=null){
				addTo = addTo.next;
			}
			addTo.next = newNode;
			count++;
		}
		this.tail = newNode;
	}
	
	public E dequeue(){
		if (head == null){
			return null;
		}else{
			Node<E> toReturn = head;
			this.head = head.next;
			if (this.tail ==toReturn){
				this.tail = null;
			}
			count--;
			return toReturn.value;
		}
	}
	
	@Test
	public void test(){
		QueueLinkedList<Integer> q = new QueueLinkedList<>();
		IntStream.rangeClosed(0,10).forEach(i->q.enqueue(i));
		
		IntStream.rangeClosed(0,10).forEach(i->{
			assertEquals(Integer.valueOf(i), q.dequeue());
		});
	}
}
