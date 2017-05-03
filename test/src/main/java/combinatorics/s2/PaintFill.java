package combinatorics.s2;

import java.util.Arrays;

import org.junit.Test;

public class PaintFill {

	@Test
	public void t(){
		int[][] m = {{0,2,0},{0,0,0},{0,2,0},};
		fill(m,0,0, 0,1);
		
		print(m);
	}

	@Test
	public void t1(){
		int[][] m = {{0,0,0},{2,2,0},{0,0,0},};
		fill(m,0,0, 0,1);
		
		print(m);
	}
	
	@Test
	public void t2(){
		int[][] m = {{0,0,0},{2,2,0},{0,2,0},};
		fill(m,0,0, 0,1);
		
		print(m);
	}
	
	private void print(int[][] m) {
		Arrays.stream(m).forEach(ar->{
			System.out.println(Arrays.toString(ar));
		});
	}

	private void fill(int[][] m, int row, int col, int what, int withWhat) {
		if (m[row][col]==what){
			m[row][col] = withWhat;
			
			if (col < m[0].length-1){//right
				fill(m, row, col+1, what,withWhat);
			}
			if (row < m.length-1){//down
				fill(m, row+1, col, what,withWhat);
			}
			if (col > 0){
				fill(m,row,col-1,what,withWhat);
			}
			if (row > 0){
				fill(m,row-1,col,what,withWhat);
			}
		}	
	}
	
}
