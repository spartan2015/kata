package ian2018.graph.unidrected;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class DegreesOfSeparationTest {

    @Test
    public void c1(){
        DegreesOfSeparation ds = new DegreesOfSeparation(new SymbolGraph("a b\nb c"," "));
        assertEquals("a-b-c",ds.pathTo("c"));
    }

}
