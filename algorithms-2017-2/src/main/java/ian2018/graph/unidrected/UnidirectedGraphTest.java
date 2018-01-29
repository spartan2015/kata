package ian2018.graph.unidrected;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnidirectedGraphTest {

    @Test
    public void t() {
        UnidirectedGraph unidirectedGraph = new UnidirectedGraph("13\n" +
                "13\n" +
                "0 5\n" +
                "4 3\n" +
                "0 1\n" +
                "9 12\n" +
                "6 4\n" +
                "5 4\n" +
                "0 2\n" +
                "11 12\n" +
                "9 10\n" +
                "0 6\n" +
                "7 8\n" +
                "9 11\n" +
                "5 3");

        System.out.println(unidirectedGraph);

        SearchGraph searchGraph = new SearchGraph(unidirectedGraph,0);
        assertTrue(searchGraph.marked(6));
        assertTrue(searchGraph.marked(2));
        assertTrue(searchGraph.marked(1));
        assertTrue(searchGraph.marked(5));
        assertTrue(searchGraph.marked(4));
        assertTrue(searchGraph.marked(3));

        assertFalse(searchGraph.marked(9));
        assertFalse(searchGraph.marked(10));
        assertFalse(searchGraph.marked(11));
        assertFalse(searchGraph.marked(12));

        System.out.println(searchGraph.count());

        for (int v = 0; v < unidirectedGraph.V(); v++)
            if (searchGraph.marked(v))
                System.out.print(v + " ");
        System.out.println();
        if (searchGraph.count() != unidirectedGraph.V())
            System.out.print("NOT ");
        System.out.println("connected");
    }

}
