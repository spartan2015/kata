package ian2018.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedBlackTreeTest {

    @Test
    public void test(){
        RedBlackTree<Integer, Integer> bst = new RedBlackTree<>();

        bst.put(1,1);
        assertEquals(Integer.valueOf(1), bst.root.key);

        bst.put(2,2);
        assertEquals(Integer.valueOf(2), bst.root.key);
        assertEquals(Integer.valueOf(1), bst.root.left.key);

        bst.put(3,3);
        assertEquals(Integer.valueOf(2), bst.root.key);
        assertEquals(Integer.valueOf(1), bst.root.left.key);
        assertEquals(Integer.valueOf(3), bst.root.right.key);

        bst.put(4,4);
        assertEquals(Integer.valueOf(2), bst.root.key);
        assertEquals(Integer.valueOf(1), bst.root.left.key);
        assertEquals(Integer.valueOf(4), bst.root.right.key);
        assertEquals(Integer.valueOf(3), bst.root.right.left.key);

        bst.put(5,5);

        assertEquals(Integer.valueOf(4), bst.root.key);
        assertEquals(Integer.valueOf(2), bst.root.left.key);
        assertEquals(Integer.valueOf(5), bst.root.right.key);
        assertEquals(Integer.valueOf(1), bst.root.left.left.key);
        assertEquals(Integer.valueOf(3), bst.root.left.right.key);

        bst.put(6,6);
        bst.put(7,7);
        bst.put(8,8);
        bst.put(9,9);
        bst.put(10,10);
    }

    @Test
    public void test2() {
        RedBlackTree<String, String> bst = new RedBlackTree<>();
        bst.put("S","");
        bst.put("E","");
        bst.put("A","");
        bst.put("R","");
        bst.put("C","");
        bst.put("H","");
    }
}
