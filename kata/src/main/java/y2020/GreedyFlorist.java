package y2020;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * GreedyFlorist
 * /challenges/greedy-florist/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=30-day-campaign
 */
public class GreedyFlorist {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int noOfPeople, int[] cost) {
        if (cost.length < noOfPeople) {
            return Arrays.stream(cost)
                    .limit(noOfPeople)
                    .sum();
        } else { // less people than flowers - always sort - so priority queue -
            Arrays.sort(cost);
            int result = 0;
            int bought = 0;
            int level = 0;
            for (int i = cost.length - 1; i >= 0; i--) {
                level = bought / noOfPeople;
                result += (level + 1) * cost[i];
                bought++;
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine()
                .split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine()
                .split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    public static class Test1 {
        @Test
        public void t1() {
            assertEquals(29, getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));
            assertEquals(15, getMinimumCost(2, new int[]{2,5,6}));
            assertEquals(13, getMinimumCost(3, new int[]{2,5,6}));
            assertEquals(11, getMinimumCost(3, new int[]{1,2,3,4}));
        }
    }

}
