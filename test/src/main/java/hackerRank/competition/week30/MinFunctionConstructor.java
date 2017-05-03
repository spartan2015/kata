package hackerRank.competition.week30;

import java.util.Scanner;

import org.junit.Test;

public class MinFunctionConstructor {

	@Test
	public void t(){
		System.out.println(generateParenthesis(5));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		String result = generateParenthesis(n);
		
		System.out.println(result);
	}

	private static String generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		StringBuilder tail = new StringBuilder();
		
		for(int i = 0; i < n-1; i++){
			sb.append("min(int, ");
			tail.append(")");
		}
		sb.append("int");
		sb.append(tail);
		
		String result = sb.toString();
		return result;
	}

}
