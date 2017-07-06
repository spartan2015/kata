package rank;

import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.function.IntConsumer;

import org.junit.Test;
import utils.ReadingUtils;

public class MatrixUtils {
	@Test
	public void diagonalsDifference() throws Exception{
		Scanner in = new Scanner(this.getClass().getResourceAsStream("matrix.txt"));
		int[][] matrix = ReadingUtils.readMatrix(in, in.nextInt());
		IntSummaryStatistics firstD = new IntSummaryStatistics();
		IntSummaryStatistics secondD = new IntSummaryStatistics();
		matrixFirstDiagonal(matrix, firstD);
		
		matrixSecondDiagonal(matrix, secondD);
		System.out.println(Math.abs(firstD.getSum() - secondD.getSum()));
	}
	
	public static void matrixFirstDiagonal(int[][] matrix, IntConsumer consumer){
		for(int i =0; i<matrix.length; i++){
			consumer.accept(matrix[i][i]);
		}
	}
	
	public static void matrixSecondDiagonal(int[][] matrix, IntConsumer consumer){
		for(int row = 0, col =matrix.length-1; row<matrix.length; row++, col--){
			consumer.accept(matrix[row][col]);
		}
	}
}
