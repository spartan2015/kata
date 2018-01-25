package ian2008.hash.graph.unidrected;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 1/25/2018.
 */
public class ShortestPathTest {

    @Test
    public void c1(){
        ShortestPath sp = new ShortestPath(new UnidirectedGraph("2 1 0 1"), 0);
        assertTrue(sp.hasPathTo(1));
        assertEquals(Arrays.asList(0, 1), sp.shortedPathTo(1));
    }

    @Test
    public void c2(){
        ShortestPath sp = new ShortestPath(new UnidirectedGraph("3 3 0 1 1 2 0 2"), 0);
        assertTrue(sp.hasPathTo(2));
        assertEquals(Arrays.asList(0, 2), sp.shortedPathTo(2));
    }

    @Test
    public void c3(){
        ShortestPath sp = new ShortestPath(new UnidirectedGraph("3 2 0 1 1 2"), 0);
        assertTrue(sp.hasPathTo(2));
        assertEquals(Arrays.asList(0, 1, 2), sp.shortedPathTo(2));
    }
}
