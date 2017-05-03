package matrixes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MatrixRotation {

	@Test
	public void testMatrixRotation(){
		String[][] matrixStart = {{"A","B"},{"D","C"}};
		String[][] expectedMatrix = {{"D","A"},{"C","B"}};
		rotateMatrix(matrixStart);
		assertTrue(Arrays.equals(expectedMatrix[0],matrixStart[0]));
		assertTrue(Arrays.equals(expectedMatrix[1],matrixStart[1]));
	}
	
	@Test
	public void testMatrixRotation1(){
		String[][] matrixStart = {{"A","B","C"},{"H","I","D"},{"G","F","E"}};
		String[][] expectedMatrix = {{"G","H","A"},{"F","I","B"},{"E","D","C"}};
		rotateMatrix(matrixStart);
		assertTrue(Arrays.equals(expectedMatrix[0],matrixStart[0]));
		assertTrue(Arrays.equals(expectedMatrix[1],matrixStart[1]));
		assertTrue(Arrays.equals(expectedMatrix[2],matrixStart[2]));
	}

	private void rotateMatrix(String[][] matrix) {
		for(int i = 0; i < (int)Math.sqrt(matrix.length); i++){
			for(int j = 0; j < matrix.length-1; j++){
				rotateElement(matrix, i,j);				
			}
		}
	}

	private double howManyCells(String[][] matrix, int i) {
		double division = (matrix[0].length-i) / 2d;
		return Math.ceil(division);
	}

	private void rotateElement(Object[][] matrix, int i, int j) {
		int noOfElements = matrix.length-i*2;
		
		//save and set top left
		int topLeftRow = j;
		int topLeftColumn = noOfElements-1-i;
		Object tmp = matrix[topLeftRow][topLeftColumn];
		matrix[topLeftRow][topLeftColumn] = matrix[i][j];

		// save bottom left & move top left to bottom - left
		int bottomLeftRow = noOfElements-1-i;
		int bottomLeftColumn = noOfElements-1-j;
		Object tmp2 = matrix[bottomLeftRow][bottomLeftColumn];
		matrix[bottomLeftRow][bottomLeftColumn] = tmp;
		
		// bottom corner set
		int bottomRightRow = noOfElements-1-j;
		int bottomRightColumn = i;
		tmp = matrix[bottomRightRow][bottomRightColumn];
		matrix[bottomRightRow][bottomRightColumn] = tmp2;

		// top coner
		matrix[i][j] = tmp;	
	}
}