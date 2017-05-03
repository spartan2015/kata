package hackerRank.searching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IceCream {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tripsNo = in.nextInt();
		
		for(int i =0; i< tripsNo; i++){
			int m = in.nextInt(); // between 2 and 10_000 inclusive
			int n = in.nextInt(); // between 2 and 10_000 inclusive
			
			findRightMatch(in, m, n);
		}
	}

	private static void findRightMatch(Scanner in, int totalMoney, int n) {
		Set<Short>[] map = new Set[10_000+1]; // there is an ice cream cost is index - > map to index (u+1) - 1 <= cost <= 10_000
		short[] costs = new short[n];
		
		for(short u = 0; u < n; u++){
			costs[u]=in.nextShort();
			if (map[costs[u]]==null){
				map[costs[u]] = new HashSet<>();
			}
			map[costs[u]].add((short)(u+1)); // maping a cost to its index; 
		}
		for(int u = 0; u < n; u++){ // choose 2 DIFFERENT FLAVOURS - flvours can have same COST
			int otherPart = totalMoney-costs[u]; // what is the index of this part
			if (otherPart>=0 && otherPart < 10_001 && map[otherPart]!=null && map[otherPart].size()>0){
				for(short id : map[otherPart]){
					if (id != u+1){
						System.out.println(u+1 + " " + id);
						return;	
					}
				}
			}
		}
	}
	
}
