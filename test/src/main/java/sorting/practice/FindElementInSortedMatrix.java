package sorting.practice;

import org.junit.Test;

public class FindElementInSortedMatrix {

	@Test
	public void test(){
		int[][] m = {
				{1,2},
				{2,3},
				{5,6}
		};
		
		find(1, m, m.length, m[0].length);
		
	}

	private boolean find(int elementToFind, int[][] m, int rows, int cols) {
		int row = 0;
		int col = cols -1;
		while(row < rows && col >=0){
			if (m[row][col] == elementToFind){
				return true;
			}else if(m[row][col] > elementToFind){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
}
