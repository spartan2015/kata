package combinatorics;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import datastructures.LocalIntStack;

public class Combinatorics {

	@Test
	public void test(){
		int[] data = new int[]{1,2,3,4};
		int n = data.length;
		int k = 4;
		List<LocalIntStack> all = new ArrayList<>();
		List<LocalIntStack> result = combine(all,data, k);
		
		assertTrue(possibleCombinations(n,k) == result.size());
	}
	
	/**
	 * that is all combinations on all levels from 1 to data.length
	 * 
	 * @param data
	 * @param k
	 * @return
	 */
	public List<LocalIntStack> allSubsets(int[] data, int k) { 
		List<LocalIntStack> all = new ArrayList<>();
		combine(all,data, k);
		return all;
	}
	
	public List<LocalIntStack> combine(List<LocalIntStack> all, int[] data, int k) {
		if (k < 1) return Collections.EMPTY_LIST;
		List<LocalIntStack> initialList = new ArrayList<>();
		for(int i = 0; i < data.length; i++){
			initialList.add(new LocalIntStack(i));
		}
		all.addAll(initialList);
		if (k==1){
			return initialList;
		}else{
			return combine(all,initialList, data.length, k-1);
		}
	}

	private List<LocalIntStack> combine(List<LocalIntStack> all, List<LocalIntStack> list, int length, int k) {
		if (k == 0) return list;
		List<LocalIntStack> newList = new ArrayList<>();
		for(LocalIntStack stack : list){
			int start = stack.peek()+1;
			for(int j = start; j < length; j++){
				LocalIntStack newStack = new LocalIntStack();
				newStack.copy(stack);
				newStack.push(j);
				newList.add(newStack);
			}
		}
		all.addAll(newList);
		System.out.println(newList);
		return combine(all,newList,length, k-1);
	}

	public static int possibleCombinations(int n, int k){
		return factorial(n)/ (factorial(k)*factorial(n-k));
	}
	
	public static int factorial(int n){
		if (n <= 1) return 1;
		return n * factorial(n-1);
	}
	
}
