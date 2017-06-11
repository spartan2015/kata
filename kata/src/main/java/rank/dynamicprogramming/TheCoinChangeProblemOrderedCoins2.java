package rank.dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 6/7/2017.
 * <p>
 * 50% performance
 */
public class TheCoinChangeProblemOrderedCoins2 {

    @Test
    public void t1() {
        coins = new int[]{2, 3, 5, 6};
        assertEquals(Integer.valueOf(5), Integer.valueOf(change(10)));
    }

    @Test
    public void t2() {
        coins = new int[]{1, 2};
        assertEquals(Integer.valueOf(2), Integer.valueOf(change(3)));
    }

    static int[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        coins = readArray(sc, m);
        //Arrays.sort(coins);
        System.out.println(change(n));
    }


    private static int change(int n) {
        Arrays.sort(coins);
        for (int i = 0; i < coins.length / 2; i++) {
            swap(coins, i, coins.length - 1 - i);
        }
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = i, t=n; t>=0 && j < coins.length; j++) {
                while (t - coins[j] >= 0) {
                    t -= coins[j];
                    System.out.print(coins[j] + " ");
                }
                if (t == 0) {
                    count++;
                }
            }
            System.out.println("");

        }
        return count;
    }

    private static void swap(int[] coins, int i, int j) {
        int tmp = coins[i];
        coins[i] = coins[j];
        coins[j] = tmp;
    }

    private static int change2(int n) {
        return findSolution(n, n, 0, new ArrayList());
    }

    private static int findSolution(int start, int n, int index, List soFar) {
        if (n == 0) {
            //System.out.println(start + " " + soFar);
            return 1;
        }

        int sum = 0;
        for (int i = index; i < coins.length; i++) {
            int coin = coins[i];
            if (n - coin >= 0) {
                //List newVariant = new ArrayList(soFar);
                //newVariant.add(coin);
                sum += findSolution(n, n - coin, i, soFar); //newVariant
            }
        }
        return sum;
    }

    private static int[] readArray(Scanner sc, int n) {
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        return ar;
    }

}
