package y2020;

import java.util.Arrays;

/**
 * Mark
 * /challenges/mark-and-toys/problem
 */
public class Mark {
    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int max = 0;
        int sum = 0;
        int i = 0;
        while( sum + prices[i] <=k){
            sum+=prices[i];
            max++;
            i++;
        }
        return max;
    }
}
