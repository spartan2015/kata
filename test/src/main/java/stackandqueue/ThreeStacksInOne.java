package stackandqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeStacksInOne {

	private int singleStackSize = 5;
	private int[] storage = new int[singleStackSize * 3];
	private int[] stacksIndex = new int[3];

	@Test
	public void test(){
		ThreeStacksInOne s = new ThreeStacksInOne();
		testStack(s, 0);
		testStack(s, 1);
		testStack(s, 2);
	}

	private void testStack(ThreeStacksInOne s, int stackNo) {
		s.push(stackNo, 1);
		s.push(stackNo, 2);
		s.push(stackNo, 3);
		assertTrue(3 == s.pop(stackNo));
		assertTrue(2 == s.pop(stackNo));
		assertTrue(1 == s.pop(stackNo));
	}
	
	public void push(int stack, int value){
		int index = stack * singleStackSize + stacksIndex[stack]; 
		storage[index] = value;
		stacksIndex[stack]++;
	}
	
	public int pop(int stack){
		int index = stack * singleStackSize + stacksIndex[stack] -1;
		int value = storage[index];
		storage[index] = 0;
		stacksIndex[stack]--;
		return value;
	}

}
