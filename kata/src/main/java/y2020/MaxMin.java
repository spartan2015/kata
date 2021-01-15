package y2020;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * MaxMin
 * /challenges/angry-children/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=30-day-campaign
 */
public class MaxMin {
    static int maxMin(int k, int[] arr) {

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            min = Math.min(min, arr[i + k - 1] - arr[i]);
        }
        return min;
    }

    @Test
    public void t1() {
        assertEquals(1, maxMin(2, new int[]{1, 4, 7, 2}));
        assertEquals(10, maxMin(2, new int[]{10, 100, 300, 200, 1000, 20, 30}));
        assertEquals(3, maxMin(4, new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200}));
        assertEquals(0, maxMin(2, new int[]{1, 2, 1, 2, 1}));

        assertEquals(1335, maxMin(5,
                new int[]{4504, 1520, 5857, 4094, 4157, 3902, 822, 6643, 2422, 7288, 8245, 9948, 2822, 1784, 7802, 3142, 9739, 5629, 5413, 7232,

                }));

        assertEquals(2, maxMin(3, new int[]{100, 200, 300, 350, 400, 401, 402}));
    }
}
