package matrixes.s2;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class MatrixZero {

	@Test
	public void test() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };

		zero(matrix);

		matrixEqual(new int[][] { { 1, 0, 3 }, { 0, 0, 0 }, { 7, 0, 9 } }, matrix);
	}

	private void matrixEqual(int[][] expected, int[][] matrix) {
		for(int i=0; i< expected.length; i++){
			assertTrue(Arrays.equals(expected[i], matrix[i]));
		}
	}

	private void zero(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					rows[row] = true;
					columns[col] = true;
				}
			}
		}
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (rows[row] || columns[col]) {
					matrix[row][col]=0;
				}
			}
		}
	}
}
