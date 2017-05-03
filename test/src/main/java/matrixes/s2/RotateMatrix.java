package matrixes.s2;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * finding that you need to move n-1 cells - if matrix is 4 then 3 - to make a
 * complete rotation I have no ideea why I assumed I need to move half n/2 which
 * is not true as I found out
 * 
 * RECHECK ALL ASSUMPTIONS
 * 
 * ALSO - SIMPLIFY - BRAIN GEST OVERLOADED BY too many numbers... like a 6x6 matrix - produces confusion
 * 
 * @author vasil
 *
 */

public class RotateMatrix {

	@Test
	public void test() {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		// rotate(matrix);

		// matrixEquals(new int[][] { { 3, 1 }, { 4, 2 } }, matrix);
		int[][] m2 = { { 1, 2, 3 }, { 8, 11, 4 }, { 7, 6, 5 } };
		// rotate(m2);
		// matrixEquals(new int[][] { { 7, 8, 9 }, { 6, 11, 2 }, { 5, 4, 3 } },
		// m2);

		int[][] m4 = { { 1, 2, 3, 4 }, { 12, 1, 2, 5 }, { 11, 4, 3, 6 }, { 10, 9, 8, 7 },

		};
		rotate(m4);
		printMatrix(m4);

		int[][] m6 = { { 1, 2, 3, 4, 5, 6 }, { 20, 1, 2, 3, 4, 7 }, { 19, 12, 1, 2, 5, 8 }, { 18, 11, 4, 3, 6, 9 },
				{ 17, 10, 9, 8, 7, 10 }, { 16, 15, 14, 13, 12, 11 }

		};
		rotate(m6);
		printMatrix(m6);
		rotate(new int[][] { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 1, 2, 3, 4, 5, 6 },
				{ 7, 8, 9, 10, 11, 12 }, { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 } });
	}

	private void matrixEquals(int[][] is, int[][] matrix) {
		printMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			assertTrue(Arrays.equals(is[i], matrix[i]));
		}

	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	private void rotate(int[][] matrix) {
		int circles = matrix.length / 2;
		int currentSize = matrix.length;
		int adjust = 0;
		for (int currentCircle = matrix.length / 2; currentCircle >= 1; currentCircle--) {
			int howManyCells = currentSize - 1;
			for (int cell = 0; cell < howManyCells; cell++) {

				int w = adjust;
				int z = adjust + cell;
				int x = matrix.length - 1 - adjust;
				int y = x - cell;

				int tmp = matrix[w][z];
				matrix[w][z] = matrix[y][w];
				matrix[y][w] = matrix[x][y];
				matrix[x][y] = matrix[z][x];
				matrix[z][x] = tmp;

			}
			currentSize = matrix.length - 2;
			adjust++;
		}
	}

}
