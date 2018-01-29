package ian2018.graph.unidrected;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DetectBipartiteGraphTest {

    @Test
    public void c1(){
        DetectBipartiteGraph d = new DetectBipartiteGraph(new UnidirectedGraph("1 0"));
        assertFalse(d.isBipartite);
    }

    @Test
    public void c2(){
        DetectBipartiteGraph d = new DetectBipartiteGraph(new UnidirectedGraph("2 1 0 1"));
        assertTrue(d.isBipartite);
    }

    @Test
    public void c3(){
        DetectBipartiteGraph d = new DetectBipartiteGraph(new UnidirectedGraph("4 3 0 1 1 2 0 3"));
        assertTrue(d.isBipartite);
    }

    @Test
    public void c4(){
        DetectBipartiteGraph d = new DetectBipartiteGraph(new UnidirectedGraph("4 4 0 1 1 2 0 2 0 3"));
        assertFalse(d.isBipartite);
    }
}
