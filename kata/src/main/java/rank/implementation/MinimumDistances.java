package rank.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 6/13/2017.
 *
 * Consider an array of  integers, . The distance between two indices,  and , is denoted by .

 Given , find the minimum  such that  and . In other words, find the minimum distance between any pair of equal elements in the array. If no such value exists, print .

 */
public class MinimumDistances {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (valueToIndex.containsKey(val)) {
                min = Math.min(min, i - valueToIndex.get(val));
            }
            valueToIndex.put(val, i);
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);

    }
}
