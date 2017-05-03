package matrixes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class MatrixElementIsZero {

	@Test
	public void matrixZero(){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,0}};
		int[][] expected = {{1,2,0},{4,5,0},{0,0,0}};
		findZero(matrix);
		for(int i =0; i< matrix.length; i++){
			assertTrue(Arrays.equals(matrix[i], expected[i]));
		}
	}

	private void findZero(int[][] matrix) {
		Set<int[]> rowCols = new HashSet<>();
		for(int row =0; row< matrix.length; row++){
			for(int column = 0; column < matrix[row].length; column++){
				if (matrix[row][column] == 0){
					rowCols.add(new int[]{row, column});
				}
			}
		}
		for(int[] set : rowCols){
			int row = set[0];
			int col = set[1];
			for(int i = 0; i < matrix[row].length; i++){
				matrix[row][i] = 0;
			}
			for(int i = 0; i < matrix.length; i++){
				matrix[i][col] = 0;
			}
		}
	}
	
}
