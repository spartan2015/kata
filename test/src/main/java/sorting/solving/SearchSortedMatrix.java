package sorting.solving;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SearchSortedMatrix {

	@Test
	public void test(){
		int[][] matrix = {{2,4,6},{8,10,12},{14,16,18}};
		
		assertTrue(Arrays.equals(new int[]{1,2}, searchMatrix(matrix, 12)));
		assertTrue(Arrays.equals(new int[]{1,1}, searchMatrix(matrix, 10)));
		assertNull(searchMatrix(matrix,11));
		
	}

	private int[] searchMatrix(int[][] matrix, int whatWeLookFor) {
		int start = 0;
		int end = matrix.length * matrix[0].length -1 ;
		
		while(end >= start){
			int mid = (start + end) >> 1;
			int midValue = element(matrix, mid);
			if (midValue == whatWeLookFor){
				return coords(matrix,mid); 
			}
			if (whatWeLookFor < midValue){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		
		return null;
	}

	private int element(int[][] matrix, int mid) {
		int[] coord = coords(matrix, mid);
		return matrix[coord[0]][coord[1]];
	}

	private int[] coords(int[][] matrix, int mid) {
		int[] coord = new int[2];
		coord[0] = mid / matrix[0].length;
		coord[1] = mid %  matrix[0].length;
		return coord;
	}
	
}
