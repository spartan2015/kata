package datastructures;

import java.util.Arrays;
import java.util.List;

public class LocalIntStack {
	public int[] arr = new int[10];
	public int currentIndex = 0;
	public int sum=0;
	
	public LocalIntStack(){
		
	}
	
	public LocalIntStack(int size, List<Integer> list){
		arr = new int[size];
		for(int i : list){
			push(i);
		}
	}
	
	public LocalIntStack(List<Integer> list){
		this(10 ,list);
	}
	
	public LocalIntStack(int initialValue){
		this(10, Arrays.asList(initialValue));
	}
	
	public LocalIntStack copy(LocalIntStack stack){
		for(int i=0; i< stack.currentIndex; i++){
			push(stack.arr[i]);
		}
		return this;
	}
	
	public int peek(){
		return arr[currentIndex-1];
	}
	
	public void push(int element) {
		expandIfNecessary();
		sum+=element;
		arr[currentIndex++] = element;
	}

	private void expandIfNecessary() {
		if (currentIndex > arr.length-1){
			int[] newArr = new int[arr.length*2];
			for(int i=0; i< arr.length; i++){
				newArr[i]=arr[i];
			}
			arr = newArr;
		}
	}
	
	public String toString(){
		return Arrays.toString(Arrays.copyOf(arr, currentIndex));
	}
}