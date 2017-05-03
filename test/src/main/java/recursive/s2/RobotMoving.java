package recursive.s2;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class RobotMoving {

	@Test
	public void test(){
		move(0,0,3);
	}

	private void move(int row, int col, int matrixSize) {
		System.out.println("row: " + row + ", col: " + col);
		if (col+1 < matrixSize) move(row,col+1, matrixSize);
		if (row+1 < matrixSize) move(row+1,col, matrixSize);
		System.out.println("end");
	}

	@Test
	public void testBacktrackingPath(){
		if(getValidPathWithBackTracking(3, 3)){
			System.out.println(validPath);
		}else{
			System.out.println("none");
		}
	}
	
	List<Point> validPath = new LinkedList<>();
	boolean getValidPathWithBackTracking(int x, int y){
		Point point = new Point(x,y);
		validPath.add(point);
		if (x==0 && y == 0) return true; // found path to end
		boolean success = false;
		
		if (x>=1 && isFree(x,y)){
			success = getValidPathWithBackTracking(x-1, y);
		}
		if (!success && y >=1){
			success = getValidPathWithBackTracking(x,y-1);
		}
		
		if (!success){
			validPath.remove(point);
		}
		return success;	
	}

	private boolean isFree(int x, int y) {
		return true;
	}
	
}
