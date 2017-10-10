package rank.datastructures.arrays;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/array-left-rotation
 *
 */
public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(perform(in));
    }

    private static String perform(Scanner in) {
        StringBuilder out = new StringBuilder();
        rotateArray(in, out);
        return out.toString();
    }

    private static void rotateArray(Scanner in, StringBuilder out) {
        int N = in.nextInt();
        int d = in.nextInt();
        int[] ar = readArray(in,N);

        for(int i = 0; i < N; i++){
            out.append(ar[(i + d) % N]).append(" ");
        }

    }

    private static int[] readArray(Scanner in, int n) {
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i]=in.nextInt();
        }
        return ar;
    }

    @Test
    public void case1(){
        assertEquals("1 2 3 4 5", perform(new Scanner("5 2 4 5 1 2 3")).trim());
    }
}
