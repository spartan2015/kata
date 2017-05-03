package hackerRank.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class MatchingSocks {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] pairing = new int[100];
        int pairs = 0;
        for(int i=0; i < n; i++){
            int c = in.nextInt();
            if (pairing[c-1]+1 == 2){
            	pairs++;
            	pairing[c-1]=0;
            }else{
            	pairing[c-1]++;
            }
        }
        System.out.println(pairs);
    }
}
