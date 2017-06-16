package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 6/15/2017.
 *
 *

 Given a set, , of  distinct integers, print the size of a maximal subset, , of  where the sum of any  numbers in  is not evenly divisible by .



 Input Format



 The first line contains  space-separated integers,  and , respectively.
 The second line contains  space-separated integers (we'll refer to the  value as ) describing the unique values of the set.

 */
public class NonDivisibleSubset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = readArray(in, n);

        int count = getCount(n, k, ar);

        System.out.println(count);
    }

    private static int getCount(int n, int k, int[] ar) {
        int[] parts = new int[k];
        for(int i = 0; i < n; i++){
            parts[ ar[i] % k]++;
        }

        int a = 0;
        int b = 0;
        boolean isEven = k % 2 == 0;
        int half = k/2;
        for(int i = 1; i <= parts.length/2 ; i++){
            if (isEven && i == half){
                continue;
            }
            a+=parts[i];
            b+=parts[parts.length-i];
        }


        int result = Math.max(a, b) + (parts[0] != 0 ? 1 : 0);
        if (isEven && parts[half]>0){
            result++;
        }
        return result;
    }

    private static int[] readArray(Scanner sc, int n) {

        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i]=sc.nextInt();
        }
        return ar;
    }

    @Test
    public void t2(){
        assertEquals(Integer.valueOf(2),Integer.valueOf(getCount(4,2,new int[]{1,2,3,4}))); //parts[0] =2 parts[1] = 2 - 1 + 1 = 2
    }

    @Test
    public void t(){
        assertEquals(Integer.valueOf(3),Integer.valueOf(getCount(4,3,new int[]{1,7,2,4})));
    }
}
