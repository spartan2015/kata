package crossover;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class Test1 {

	private static final char lt = '<';
	private static final char gt = '>';
	
	@Test
	public void testIsBalanced(){
		assertTrue(isBalanced("<<>>"));
		assertTrue(isBalanced("<>"));
		assertTrue(isBalanced("<><>"));
		
		
		assertFalse(isBalanced(">>"));
		assertFalse(isBalanced("<<>"));
		assertFalse(isBalanced("<<>"));
		assertFalse(isBalanced("><><"));
		
	}
	
	private boolean isBalanced(String string) {
		
		return false;
	}

	public int[] balancedOrNot(String[] expresions, int[] maxReplacements){
		
		int[] result = new int[expresions.length];
		for(int i = 0; i < expresions.length; i++){
			result[i] = balance(expresions[i], maxReplacements[i]);
		}
		
		 return result;
	}
	
	/**
	 * Rules:
		replace("<","<>"); // RULE
		int maxReplacements = 3; // can you balanced the string in that interval
		
	 * @param string
	 * @param i
	 * @return
	 */
	private int balance(String string, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();

	}

}
