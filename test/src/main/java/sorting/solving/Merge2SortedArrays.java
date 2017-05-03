package sorting.solving;

import org.junit.Test;

public class Merge2SortedArrays {
	@Test
	public void test(){
		int[] a = {1,2,3,0,0};
		int[] b = {8,9};
		merge(a,b,2);
		assertTrue(a[3]==b[0]);
		
		a = new int[]{8,9,10,0,0};
		b= new int[]{1,2};
		merge(a,b,2);
		assertTrue(a[0]==b[0]);
		
		a = new int[]{1,2,4,0,0}; 
		b= new int[]{3,5};
		merge(a,b,2);
		assertTrue(a[0]==b[0]);
	}

	private void merge(int[] a, int[] b, int lastIndexInA) {
		int lastOfB = b.length-1;
		int lastOfA = lastIndexInA;
		for(int i = lastIndexInA+b.length; i >= 0; i--){
			if (lastOfB < 0) a[i] = a[lastOfA--];
			else if (lastOfA < 0) a[i] = b[lastOfB--];
			else if (a[lastOfA] > b[lastOfB]) a[i] = a[lastOfA--];
			else a[i] = b[lastOfB--];
		}
	}
	
	private void mergeBad(int[] a, int[] b) {
		if (b[b.length-1] <= a[0]){
			for(int i = a.length-1;  i > b.length -1 ;i--){
				a[i]=a[i-b.length];
			}
			for(int i = 0; i < b.length; i++){
				a[i]=b[i];
			}
		}else{
			int start = a.length-1;
			for(; a[start]==0;start--);
			start++;
			for(int i = 0; i < b.length; i++){
				a[start++]=b[i];
			}
		}
	}

	private void assertTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
