package ian2018.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    @Test
    public void t1(){
        BinarySearchTree<Integer,Integer> st = new BinarySearchTree<>();

        st.put(6,6);
        assertEquals(Integer.valueOf(6), st.root.key);
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.size));
        st.put(4,4);
        assertEquals(Integer.valueOf(4), st.root.left.key);
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.left.size));
        st.put(5,5);
        assertEquals(Integer.valueOf(5), st.root.left.right.key);
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.left.size));
        st.put(3,3);
        assertEquals(Integer.valueOf(3), st.root.left.left.key);
        assertEquals(Integer.valueOf(4), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.left.size));

        st.put(8,8);
        assertEquals(Integer.valueOf(8), st.root.right.key);
        assertEquals(Integer.valueOf(5), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(1), Integer.valueOf(st.root.right.size));
        st.put(7,7);
        assertEquals(Integer.valueOf(7), st.root.right.left.key);
        assertEquals(Integer.valueOf(6), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(2), Integer.valueOf(st.root.right.size));
        st.put(9,9);
        assertEquals(Integer.valueOf(9), st.root.right.right.key);
        assertEquals(Integer.valueOf(7), Integer.valueOf(st.root.size));
        assertEquals(Integer.valueOf(3), Integer.valueOf(st.root.right.size));
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
