package hackerRank.implementation;

import java.util.Scanner;

public class MigratoryBirds {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] freq = new int[5];
		
		for (int types_i = 0; types_i < n; types_i++) {
			freq[in.nextInt()-1]++;
		}
		
		int maxType = 0;
		int maxCount = 0;
		for(int i = 0; i < freq.length; i++){
			if (freq[i] > maxCount){
				maxType = i;
				maxCount = freq[i];
			}else if (freq[i] == maxCount && i < maxType){
				maxType = i;
			}
		}
		System.out.println(maxType+1);
	}
}
