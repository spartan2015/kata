package rank.datastructures.arrays;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/crush
 */
public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(howManyTimes(in));
    }

    private static String howManyTimes(Scanner in) {
        return perform(in, out -> {
            int N = in.nextInt();
            int Q = in.nextInt();

            TreeMap<Long, Long> tMap = new TreeMap<>();
            tMap.put(encodeRangeAsLong(0,N), 0l);

            long max = 0;
            for (int i = 0; i < Q; i++) {
                int a = in.nextInt() -1 ;
                int b = in.nextInt() -1;
                int k = in.nextInt();

                // still to TEST various scenarious of this
                tMap.subMap(encodeRangeAsLong(a, 0), true, encodeRangeAsLong(a,b), true);


            }
            out.append(max);
        });
    }

    private static long encodeRangeAsLong(long lowerBound, long upperBound) {
        return (upperBound << 32) | lowerBound;
    }


    interface Algo {
        void solve(StringBuilder out);
    }

    private static String perform(Scanner in, Algo algo) {
        StringBuilder out = new StringBuilder();
        algo.solve(out);
        return out.toString();
    }

    @Test
    public void case1() {
        assertEquals("200", howManyTimes(new Scanner("5 3\n" +
                "1 2 100\n" +
                "2 5 100\n" +
                "3 4 100")));
    }
}
