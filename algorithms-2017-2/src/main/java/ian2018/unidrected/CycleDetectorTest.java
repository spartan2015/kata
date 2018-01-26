package ian2018.unidrected;


import org.junit.Assert;
import org.junit.Test;

public class CycleDetectorTest {
    @Test
    public void c1(){
        CycleDetector cc = new CycleDetector(new UnidirectedGraph("3 3 0 1 1 2 0 2"));
        Assert.assertTrue(cc.hasCycle);
    }

    @Test
    public void c2(){
        CycleDetector cc = new CycleDetector(new UnidirectedGraph("3 2 0 1 0 2"));
        Assert.assertFalse(cc.hasCycle);
    }

    @Test
    public void c3(){
        CycleDetector cc = new CycleDetector(new UnidirectedGraph("4 4 0 1 1 2 2 3 0 3"));
        Assert.assertTrue(cc.hasCycle);
    }

    @Test
    public void c4(){
        CycleDetector cc = new CycleDetector(new UnidirectedGraph("4 4 0 1 1 2 2 3 0 2"));
        Assert.assertTrue(cc.hasCycle);
    }

    @Test
    public void c5(){
        CycleDetector cc = new CycleDetector(new UnidirectedGraph("5 4 0 1 1 2 0 3 3 4"));
        Assert.assertFalse(cc.hasCycle);
    }
}
