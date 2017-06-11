package rank.implementation;

import java.util.Scanner;

/**
 * Created on 6/11/2017.
 John Watson performs an operation called a right circular rotation on an array of integers,
 . After performing one right circular rotation operation, the array is transformed from
 to
 .
 Watson performs this operation
 times. To test Sherlock's ability to identify the current element at a particular position in the rotated array, Watson asks
 queries, where each query consists of a single integer,
 , for which you must print the element at index
 in the rotated array (i.e., the value of
 ).
 Input Format
 The first line contains
 space-separated integers,
 ,
 , and
 , respectively.
 The second line contains
 space-separated integers, where each integer
 describes array element
 (where
 ).
 Each of the

 subsequent lines contains a single integer denoting

 .
 */
public class CircularArrayRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            int x = m - (k % n);
            int result  = x < 0 ? n+x : x;
            System.out.println(a[result]);
        }
    }
}
