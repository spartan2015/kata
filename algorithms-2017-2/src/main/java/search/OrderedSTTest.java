package search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 */
public class OrderedSTTest {
    @Test
    public void selectRankTest(){
        OrderedST<Integer, Integer> os = null;

        for(Integer key : os.keys()){
            assertEquals(key, os.select(os.rank(key)));
        }
    }
}
