package recursive;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class QueensOnChessBoardAllWaysPossible {

	static int noOfWays = 0;
	
	@Test
	public void test() {
		findQueenSolutions();
		System.out.println("found" + noOfWays);
	}

	@Test
	public void testCrack() {
		int[] columnForRow = new int[8];
		placeQueen(0, columnForRow);
	}
	
	private void placeQueen(int row, int[] columnForRow) {
		if(row==8){
			System.out.println(Arrays.toString(columnForRow));
			return;
		}
		for(int i=0; i< 8;i++){
			columnForRow[row]=i;
			if (check(row,columnForRow)){
				placeQueen(row+1, columnForRow);
			}
		}
	}

	private boolean check(int row, int[] columnForRow) {
		for(int i =0; i< row; i++){
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if (queenOnSameColumn(diff) || queenOnDiagonal(row, i, diff)){
				return false;
			}
		}
		return true;
	}

	private boolean queenOnDiagonal(int row, int i, int diff) {
		return diff == row-i;
	}

	private boolean queenOnSameColumn(int diff) {
		return diff ==0;
	}

	public void findQueenSolutions(){
		for (int x = 0; x < 8; x++) {
			startFrom(8, new int[8][8], x, 0, new LinkedList<int[]>());
		}
	}
	
	private void startFrom(int numberOfQueens, int[][] chessboard, int takeX, int takeY, LinkedList<int[]> solution) {
		solution.add(new int[] { takeY, takeX });
		takeSlot(chessboard, numberOfQueens, takeX, takeY);
		numberOfQueens--;
		if (numberOfQueens == 1) {
			noOfWays++;
			printSolution(solution);
			printChessboard(chessboard);
			return;
		}
		if (chessboard[takeY][takeX] == 1) {
			return;
		}
		int[] firstFree = { takeY + 1, 0 };
		while (firstFree != null && firstFree[0] < 8) {
			firstFree = findFirstFree(chessboard, firstFree[0], firstFree[1]);
			if (firstFree != null) {
				startFrom(numberOfQueens, cloneChessBoard(chessboard), firstFree[1], firstFree[0],
						(LinkedList<int[]>) solution.clone());
				firstFree[1]++;
				if (firstFree[1] > 7) {
					firstFree[1] = 0;
					firstFree[0]++;
				}
			}
		}
	}

	private void printSolution(LinkedList<int[]> solution) {
		System.out.println("solution: ");
		solution.stream().forEach(ar -> {
			System.out.println(Arrays.toString(ar));
		});
	}

	private int[][] cloneChessBoard(int[][] chessboard) {
		int[][] newChessboard = new int[8][8];
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				newChessboard[y][x] = chessboard[y][x];
			}
		}
		return newChessboard;
	}

	private void takeSlot(int[][] chessboard, int queenNo, int takeX, int takeY) {
		for (int i = 0; i < 8; i++) {
			chessboard[i][takeX] = queenNo;
		}
		for (int i = 0; i < 8; i++) {
			chessboard[takeY][i] = queenNo;
		}

		int xStart = takeX > takeY ? takeX - takeY : 0;
		int yStart = takeY > takeX ? takeY - takeX : 0;

		if (xStart == yStart) {
			for (int i = 0; i < 8; i++) {
				chessboard[i][i] = queenNo;
			}
		}
		
		// toward top left
		for(int x = takeX, y = takeY; x >= 0 & y >= 0; x--,y--){
			chessboard[y][x]=queenNo;
		}
			
		// move bottom right
		for(int x = takeX, y = takeY; x <8 & y < 8; x++,y++){
			chessboard[y][x]=queenNo;
		}
			
		// move top right
		for(int x = takeX, y = takeY; x <8 & y >= 0 ; x++,y--){
			chessboard[y][x]=queenNo;
		}
		
		// move bottom left
		for(int x = takeX, y = takeY; x >= 0 & y < 8; x--,y++){
			chessboard[y][x]=queenNo;
		}
		
		// printChessboard(chessboard);
		chessboard[takeY][takeX] = queenNo;
	}

	private void printChessboard(int[][] chessboard) {
		for (int[] ar : chessboard) {
			System.out.println(Arrays.toString(ar));
		}
		System.out.println("\n\n\n");
	}

	private int[] findFirstFree(int[][] chessboard, int passy, int passx) {
		for (int y = 0; y < 8; y++) {
			if (y < passy) {
				continue;
			}
			for (int x = 0; x < 8; x++) {
				if (y == passy && x < passx) {
					continue;
				}
				if (chessboard[y][x] == 0) {
					return new int[] { y, x };
				}
			}
		}
		return null;
	}
}