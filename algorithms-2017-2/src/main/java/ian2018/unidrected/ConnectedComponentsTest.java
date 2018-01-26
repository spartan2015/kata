package ian2018.unidrected;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConnectedComponentsTest {
    @Test
    public void c1(){
        ConnectedComponents cc = new ConnectedComponents(new UnidirectedGraph("2 0"));
        assertEquals(Integer.valueOf(2),(Integer)cc.count());
    }

    @Test
    public void c2(){
        ConnectedComponents cc = new ConnectedComponents(new UnidirectedGraph("2 1 0 1"));
        assertEquals(Integer.valueOf(1),(Integer)cc.count());
    }

    @Test
    public void c3(){
        ConnectedComponents cc = new ConnectedComponents(new UnidirectedGraph("2 1 0 0"));
        assertEquals(Integer.valueOf(2),(Integer)cc.count());
    }

    @Test
    public void c4(){
        ConnectedComponents cc = new ConnectedComponents(new UnidirectedGraph("3 0"));
        assertEquals(Integer.valueOf(3),(Integer)cc.count());
    }

    @Test
    public void c5(){
        ConnectedComponents cc = new ConnectedComponents(new UnidirectedGraph("4 0"));
        assertEquals(Integer.valueOf(4),(Integer)cc.count());
    }

    @Test
    public void c6(){
        ConnectedComponents cc = new ConnectedComponents(new UnidirectedGraph("4 1 0 1"));
        assertEquals(Integer.valueOf(3),(Integer)cc.count());
    }

    @Test
    public void c7(){
        ConnectedComponents cc = new ConnectedComponents(new UnidirectedGraph("4 2 0 1 1 2"));
        assertEquals(Integer.valueOf(2),(Integer)cc.count());

        assertEquals(Integer.valueOf(1),(Integer)cc.id(0));
        assertEquals(Integer.valueOf(1),(Integer)cc.id(1));
        assertEquals(Integer.valueOf(1),(Integer)cc.id(2));
        assertEquals(Integer.valueOf(2),(Integer)cc.id(3));
    }
}
