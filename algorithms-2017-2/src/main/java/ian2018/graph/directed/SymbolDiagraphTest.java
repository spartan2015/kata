package ian2018.graph.directed;

import org.junit.Test;

/**
 *
 */
public class SymbolDiagraphTest {

    @Test
    public void c1(){
        SymbolDigraph sg = new SymbolDigraph("a b\nc d"," ");
        System.out.println(sg.toString());
    }
}
