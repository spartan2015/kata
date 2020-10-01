package y2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/sherlock-and-array/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class SherlockAndArray {

    static String balancedSums(List<Integer> arr) {
        if (arr.size() == 1) {
            return "YES";
        }
        int sum = arr.stream().mapToInt(i -> i).sum();

        int sumBefore = 0;

        for (int i = 0; i < arr.size(); i++) {
            int sumAfter = sum - sumBefore - arr.get(i);

            if (sumBefore == sumAfter) {
                return "YES";
            }
            sumBefore += arr.get(i);


        }
        return "NO";
    }

    @Test
    public void t1() {
        //assertEquals("YES", balancedSums(Arrays.asList(1)));
        //assertEquals("YES", balancedSums(Arrays.asList(5, 6, 8, 11)));
        assertEquals("YES", balancedSums(Arrays.asList(1, 1, 4, 1, 1)));
        assertEquals("YES", balancedSums(Arrays.asList(2, 0, 0, 0)));
        assertEquals("YES", balancedSums(Arrays.asList(0, 0, 2, 0)));


    }

}
