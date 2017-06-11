package rank.implementation;

import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Created on 6/11/2017.
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        IntUnaryOperator spring = h -> h * 2;
        IntUnaryOperator summer = h -> h + 1;

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int height = 1;
            int totalCycles = in.nextInt();
            for (int cycles = 0; cycles < totalCycles; cycles++) {
                if (cycles % 2 == 0) {
                    height = height * 2;
                }
                else {
                    height += 1;
                }
            }
            System.out.println(height);
        }
    }
}
