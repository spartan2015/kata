package rank.implementation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 6/15/2017.
 * /challenges/cut-the-sticks
 * <p>
 * You are given  sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.
 * <p>
 * Suppose we have six sticks of the following lengths:
 * <p>
 * 5 4 4 2 2 8
 * <p>
 * <p>
 * Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following:
 * <p>
 * 3 2 2 6
 * <p>
 * <p>
 * The above step is repeated until no sticks are left.
 * <p>
 * Given the length of  sticks, print the number of sticks that are left before each subsequent cut operations.
 * <p>
 * Note: For each cut operation, you have to recalcuate the length of smallest sticks (excluding zero-length sticks).
 * <p>
 * Input Format
 * The first line contains a single integer .
 * The next line contains  integers: a0, a1,...aN-1 separated by space, where  represents the length of the  stick.
 */
public class CutTheSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ar = readArray(in);

        cutSticks(ar);
    }

    private static void cutSticks(int[] ar) {
        int cut = 0;
        int count = 0;
        do {
            int min = Integer.MAX_VALUE;
            count = 0;
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] - cut > 0) {
                    count++;
                    min = Math.min(ar[i] - cut, min);
                }
            }
            cut += min;
            if (count > 0)
            System.out.println(count);
        } while (count > 0);

    }

    private static int[] readArray(Scanner sc) {
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        return ar;
    }

    @Test
    public void t1(){
        cutSticks(new int[]{5,4,4,2,2,8});
    }
}
