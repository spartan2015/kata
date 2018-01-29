package ian2018.graph.unidrected;

import org.junit.Test;

/**
 *
 */
public class SymbolGraphTest {

    @Test
    public void c1(){
        SymbolGraph sg = new SymbolGraph("a b\nc d"," ");
        System.out.println(sg.toString());
    }
}
