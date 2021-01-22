package y2020;

import java.util.Arrays;

/**
 * PermutingTwoArrays
 * /challenges/two-arrays/problem
 */
public class PermutingTwoArrays {
    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[B.length - 1 - i] < k) {
                return "NO";
            }
        }
        return "YES";

    }

}
