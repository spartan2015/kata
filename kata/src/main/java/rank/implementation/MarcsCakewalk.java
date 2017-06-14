package rank.implementation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 6/14/2017.
 * /challenges/marcs-cakewalk
 *
 * Marc loves cupcakes, but he also likes to stay fit. He eats  cupcakes in one sitting, and each cupcake  has a calorie count, . After eating a cupcake with  calories, he must walk at least  (where  is the number cupcakes he has already eaten) miles to maintain his weight.

 Given the individual calorie counts for each of the  cupcakes, find and print a long integer denoting the minimum number of miles Marc must walk to maintain his weight. Note that he can eat the cupcakes in any order.
 */
public class MarcsCakewalk {
    @Test
    public void t1(){
        assertEquals(Long.valueOf(59715404338867l),Long.valueOf(getMiles(new int[]{819,701,578,403,50,400,983,665,510,523,696,532,51,449,333,234,958,460,277,347,950,53,123,227,646,190,938,61,409,110,61,178,659,989,625,237,944,550,954,439})));
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ar = readArray(in);

        long miles = getMiles(ar);
        System.out.println(miles);
    }

    private static long getMiles(int[] ar) {
        Arrays.sort(ar);
        long miles = 0;
        for(int i = 0; i < ar.length; i++){
            miles += ar[ar.length-1-i] * Math.pow(2,i);
        }
        return miles;
    }

    private static int[] readArray(Scanner sc) {
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        return ar;
    }


}
