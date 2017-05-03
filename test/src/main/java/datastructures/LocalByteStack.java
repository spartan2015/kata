package datastructures;

import java.util.Arrays;
import java.util.List;

public class LocalByteStack {
	public byte[] arr = new byte[10];
	public int currentIndex = 0;
	public int sum=0;
	
	public LocalByteStack(){
		
	}
	
	public LocalByteStack(int size, List<Byte> list){
		arr = new byte[size];
		for(byte i : list){
			push(i);
		}
	}
	
	public LocalByteStack(List<Byte> list){
		this(10 ,list);
	}
	
	public LocalByteStack(byte initialValue){
		arr = new byte[10];
		push(initialValue);
	}
	
	public LocalByteStack copy(LocalByteStack stack){
		for(int i=0; i< stack.currentIndex; i++){
			push(stack.arr[i]);
		}
		return this;
	}
	
	public int peek(){
		return arr[currentIndex-1];
	}
	
	public void push(byte element) {
		expandIfNecessary();
		//sum+=data[element];
		arr[currentIndex++] = element;
	}

	private void expandIfNecessary() {
		if (currentIndex > arr.length-1){
			byte[] newArr = new byte[arr.length*2];
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