package strings.algo.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * using same idea as indexed count sort
 * but doing it for each letter - doing the count for each letter then the sort 
 * 
 * Complexity: 7WN + 3WR array accesses - a linear growth sort - based in N and R - grows lineary with the size of input 
 * Space: N+R
 * 
 * @author vasil
 *
 */
public class LeastSignificantDigitSort {

	@Test
	public void test(){
		String[] a = {"abc","ab","a"};
		sort(a,2);
		
		assertEquals("ab", a[0]);
		System.out.println(Arrays.toString(a));
	}
	
	private void sort(String[] a, int W){
		for(int i = 0; i < W; i++){
			indexCountSort(a, i);
		}
	}
	
	private void indexCountSort(String[] a, int charIndexFromRightToLeft){
		int N = a.length;
		int R = 256; // extended ascii alphabet considered
		
		int[] count = new int[R+1]; //R+1!!!
		for(String str : a){
			char c = str.charAt(charIndexFromRightToLeft);
			count[c+1]++; // N - first always 0 //CRITICAL POINT
		}
		for(int r = 0; r < R ; r++){
			count[r+1]+=count[r]; // 3R
		}
		String[] aux = new String[N];
		for(String str : a){
			char c = str.charAt(charIndexFromRightToLeft);
			int countOfPrevCharIndex = c; //CRITICAL POINT
			aux[count[countOfPrevCharIndex]++]=str;
		}
		for(int i =0; i< a.length;i++){
			a[i] = aux[i]; // 1 write + 1 read = 2 N
		}
	}
}
