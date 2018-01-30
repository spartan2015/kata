package ian2018.graph.directed;

import ian2018.graph.unidrected.UnidirectedGraph;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 1/25/2018.
 */
public class BreadthFirstDirectedPathTest {

    @Test
    public void c1(){
        BreadthFirstDirectedPath sp = new BreadthFirstDirectedPath(new Diagraph("2 1 0 1"), 0);
        assertTrue(sp.hasPathTo(1));
        assertEquals(Arrays.asList(0, 1), sp.shortestPathTo(1));
    }

    @Test
    public void c2(){
        BreadthFirstDirectedPath sp = new BreadthFirstDirectedPath(new Diagraph("3 3 0 1 1 2 0 2"), 0);
        assertTrue(sp.hasPathTo(2));
        assertEquals(Arrays.asList(0, 2), sp.shortestPathTo(2));
    }

    @Test
    public void c3(){
        BreadthFirstDirectedPath sp = new BreadthFirstDirectedPath(new Diagraph("3 2 0 1 1 2"), 0);
        assertTrue(sp.hasPathTo(2));
        assertEquals(Arrays.asList(0, 1, 2), sp.shortestPathTo(2));
    }
}
