package y2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/*
/challenges/picking-numbers/problem
 */
public class PickingNumber {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        Integer[] ints = a.toArray(new Integer[a.size()]);
        Arrays.sort(ints);

        int max = 1;
        for (int s = 0; s < a.size(); s++) {
            for (int i = s + 1; i < a.size(); i++) {
                if (ints[i] - ints[s] > 1) {
                    max = Math.max(max, i - s);
                    break;
                }
                if (i == a.size() - 1){
                    max = Math.max(max, i + 1 - s);
                }
            }
        }
        return max;

    }

    @Test
    public void t() {
        assertEquals(100, pickingNumbers(Arrays.stream(("66 66 66 66 66 66 66 66 66 66 66 66 66" +
                " 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66" +
                " 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66" +
                " 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66")
                .split(" ")).mapToInt(Integer::valueOf).collect(ArrayList::new, List::add, List::addAll)));
    }

}
