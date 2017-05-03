package recursive;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MovingRobotThroughAMatrix {

	static class Point{
		int left;
		int top;
		Point(int left, int top){
			this.left = left;
			this.top = top;
		}
		public String toString(){
			return "("+left + ","+top+")";
		}
	}
	
	@Test
	public void move() {
		Integer possibleMoves = move(0, 0, 2);
		assertEquals(Integer.valueOf(1 + 4), possibleMoves);

		move(0, 0, 3);
	}

	@Test
	public void stepTest() {
		ArrayList path = new ArrayList();
		step(1, 1, path);
		System.out.println(path);
	}

	/**
	 * could define off limits in a coordinate array [][]
	 * 
	 * @param left
	 * @param top
	 * @param n
	 * @return
	 */
	private int move(int left, int top, int n) {
		if (left >= n || top >= n) {
			return 0;
		}
		System.out.println("left " + left + " top " + top);
		return 1 + move(left + 1, top, n) + move(left, top + 1, n);
	}

	
	private boolean step(int left, int top,List<Point> path) {
		if (left <0 || top < 0 || !isFree(left,top)){
			return false;
		}
		boolean isAtOrigin = left == 0 && top ==0;
		if (isAtOrigin || step(left-1, top,path) || step(left,top-1,path)){
			path.add(new Point(left,top));
			return true;
		}
		return false;
	}

	private boolean isFree(int left, int top) {
		return true;
	}

}