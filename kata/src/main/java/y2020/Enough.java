package y2020;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Enough {

    List<Integer> deleteNth(int[] data, int n) {
        Map<Integer, Integer> freq = new HashMap<>();

        return Arrays.stream(data)
                .filter(i ->
                        freq.getOrDefault(i, 0) < n
                ).map(i -> {
                    freq.put(i, freq.getOrDefault(i, 0) + 1);
                    return i;
                })
                .mapToObj(Integer::new).collect(Collectors.toList());

    }

    @Test
    public void test() {
        assertEquals(Arrays.asList(1, 2, 3), deleteNth(new int[]{1, 2, 3, 1, 2, 1, 2, 3}, 1));

    }

    @Test
    public void test1() {
        assertEquals(Arrays.asList(1, 2, 3, 1, 2, 3), deleteNth(new int[]{1, 2, 3, 1, 2, 1, 2, 3}, 2));

    }

}
