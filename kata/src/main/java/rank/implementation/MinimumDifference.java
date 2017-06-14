package rank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * /challenges/minimum-absolute-difference-in-an-array
 *
 * Created on 6/14/2017.
 *
 * Consider an array of integers, . We define the absolute difference between two elements,  and  (where ), to be the absolute value of .

 Given an array of  integers, find and print the minimum absolute difference between any two elements in the array.

 */
public class MinimumDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ar = readArray(in);

        // complexity n Lg n + n = n (1 + logN)
        int m = Integer.MAX_VALUE;
        Arrays.sort(ar);
        for(int i = 1; i< ar.length; i++){
            m = Math.min(m, Math.abs(ar[i-1]-ar[i]));
        }
        System.out.println(m);
    }

    /**
     * n^2 complexity - with sort you can do better
     *
     * @param ar
     */
    private static void findMinDiff(int[] ar) {
        int m = Integer.MAX_VALUE;
        for(int i = 0; i< ar.length; i++){
            for(int j = i+1; j< ar.length; j++){
                m = Math.min(m, Math.abs(ar[i]-ar[j]));
            }
        }
        System.out.println(m);
    }

    private static int[] readArray(Scanner sc) {
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i]=sc.nextInt();
        }
        return ar;
    }
}
