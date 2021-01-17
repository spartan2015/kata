package y2020;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * MaximumPerimeter
 * /challenges/maximum-perimeter-triangle/problem
 */
public class MaximumPerimeter {

    static int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        for (int i = sticks.length - 1 - 2; i >= 0; i--) {
            if (!isDenegenerate(sticks, i)) {
                return Arrays.copyOfRange(sticks, i, i + 3);

            }
        }
        return new int[]{-1};
    }


    static boolean isDenegenerate(int[] arr, int i) {
        return arr[i] + arr[i + 1] <= arr[i + 2];

    }

    @Test
    public void t() {
        assertArrayEquals(new int[]{2, 3, 3}, maximumPerimeterTriangle(new int[]{3, 9, 2, 15, 3}));
    }
}
