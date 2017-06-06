package rank.implementation;

import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * We define a magic square to be an nxn matrix of distinct positive integers from 1 to n^2
 * to where the sum of any row, column, or diagonal (of length ) is always equal to the
 * same number (i.e., the magic constant).
 * <p>
 * Consider a 3x3 matrix, of integers in the inclusive range .
 * <p>
 * We can convert any digit a, to any other digit b, in the range at cost |a - b|
 * <p>
 * given the given s square - convert it to a magical square with minimum cost
 * <p>
 * Input - 3x3 matrix
 * <p>
 * Print minimum cost
 */
public class FormingAMagicSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for (int s_i = 0; s_i < 3; s_i++) {
            for (int s_j = 0; s_j < 3; s_j++) {
                s[s_i][s_j] = in.nextInt();
            }
        }
        int minDif = getMinDif(s);

        System.out.println(minDif);
    }

    private static int getMinDif(int[][] s) {
        int minDif = Integer.MAX_VALUE;
        List<int[]> pos = Arrays.asList(
                new int[]{4, 9, 2, 3, 5, 7, 8, 1, 6},
                new int[]{2, 9, 4, 7, 5, 3, 6, 1, 8},
                new int[]{2, 7, 6, 9, 5, 1, 4, 3, 8},
                new int[]{6, 7, 2, 1, 5, 9, 8, 3, 4},
                new int[]{4, 3, 8, 9, 5, 1, 2, 7, 6},
                new int[]{8, 3, 4, 1, 5, 9, 6, 7, 2},
                new int[]{8, 1, 6, 3, 5, 7, 4, 9, 2},
                new int[]{6, 1, 8, 7, 5, 3, 2, 9, 4}
        );

        for (int[] po : pos) {
            int dif = dif(s, po);
            minDif = Math.min(minDif, dif);
        }
        return minDif;
    }

    private static int dif(int[][] s, int[] po) {
        int dif = 0;
        for (int row = 0; row < s.length; row++) {
            for (int col = 0; col < s[row].length; col++) {
                dif += Math.abs(s[row][col] - po[row * 3 + col]);
            }
        }
        return dif;
    }

    @Test
    public void t() {
        assertEquals(Integer.valueOf(1), Integer.valueOf(getMinDif(new int[][]{{4,9,2},{3,5,7},{8,1,5}})));
    }

    @Test
    public void combine() {
        int[] var = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<int[]> prev = new ArrayList();
        for (int i = 0; i < var.length; i++) {
            List newPrev = new ArrayList();
            if (i == 0) {
                newPrev.add(new int[]{var[i]});
            } else {
                for (int[] perm : prev) {
                    for (int k = 0; k <= perm.length; k++) {
                        int[] newPerm = new int[perm.length + 1];
                        newPerm[k] = var[i];
                        int index = 0;
                        for (int l = 0; l < perm.length + 1; l++) {
                            if (l != k) {
                                newPerm[l] = perm[index++];
                            }
                        }
                        newPrev.add(newPerm);
                    }
                }
            }
            prev = newPrev;
        }

        for (int[] ar : prev) {

            int[][] s = new int[3][3];
            int index = 0;
            for (int row = 0; row < s.length; row++) {
                for (int col = 0; col < s[row].length; col++) {
                    s[row][col] = ar[index++];
                }
            }
            int balanceIndex = balance(s);
            if (balanceIndex != -1) {
                System.out.println(balanceIndex);
                System.out.println(Arrays.toString(ar));
            }
        }
    }

    private void permute(int pos, int nextVal, int[] arr) {
    }


    private static int balance(int[][] s) {
        int[] rowsSum = new int[8];
        for (int row = 0; row < s.length; row++) {
            int sum = 0;
            for (int col = 0; col < s[row].length; col++) {
                sum += s[row][col];
            }
            rowsSum[row] = sum;
        }

        for (int col = 0; col < s.length; col++) {
            int sum = 0;
            for (int row = 0; row < s.length; row++) {
                sum += s[row][col];
            }
            rowsSum[3 + col] = sum;
        }

        for (int i = 0; i < s.length; i++) {
            rowsSum[6] += s[i][i];
            rowsSum[7] += s[i][s.length - 1 - i];
        }

        for (int i = 1; i < rowsSum.length; i++) {
            if (rowsSum[i] != rowsSum[0]) {
                return -1;
            }
        }
        return rowsSum[0];
    }
}
