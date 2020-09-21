package y2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/beautiful-triplets/problem
 * <p>
 * i < j < k
 * j-1 = k-j = d
 */
public class BeautifulTriplets {

    /*
     * given int[] array - find all tripplets in it
     * */
    static int beautifulTriplets(int d, int[] arr) {
        int triplets = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[j] - arr[i]) == d*count) {
                    count++;
                }
                if (count == 3) {
                    triplets++;
                    break;
                }
            }
        }
        return triplets;
    }

    @Test
    public void t1() {
        assertEquals(3, beautifulTriplets(1, new int[]{2, 2, 3, 4, 5}));

        assertEquals(3, beautifulTriplets(3, new int[]{1,2,4,5,7,8,10}));
    }

}
