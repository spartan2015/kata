package rank.implementation;

import java.util.Scanner;

/**
 * Created on 6/11/2017.
 * <p>
 * A jail has
 * <p>
 * prisoners, and each prisoner has a unique id number,
 * <p>
 * , ranging from
 * <p>
 * to
 * <p>
 * . There are
 * <p>
 * sweets that must be distributed to the prisoners.
 * The jailer decides the fairest way to do this is by sitting the prisoners down in a circle (ordered by ascending
 * <p>
 * ), and then, starting with some random
 * <p>
 * , distribute one candy at a time to each sequentially numbered prisoner until all
 * <p>
 * candies are distributed. For example, if the jailer picks prisoner
 * , then his distribution order would be until all
 * <p>
 * sweets are distributed.
 * But wait—there's a catch—the very last sweet is poisoned! Can you find and print the ID number of the last prisoner to receive a sweet so he can be warned?
 */
public class SavethePrisoner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();

            int c = (m % n + s - 1) % n;
            System.out.println(c == 0 ? n : c);
        }
    }
}
