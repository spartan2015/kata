package y2020;

import javafx.geometry.Pos;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

/**
 * LargestPermutation
 * /challenges/largest-permutation
 */
public class LargestPermutation {

    static int[] largestPermutation(int k, int[] arr) {

        Pos[] poses = new Pos[arr.length];
        for (int i = 0; i < arr.length; i++) {
            poses[i] = new Pos();
            poses[i].value = arr[i];
            poses[i].pos = i;
        }
        quickSort3Way(poses, 0, arr.length - 1);

        Pos[] newPoses = new Pos[arr.length];

        int countSwap = 0;
        for (int i = 0; i < arr.length; i++) {

            Pos pos = poses[arr.length - 1 - i];
            if (arr[i] == pos.value) {
                continue;
            }

            newPoses[i] = pos;

            int j = pos.pos;
            while (j < i ){
                j  =  newPoses[j].pos;
            }
            if (j < i ){
                System.out.println("out");
            }
            //pos.pos = i;
            swap(arr, i, j);

            countSwap++;
            if (countSwap == k) {
                break;
            }

        }

        return arr;
    }

    ;

    static void quickSort3Way(Pos[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int i = lo + 1;

        int lt = lo;
        int gt = hi;
        int v = arr[lo].value;

        while (i <= gt) {
            if (arr[i].value > v) {
                swap(arr, i, gt--);
            } else if (arr[i].value < v) {
                swap(arr, i++, lt++);
            } else {
                i++;
            }
        }

        quickSort3Way(arr, lo, lt - 1);
        quickSort3Way(arr, gt + 1, hi);
    }

    static void swap(Pos[] arr, int i, int j) {
        Pos tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void t1() {
        int[] arr = {4, 3, 2, 1};
        // quickSort3Way(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void t2() {
        assertArrayEquals(new int[]{3, 1, 2}, largestPermutation(1, new int[]{2, 1, 3}));
        assertArrayEquals(new int[]{5, 2, 3, 4, 1}, largestPermutation(1, new int[]{4, 2, 3, 5, 1}));
        assertArrayEquals(new int[]{4, 2, 3, 1}, largestPermutation(1, new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{4, 3, 2, 1}, largestPermutation(2, new int[]{1, 2, 3, 4}));
    }

    @Test
    public void t3() {
        Scanner scanner = new Scanner(LargestPermutation.class.getResourceAsStream("LargestPermutation.input"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (scanner.hasNextInt()) {
            arr[i++] = scanner.nextInt();
        }

        int[] result = largestPermutation(k, arr);


        int[] arrOutput = new int[n];
        i = 0;
        Scanner output = new Scanner(LargestPermutation.class.getResourceAsStream("LargestPermutation.output"));

        while (output.hasNextInt()) {
            arrOutput[i++] = output.nextInt();
        }

        for (int x = 0; x < k; x++) {
            if (result[x] != arrOutput[x]) {
                System.out.println("index failed " + x);
            }
        }

    }

    static class Pos {
        int value;
        int pos;
    }

}
