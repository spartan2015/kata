package ian2008.hash.graph.unidrected;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathFindTest {
    @Test
    public void case1(){
        UnidirectedGraph g = new UnidirectedGraph("2 1 0 1");
        PathFind pathFind = new PathFind(g, 0);
        assertTrue(pathFind.hasPathTo(1));
    }

    @Test
    public void case11(){
        UnidirectedGraph g = new UnidirectedGraph("2 1 0 1");
        PathFind pathFind = new PathFind(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
    }

    @Test
    public void case2(){
        UnidirectedGraph g = new UnidirectedGraph("2 1 0 0");
        PathFind pathFind = new PathFind(g, 0);
        assertFalse(pathFind.hasPathTo(1));
    }

    @Test
    public void case3(){
        UnidirectedGraph g = new UnidirectedGraph("2 1 1 1");
        PathFind pathFind = new PathFind(g, 0);
        assertFalse(pathFind.hasPathTo(1));
    }

    @Test
    public void case4(){
        UnidirectedGraph g = new UnidirectedGraph("3 2 0 1 1 2");
        PathFind pathFind = new PathFind(g, 0);
        assertTrue(pathFind.hasPathTo(0));
        assertTrue(pathFind.hasPathTo(1));
        assertTrue(pathFind.hasPathTo(2));
    }

    @Test
    public void case41(){
        UnidirectedGraph g = new UnidirectedGraph("3 2 0 1 1 2");
        PathFind pathFind = new PathFind(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
        assertEquals(Arrays.asList(0,1,2), pathFind.pathTo(2));
    }

    @Test
    public void case5(){
        UnidirectedGraph g = new UnidirectedGraph("4 3 0 1 0 2 1 3");
        PathFind pathFind = new PathFind(g, 0);
        assertTrue(pathFind.hasPathTo(1));
        assertTrue(pathFind.hasPathTo(2));
        assertTrue(pathFind.hasPathTo(3));
    }

    @Test
    public void case51() {
        UnidirectedGraph g = new UnidirectedGraph("4 3 0 1 0 2 1 3");
        PathFind pathFind = new PathFind(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
        assertEquals(Arrays.asList(0,2), pathFind.pathTo(2));
        assertEquals(Arrays.asList(0,1,3), pathFind.pathTo(3));
    }

    @Test
    public void case6(){
        UnidirectedGraph g = new UnidirectedGraph("4 3 0 1 0 2 2 3");
        PathFind pathFind = new PathFind(g, 0);
        assertTrue(pathFind.hasPathTo(1));
        assertTrue(pathFind.hasPathTo(2));
        assertTrue(pathFind.hasPathTo(3));
    }

    @Test
    public void case61() {
        UnidirectedGraph g = new UnidirectedGraph("4 3 0 1 0 2 2 3");
        PathFind pathFind = new PathFind(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
        assertEquals(Arrays.asList(0,2), pathFind.pathTo(2));
        assertEquals(Arrays.asList(0,2,3), pathFind.pathTo(3));
    }
}
