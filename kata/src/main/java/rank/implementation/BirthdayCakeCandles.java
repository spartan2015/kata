package hackerrank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Colleen is turning years old! She has candles of various heights on her cake, and candle has
 * height . Because the taller candles tower over the shorter ones, Colleen can only blow out the
 * tallest candles.
 */
public class BirthdayCakeCandles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
        }

        System.out.println(howManyCanSheBlow(height));
    }

    private static int howManyCanSheBlow(int[] height) {
        Arrays.sort(height);
        int count = 1;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] == height[height.length - 1]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

}
