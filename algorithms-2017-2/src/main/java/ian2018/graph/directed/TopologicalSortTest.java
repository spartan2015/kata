package ian2018.graph.directed;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class TopologicalSortTest {
    @Test
    public void c1(){
        TopologicalSort ts = new TopologicalSort(new Diagraph("4 3 0 1 1 2 2 3"));
        TopologicalSortSedgewick tss = new TopologicalSortSedgewick(new Diagraph("4 3 0 1 1 2 2 3"));
        System.out.println(tss.pre);
        System.out.println(tss.post);
        System.out.println(tss.reversePost);

        assertEquals(Arrays.asList(0,1,2,3), ts.inOrder(0));
        assertEquals(Arrays.asList(1,2,3), ts.inOrder(1));
        assertEquals(Arrays.asList(2,3), ts.inOrder(2));
        assertEquals(Arrays.asList(3), ts.inOrder(3));
    }

    @Test
    public void c2(){
        TopologicalSort ts = new TopologicalSort(new Diagraph("4 4 0 1 0 2 1 3 2 3"));
        TopologicalSortSedgewick tss = new TopologicalSortSedgewick(new Diagraph("4 4 0 1 0 2 1 3 2 3"));
        System.out.println(tss.pre);
        System.out.println(ts.possiblePaths(0));

        System.out.println(tss.post);
        System.out.println(tss.reversePost);


        assertEquals(Arrays.asList(0,2,3), ts.inOrder(0));
        assertEquals(Arrays.asList(1,3), ts.inOrder(1));
        assertEquals(Arrays.asList(2,3), ts.inOrder(2));
        //assertEquals(Arrays.asList(3), ts.inOrder(3));
    }
}
