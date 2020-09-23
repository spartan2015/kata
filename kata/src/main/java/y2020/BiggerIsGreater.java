package y2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * /challenges/bigger-is-greater/problem?h_r=next-challenge&h_v=zen
 * <p>
 * smalles string higher a -> a; ab-> ba; abc -> acb;
 * <p>
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.
 * <p>
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 * <p>
 * - It must be greater than the original word
 * - It must be the smallest word that meets the first condition
 * <p>
 * - all permutation - then sort them - find greater - rank
 * <p>
 * For example, given the word "abcd" , the next largest word is "abdc"
 * <p>
 * dkhc
 */
public class BiggerIsGreater {
    static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        boolean overallFound = false;
        for (int i = chars.length - 2; i >= 0; i--) {
            boolean found = false;
            int smallestGreatest = i + 1;
            for (int y = i + 1; y < chars.length; y++) {
                if (chars[y] > chars[i]
                        ) {
                    found = true;
                    overallFound = true;
                    if (chars[y] < chars[smallestGreatest]) {
                        smallestGreatest = y;
                    }
                }
            }
            if (found) {

                swap(chars, smallestGreatest, i);

                sort(chars, i + 1, chars.length - 1);

                break;
            }
        }
        return !overallFound ? "no answer" : new String(chars);
    }

    static void sort(char[] arr, int start, int end) {
        LinkedList<int[]> queue = new LinkedList<>();

        pivot(queue, arr, start, end);

        int[] work;
        while ((work = queue.pollFirst()) != null) {
            pivot(queue, arr, work[0], work[1]);
        }
    }

    static void pivot(LinkedList queue, char[] arr, int lo, int high) {
        if (lo < high) {
            char pivot = arr[high];
            int lowerThanPivot = lo - 1;

            for (int j = lo; j < high; j++) {
                if (arr[j] < pivot) {
                    lowerThanPivot++;
                    swap(arr, lowerThanPivot, j);
                }
            }

            int pi = lowerThanPivot + 1;
            swap(arr, pi, high);

            queue.add(new int[]{lo, pi - 1});
            queue.add(new int[]{pi + 1, high});
        }
    }

    static void swap(char[] arr, int i, int j){
        if (i == j) return;
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void s1() {
        char[] arr = "cba".toCharArray();
        sort(arr, 0, 2);
        assertArrayEquals("abc".toCharArray(), arr);
    }


    @Test
    public void t1() {
        assertEquals("ba", biggerIsGreater("ab"));
        assertEquals("no answer", biggerIsGreater("bb"));
        //assertEquals("hegf", biggerIsGreater("hefg"));
        assertEquals("dhkc", biggerIsGreater("dhck"));
        assertEquals("hcdk", biggerIsGreater("dkhc"));
    }


}
