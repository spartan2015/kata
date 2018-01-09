package ian2018.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BinarySearchTreeTest {
    @Test
    public void t1(){
        BinarySearchTree<Integer,Integer> st = new BinarySearchTree<>();

        st.put(6,6);
        assertEquals(Integer.valueOf(6), st.root.key);
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(6), st.get(6));
        assertEquals(Integer.valueOf(6), st.getRecursive(6));
        assertEquals(Integer.valueOf(6), st.min());
        assertEquals(Integer.valueOf(6), st.minRecursive());
        assertEquals(Integer.valueOf(6), st.max());
        assertEquals(Integer.valueOf(6), st.maxRecursive());

        assertEquals(Integer.valueOf(6), st.floor(6));
        assertEquals(Integer.valueOf(6), st.floorIterative(6));
        assertNull(st.floor(5));
        assertNull(st.floorIterative(5));

        assertEquals(Integer.valueOf(6), st.ceiling(6));
        assertEquals(Integer.valueOf(6), st.ceilingIterative(6));
        assertNull(st.ceiling(7));
        assertNull(st.ceilingIterative(7));

        assertEquals(Integer.valueOf(6), st.select(1));

        st.put(4,4);
        assertEquals(Integer.valueOf(4), st.root.left.key);
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.left.size));

        assertEquals(Integer.valueOf(4), st.get(4));
        assertEquals(Integer.valueOf(4), st.getRecursive(4));

        assertEquals(Integer.valueOf(4), st.min());
        assertEquals(Integer.valueOf(4), st.minRecursive());
        assertEquals(Integer.valueOf(6), st.max());
        assertEquals(Integer.valueOf(6), st.maxRecursive());

        assertEquals(Integer.valueOf(4), st.floor(5));
        assertEquals(Integer.valueOf(4), st.floorIterative(5));
        assertNull(st.floor(3));
        assertNull(st.floorIterative(3));

        assertEquals(Integer.valueOf(4), st.ceiling(4));
        assertEquals(Integer.valueOf(4), st.ceilingIterative(4));
        assertEquals(Integer.valueOf(6), st.ceiling(5));
        assertEquals(Integer.valueOf(6), st.ceilingIterative(5));
        assertNull(st.ceiling(7));
        assertNull(st.ceilingIterative(7));

        assertEquals(Integer.valueOf(4), st.select(1));
        assertEquals(Integer.valueOf(6), st.select(2));

        st.put(5,5);
        assertEquals(Integer.valueOf(4), st.select(1));
        assertEquals(Integer.valueOf(5), st.select(2));
        assertEquals(Integer.valueOf(6), st.select(3));

        assertEquals(Integer.valueOf(5), st.root.left.right.key);
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.left.size));
        assertEquals(Integer.valueOf(5), st.get(5));
        assertEquals(Integer.valueOf(5), st.getRecursive(5));
        assertEquals(Integer.valueOf(4), st.min());
        assertEquals(Integer.valueOf(4), st.minRecursive());
        assertEquals(Integer.valueOf(6), st.max());
        assertEquals(Integer.valueOf(6), st.maxRecursive());

        assertEquals(Integer.valueOf(5), st.floor(5));
        assertEquals(Integer.valueOf(5), st.floorIterative(5));
        assertNull(st.floor(3));
        assertNull(st.floorIterative(3));

        assertEquals(Integer.valueOf(5), st.ceiling(5));
        assertEquals(Integer.valueOf(5), st.ceilingIterative(5));
        assertEquals(Integer.valueOf(6), st.ceiling(6));
        assertEquals(Integer.valueOf(6), st.ceilingIterative(6));
        assertNull(st.ceiling(7));
        assertNull(st.ceilingIterative(7));

        st.put(3,3);
        assertEquals(Integer.valueOf(3), st.select(1));
        assertEquals(Integer.valueOf(4), st.select(2));
        assertEquals(Integer.valueOf(5), st.select(3));
        assertEquals(Integer.valueOf(6), st.select(4));


        assertEquals(Integer.valueOf(3), st.root.left.left.key);
        assertEquals(Integer.valueOf(4), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.left.size));
        assertEquals(Integer.valueOf(3), st.get(3));
        assertEquals(Integer.valueOf(3), st.getRecursive(3));
        assertEquals(Integer.valueOf(3), st.min());
        assertEquals(Integer.valueOf(3), st.minRecursive());
        assertEquals(Integer.valueOf(6), st.max());
        assertEquals(Integer.valueOf(6), st.maxRecursive());

        assertEquals(Integer.valueOf(3), st.floor(3));
        assertEquals(Integer.valueOf(3), st.floorIterative(3));
        assertNull(st.floor(2));
        assertNull(st.floorIterative(2));

        assertEquals(Integer.valueOf(3), st.ceiling(3));
        assertEquals(Integer.valueOf(3), st.ceilingIterative(3));
        assertEquals(Integer.valueOf(6), st.ceiling(6));
        assertEquals(Integer.valueOf(6), st.ceilingIterative(6));
        assertNull(st.ceiling(7));
        assertNull(st.ceilingIterative(7));

        st.put(8,8);
        assertEquals(Integer.valueOf(3), st.select(1));
        assertEquals(Integer.valueOf(4), st.select(2));
        assertEquals(Integer.valueOf(5), st.select(3));
        assertEquals(Integer.valueOf(6), st.select(4));
        assertEquals(Integer.valueOf(8), st.select(5));

        assertEquals(Integer.valueOf(3), st.selectIterative(1));
        assertEquals(Integer.valueOf(4), st.selectIterative(2));
        assertEquals(Integer.valueOf(5), st.selectIterative(3));
        assertEquals(Integer.valueOf(6), st.selectIterative(4));
        assertEquals(Integer.valueOf(8), st.selectIterative(5));

        assertEquals(Integer.valueOf(8), st.get(8));
        assertEquals(Integer.valueOf(8), st.getRecursive(8));
        assertEquals(Integer.valueOf(8), st.root.right.key);
        assertEquals(Integer.valueOf(5), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.right.size));
        assertEquals(Integer.valueOf(3), st.min());
        assertEquals(Integer.valueOf(3), st.minRecursive());
        assertEquals(Integer.valueOf(8), st.max());
        assertEquals(Integer.valueOf(8), st.maxRecursive());

        assertEquals(Integer.valueOf(8), st.floor(8));
        assertEquals(Integer.valueOf(8), st.floorIterative(8));
        assertNull(st.floor(2));
        assertNull(st.floorIterative(2));

        assertEquals(Integer.valueOf(8), st.ceiling(8));
        assertEquals(Integer.valueOf(8), st.ceilingIterative(8));
        assertEquals(Integer.valueOf(8), st.ceiling(7));
        assertEquals(Integer.valueOf(8), st.ceilingIterative(7));
        assertNull(st.ceiling(10));
        assertNull(st.ceilingIterative(10));

        st.put(7,7);

        assertEquals(Integer.valueOf(3), st.select(1));
        assertEquals(Integer.valueOf(4), st.select(2));
        assertEquals(Integer.valueOf(5), st.select(3));
        assertEquals(Integer.valueOf(6), st.select(4));
        assertEquals(Integer.valueOf(7), st.select(5));
        assertEquals(Integer.valueOf(8), st.select(6));

        assertEquals(Integer.valueOf(3), st.selectIterative(1));
        assertEquals(Integer.valueOf(4), st.selectIterative(2));
        assertEquals(Integer.valueOf(5), st.selectIterative(3));
        assertEquals(Integer.valueOf(6), st.selectIterative(4));
        assertEquals(Integer.valueOf(7), st.selectIterative(5));
        assertEquals(Integer.valueOf(8), st.selectIterative(6));

        assertEquals(Integer.valueOf(7), st.get(7));
        assertEquals(Integer.valueOf(7), st.getRecursive(7));
        assertEquals(Integer.valueOf(7), st.root.right.left.key);
        assertEquals(Integer.valueOf(6), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.right.size));
        assertEquals(Integer.valueOf(3), st.min());
        assertEquals(Integer.valueOf(3), st.minRecursive());
        assertEquals(Integer.valueOf(8), st.max());
        assertEquals(Integer.valueOf(8), st.maxRecursive());

        assertEquals(Integer.valueOf(7), st.floor(7));
        assertEquals(Integer.valueOf(7), st.floorIterative(7));
        assertNull(st.floor(2));
        assertNull(st.floorIterative(2));

        assertEquals(Integer.valueOf(7), st.ceiling(7));
        assertEquals(Integer.valueOf(7), st.ceilingIterative(7));
        assertEquals(Integer.valueOf(8), st.ceiling(8));
        assertEquals(Integer.valueOf(8), st.ceilingIterative(8));
        assertNull(st.ceiling(10));
        assertNull(st.ceilingIterative(10));

        st.put(9,9);

        assertEquals(Integer.valueOf(3), st.select(1));
        assertEquals(Integer.valueOf(4), st.select(2));
        assertEquals(Integer.valueOf(5), st.select(3));
        assertEquals(Integer.valueOf(6), st.select(4));
        assertEquals(Integer.valueOf(7), st.select(5));
        assertEquals(Integer.valueOf(8), st.select(6));
        assertEquals(Integer.valueOf(9), st.select(7));

        assertEquals(Integer.valueOf(3), st.selectIterative(1));
        assertEquals(Integer.valueOf(4), st.selectIterative(2));
        assertEquals(Integer.valueOf(5), st.selectIterative(3));
        assertEquals(Integer.valueOf(6), st.selectIterative(4));
        assertEquals(Integer.valueOf(7), st.selectIterative(5));
        assertEquals(Integer.valueOf(8), st.selectIterative(6));
        assertEquals(Integer.valueOf(9), st.selectIterative(7));

        assertEquals(Integer.valueOf(1), (Integer)st.rank(3));
        assertEquals(Integer.valueOf(2), (Integer)st.rank(4));
        assertEquals(Integer.valueOf(3), (Integer)st.rank(5));
        assertEquals(Integer.valueOf(4), (Integer)st.rank(6));
        assertEquals(Integer.valueOf(5), (Integer)st.rank(7));
        assertEquals(Integer.valueOf(6), (Integer)st.rank(8));
        assertEquals(Integer.valueOf(7), (Integer)st.rank(9));

        assertEquals(Integer.valueOf(1), (Integer)st.rankIterative(3));
        assertEquals(Integer.valueOf(2), (Integer)st.rankIterative(4));
        assertEquals(Integer.valueOf(3), (Integer)st.rankIterative(5));
        assertEquals(Integer.valueOf(4), (Integer)st.rankIterative(6));
        assertEquals(Integer.valueOf(5), (Integer)st.rankIterative(7));
        assertEquals(Integer.valueOf(6), (Integer)st.rankIterative(8));
        assertEquals(Integer.valueOf(7), (Integer)st.rankIterative(9));

        assertEquals(Integer.valueOf(9), st.get(9));
        assertEquals(Integer.valueOf(9), st.getRecursive(9));
        assertEquals(Integer.valueOf(9), st.root.right.right.key);
        assertEquals(Integer.valueOf(7), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.right.size));
        assertEquals(Integer.valueOf(3), st.min());
        assertEquals(Integer.valueOf(3), st.minRecursive());
        assertEquals(Integer.valueOf(9), st.max());
        assertEquals(Integer.valueOf(9), st.maxRecursive());

        assertEquals(Integer.valueOf(9), st.floor(9));
        assertEquals(Integer.valueOf(9), st.floorIterative(9));
        assertNull(st.floor(2));
        assertNull(st.floorIterative(2));

        assertEquals(Integer.valueOf(9), st.ceiling(9));
        assertEquals(Integer.valueOf(9), st.ceilingIterative(9));
        assertEquals(Integer.valueOf(8), st.ceiling(8));
        assertEquals(Integer.valueOf(8), st.ceilingIterative(8));
        assertNull(st.ceiling(10));
        assertNull(st.ceilingIterative(10));
    }

    @Test
    public void t2(){
        BinarySearchTree<Integer,Integer> st = new BinarySearchTree<>();

        st.putIterative(6,6);
        assertEquals(Integer.valueOf(6), st.root.key);
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.size));
        st.putIterative(4,4);
        assertEquals(Integer.valueOf(4), st.root.left.key);
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.left.size));
        st.putIterative(5,5);
        assertEquals(Integer.valueOf(5), st.root.left.right.key);
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.left.size));
        st.putIterative(3,3);
        assertEquals(Integer.valueOf(3), st.root.left.left.key);
        assertEquals(Integer.valueOf(4), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.left.size));

        st.putIterative(8,8);
        assertEquals(Integer.valueOf(8), st.root.right.key);
        assertEquals(Integer.valueOf(5), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.right.size));
        st.putIterative(7,7);
        assertEquals(Integer.valueOf(7), st.root.right.left.key);
        assertEquals(Integer.valueOf(6), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.right.size));
        st.putIterative(9,9);
        assertEquals(Integer.valueOf(9), st.root.right.right.key);
        assertEquals(Integer.valueOf(7), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.right.size));
    }
}
