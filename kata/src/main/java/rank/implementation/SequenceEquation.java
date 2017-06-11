package rank.implementation;

import java.util.Scanner;

/**
 * Created on 6/11/2017.
 *
 * You are given a sequence of

 integers,
















 . Each element in the sequence is distinct and satisfies








 . For each

 where





 , find any integer

 such that









 and print the value of

 on a new line.
 Input Format
 The first line contains an integer,

 , denoting the number of elements in the sequence.
 The second line contains

 space-separated integers denoting the respective values of

 */
public class SequenceEquation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = readArray(in, n);

        for(int i = 0; i < n; i++){
            int p1 = colWithValue(i+1, ar);
            System.out.println(colWithValue(p1, ar));
        }
    }

    private static int colWithValue(int val, int[] ar) {
        for(int i =0; i<ar.length; i++){
            if(ar[i]==val){
                return i+1;
            }
        }
        return -1;
    }

    private static int[] readArray(Scanner sc, int n) {
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i]=sc.nextInt();
        }
        return ar;
    }
}
