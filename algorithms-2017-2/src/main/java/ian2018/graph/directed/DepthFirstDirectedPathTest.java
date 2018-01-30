package ian2018.graph.directed;


import ian2018.graph.unidrected.UnidirectedGraph;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DepthFirstDirectedPathTest {
    @Test
    public void case1(){
        Diagraph g = new Diagraph("2 1 0 1");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertTrue(pathFind.hasPathTo(1));
    }

    @Test
    public void case11(){
        Diagraph g = new Diagraph("2 1 0 1");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
    }

    @Test
    public void case2(){
        Diagraph g = new Diagraph("2 1 0 0");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertFalse(pathFind.hasPathTo(1));
    }

    @Test
    public void case3(){
        Diagraph g = new Diagraph("2 1 1 1");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertFalse(pathFind.hasPathTo(1));
    }

    @Test
    public void case4(){
        Diagraph g = new Diagraph("3 2 0 1 1 2");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertTrue(pathFind.hasPathTo(0));
        assertTrue(pathFind.hasPathTo(1));
        assertTrue(pathFind.hasPathTo(2));
    }

    @Test
    public void case41(){
        Diagraph g = new Diagraph("3 2 0 1 1 2");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
        assertEquals(Arrays.asList(0,1,2), pathFind.pathTo(2));
    }

    @Test
    public void case5(){
        Diagraph g = new Diagraph("4 3 0 1 0 2 1 3");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertTrue(pathFind.hasPathTo(1));
        assertTrue(pathFind.hasPathTo(2));
        assertTrue(pathFind.hasPathTo(3));
    }

    @Test
    public void case51() {
        Diagraph g = new Diagraph("4 3 0 1 0 2 1 3");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
        assertEquals(Arrays.asList(0,2), pathFind.pathTo(2));
        assertEquals(Arrays.asList(0,1,3), pathFind.pathTo(3));
    }

    @Test
    public void case6(){
        Diagraph g = new Diagraph("4 3 0 1 0 2 2 3");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertTrue(pathFind.hasPathTo(1));
        assertTrue(pathFind.hasPathTo(2));
        assertTrue(pathFind.hasPathTo(3));
    }

    @Test
    public void case61() {
        Diagraph g = new Diagraph("4 3 0 1 0 2 2 3");
        DepthFirstDirectedPath pathFind = new DepthFirstDirectedPath(g, 0);
        assertEquals(Arrays.asList(0,1), pathFind.pathTo(1));
        assertEquals(Arrays.asList(0,2), pathFind.pathTo(2));
        assertEquals(Arrays.asList(0,2,3), pathFind.pathTo(3));
    }
}
