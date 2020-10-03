package y2020;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/non-divisible-subset/problem
 * <p>
 * Given a set of distinct integers, print the size a maximal subset of S where the sum of any 2  numbers in  is not evenly divisible by . k
 * <p>
 * the sum of any 2 numbers - is not even divisible
 */
public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] counts = new int[k];
        for (int i : s) {
            counts[i % k] += 1; // reminders
        }
        int count = Math.min(counts[0], 1);

        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += Math.max(counts[i], counts[k - i]); // // reminders that are not divisible
            }
        }
        if (k % 2 == 0) {
            count += 1;
        }
        return count;
    }

    public static int nonDivisibleSubsetBrute(int k, List<Integer> s) {
        //System.out.println("Case Not divisible by " + k);

        int maxIndivisible = 1;
        if (k == 1) return 1;
        List<int[]> combs = new LinkedList<>();

        for (int i = 0; i < s.size(); i++) {
            combs.add(new int[]{i});
        }

        for (int level = 2; level < s.size() + 1; level++) {
            //System.out.println("level " + level);
            List<int[]> newCombs = new LinkedList<>();
            for (int[] comb : combs) {
                for (int j = comb[comb.length - 1] + 1; j < s.size(); j++) {
                    if (!hasDivisible(k, s, comb, j)) {
                        int[] newComb = Arrays.copyOf(comb, comb.length + 1);
                        newComb[level - 1] = j;
                       /* System.out.print("not divisible by " + k + " are ");
                        for(int x : newComb)
                        {
                            System.out.print(s.get(x) + " ");
                        }
                        System.out.println();*/
                        newCombs.add(newComb);
                        maxIndivisible = level;
                    }
                }
            }
            combs = newCombs;
        }

        // how do we find all perms
        return maxIndivisible;
    }

    static boolean hasDivisible(int k, List<Integer> list, int[] indexes, int newMember) {
        for (int i = 0; i < indexes.length; i++) {

            int sum = list.get(indexes[i]) + list.get(newMember);
            if (sum % k == 0) {
                //System.out.println("divisible by " + k + "  " + sum + " = " + list.get(indexes.get(i)) + " " + list.get(indexes.get(j)));
                return true;
            }

        }
        return false;
    }

    @Test
    public void t1() {

        //nonDivisibleSubset(4, Arrays.asList(1,2,3,4,5,6,7));
        assertEquals(1, nonDivisibleSubset(1, Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(3, nonDivisibleSubset(4, Arrays.asList(19, 10, 12, 10, 24, 25, 22)));
        assertEquals(3, nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4))); // need com
        assertEquals(11, nonDivisibleSubset(7, Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));

    }
/*
Test case 5
Test case 9
Test case 10
Test case 11
Test case 12
Test case 13
Test case 14
Test case 15
* */

}
