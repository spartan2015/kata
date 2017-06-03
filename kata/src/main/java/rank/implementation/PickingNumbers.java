package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 6/3/2017.
 */
public class PickingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] =in.nextInt();
        }

        int max = getMaxSeqLength(a);
        System.out.println(max);
    }

    private static int getMaxSeqLength(int[] ar) {
        int[] bucket = new int[100];
        for(int i : ar){bucket[i]++;}
        int max = 0;
        for(int i =1; i < bucket.length; i++){
            if (bucket[i] !=0 ){
                if (i+1 > bucket.length-1 || bucket[i+1]==0) {
                    max = Math.max(max,bucket[i]);
                }else{
                    max = Math.max(max,bucket[i]+bucket[i+1]);
                }
            }
        }
        return max;
    }

    @Test
    public void t(){
        assertEquals(Integer.valueOf(2),Integer.valueOf(getMaxSeqLength(new int[]{98, 3, 99, 1, 97, 2})));
    }
}
