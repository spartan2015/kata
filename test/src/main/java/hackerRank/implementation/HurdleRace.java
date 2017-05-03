package hackerRank.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class HurdleRace {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] height = new int[n];
	        for(int height_i=0; height_i < n; height_i++){
	            height[height_i] = in.nextInt();
	        }

	        int drinks =0;
	        Arrays.sort(height);
	        for(int i = 0; i<n; i++){
	        	if (height[i] <=k){
	        		continue;
	        	}else{
	        		while(k < height[i]){
	        			drinks++;
	        			k++;
	        		}
	        	}
	        }
	        System.out.println(drinks);
	 }
}
