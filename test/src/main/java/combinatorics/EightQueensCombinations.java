package combinatorics;

import java.util.Arrays;

import org.junit.Test;

public class EightQueensCombinations {

	@Test
	public void test() {
		arrangeOnBoard(8);
	}

	private void arrangeOnBoard(int queensLeft) {
		if (queensLeft > 8)
			return;
		int[] columnsForRow = new int[8];
		arrangeOnBoard(queensLeft, columnsForRow, 0);
	}

	static int count = 0;
	
	private void arrangeOnBoard(int queensLeft, int[] columnsForRow, int currentRowIndex) {
		if (queensLeft == 0) {
			count++;
			printBoard(columnsForRow);
			return;
		} 
		for(int currentColumn =0; currentColumn<8;currentColumn++){
	
			boolean valid =true;
			for(int prevRowIndex = currentRowIndex-1; prevRowIndex >=0; prevRowIndex--){
				if (columnsForRow[prevRowIndex]==currentColumn 
						|| columnsForRow[prevRowIndex]==currentColumn-(currentRowIndex-prevRowIndex)
						|| columnsForRow[prevRowIndex]==currentColumn+(currentRowIndex-prevRowIndex)
						){
					valid = false;
					break;
				}
			}
			if (valid){
				columnsForRow[currentRowIndex]=currentColumn; 
				arrangeOnBoard(queensLeft - 1, columnsForRow, currentRowIndex + 1);
			}
			
		}
	}

	private void printBoard(int[] columnsForRow) {
		System.out.println("current count: " + count);
		System.out.println(Arrays.toString(columnsForRow));
		for(int i =0; i< 8; i++){
			for(int j =0; j< 8; j++){
				if (columnsForRow[i]==j){
					System.out.print("Q,");
				}else{
					System.out.print("_,");
				}
			}
			System.out.println();
		}
	}
}