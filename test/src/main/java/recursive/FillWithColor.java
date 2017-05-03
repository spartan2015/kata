package recursive;

import java.util.Arrays;

import org.junit.Test;

public class FillWithColor {

	@Test
	public void test(){
		int[][] arr = new int[][]{{0,3,0},{0,0,0},{0,3,0}};
		fill(0, 0, arr, 0);
		for(int[] ar : arr){
			System.out.println(Arrays.toString(ar));
		}
	}

	private void fill(int x, int y, int[][] arr, int replace) {
		if (arr[x][y] != replace){
			return;
		}
		arr[x][y] = 1;		
		if (y < arr.length-1){
			fill(x,y+1,arr, replace);
		}
		if (x < arr.length-1){
			fill(x+1,y,arr,replace);
		}
		if (y <= arr.length-1 && y > 0){
			fill(x,y-1,arr,replace);
		}
		if (x <= arr.length-1 && x > 0){
			fill(x-1,y,arr, replace);
		}
	}
}
