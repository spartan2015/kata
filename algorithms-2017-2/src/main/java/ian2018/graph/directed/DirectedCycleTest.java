package ian2018.graph.directed;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class DirectedCycleTest {
    @Test
    public void c1(){
        DirectedCycle dc = new DirectedCycle(new Diagraph("1 0"));
        assertFalse(dc.isHasCycle());
    }

    @Test
    public void c2(){
        DirectedCycle dc = new DirectedCycle(new Diagraph("2 1 0 1"));
        assertFalse(dc.isHasCycle());
    }

    @Test
    public void c3(){
        DirectedCycle dc = new DirectedCycle(new Diagraph("2 2 0 1 1 0"));
        assertTrue(dc.isHasCycle());
    }

    @Test
    public void c4(){
        DirectedCycle dc = new DirectedCycle(new Diagraph("4 4 0 1 0 2 1 3 2 3"));
        assertFalse(dc.isHasCycle());
    }
}
