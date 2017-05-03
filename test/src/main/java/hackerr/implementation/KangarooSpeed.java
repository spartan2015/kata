package hackerRank.implementation;

import java.util.Scanner;

public class KangarooSpeed {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		
		int x2 = in.nextInt();
		int v2 = in.nextInt();
		
		if ((x1 < x2 && v1 > v2 && checkTime(x2,x1,v2,v1)) || (x1 > x2 && v1 < v2 && checkTime(x1,x2,v1,v2)) || (x1 == x2 && v1 == v2)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	} 
	
	private static boolean checkTime(int x1, int x2, int v1, int v2) {
		int d = (x1-x2) / (v2-v1);
		return x1 + d * v1 == x2 + v2 * d ; // same place same time - of course the faster will surpass the slower - but not in same integer slot - would be a real number there
	}
}
