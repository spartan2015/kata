package datastructures.s2;

import static org.junit.Assert.*;

import java.util.Stack;
import java.util.stream.IntStream;

import org.junit.Test;

public class SortAStackUsingAnotherStack {
	
	@Test
	public void test(){
		Stack<Integer> toSort = new Stack<>();
		toSort.push(1);
		toSort.push(3);
		toSort.push(2);
		toSort.push(4);
		
		sort(toSort);
		
		IntStream.rangeClosed(1,4).forEach(i->{
			assertEquals(Integer.valueOf(i), toSort.pop());
		});
	}

	private void sort(Stack<Integer> toSort) {
		Stack<Integer> other = new Stack<>();
		do{
			if (other.isEmpty() || toSort.peek() > other.peek()){
				other.push(toSort.pop());
			}else{
				Integer tmp = toSort.pop();
				while(other.size() > 0 && other.peek() > tmp){
					toSort.push(other.pop());
				}
				other.push(tmp);
			}
		}while(!toSort.isEmpty());
		
		while(!other.isEmpty()){
			toSort.push(other.pop());
		}
	}
}