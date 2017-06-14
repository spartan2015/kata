package search.test;

import org.junit.Test;
import search.BinarySearchST;

/**
 * Created on 6/12/2017.
 */
public class BinarySearchSTTest {

    @Test
    public void t1() {
        BinarySearchST<Integer, Integer> bs = new BinarySearchST<>(10);
        bs.put(1, 1);
        bs.put(3, 3);
        bs.put(5, 5);

        bs.put(2, 2);
        bs.put(4, 4);
    }

}
