package search.test;

import org.junit.Test;
import search.BinarySearchTree;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static util.ReflectionUtils.getFieldValue;

/**
 * Created on 6/13/2017.
 */
public class BinarySearchTreeSTTest {
    @Test
    public void t1() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

        bst.put(5, 5);

        assertEquals(Integer.valueOf(5), bst.get(5));

        bst.put(8, 8);


        assertEquals(Integer.valueOf(5), bst.min());
        assertEquals(Integer.valueOf(8), bst.max());

        assertEquals(Integer.valueOf(8), bst.get(8));

        bst.put(7, 7);

        assertEquals(Integer.valueOf(7), bst.get(7));

        bst.put(4, 4);

        assertEquals(Integer.valueOf(4), bst.min());
        assertEquals(Integer.valueOf(8), bst.max());

        assertEquals(Integer.valueOf(4), bst.get(4));

        bst.put(1, 1);
        bst.put(100, 100);

        assertEquals(Integer.valueOf(5), bst.floor(6));
        assertEquals(Integer.valueOf(1), bst.floor(1));
        assertEquals(Integer.valueOf(1), bst.floor(2));
        assertEquals(Integer.valueOf(4), bst.floor(4));
        assertEquals(Integer.valueOf(5), bst.floor(5));

        assertEquals(Integer.valueOf(7), bst.ceiling(6));

        assertEquals(Integer.valueOf(1), bst.min());
        assertEquals(Integer.valueOf(100), bst.max());

        assertEquals(Integer.valueOf(3), (Integer) bst.rank(7));
    }

    @Test
    public void t2() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

        bst.putRecursive(5, 5);

        assertEquals(Integer.valueOf(5), bst.getRecursive(5));

        bst.putRecursive(8, 8);

        assertEquals(Integer.valueOf(8), bst.getRecursive(8));

        bst.putRecursive(7, 7);

        assertEquals(Integer.valueOf(7), bst.getRecursive(7));

        bst.putRecursive(4, 4);

        assertEquals(Integer.valueOf(4), bst.getRecursive(4));
    }

    @Test
    public void testDelete() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

        bst.put(4, 4);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(1, 1);

        bst.put(7, 7);
        bst.put(6, 6);
        bst.put(8, 8);

        //bst.delete(1);
        bst.deleteMin();
        bst.deleteMin();

    }

    @Test
    public void constructor1() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1, 2, 3});
        assertEquals(Integer.valueOf(2), getFieldValue(bst, "root.key"));
        assertEquals(Integer.valueOf(1), getFieldValue(bst, "root.left.key"));
        assertEquals(Integer.valueOf(3), getFieldValue(bst, "root.right.key"));
    }

    @Test
    public void constructor2() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1,2});
        assertEquals(Integer.valueOf(1), getFieldValue(bst, "root.key"));
        assertNull(getFieldValue(bst, "root.left"));
        assertEquals(Integer.valueOf(2), getFieldValue(bst, "root.right.key"));
    }

    @Test
    public void constructor3() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1});
        assertEquals(Integer.valueOf(1), getFieldValue(bst, "root.key"));
        assertNull(getFieldValue(bst, "root.left"));
        assertNull(getFieldValue(bst, "root.right"));
    }

    @Test
    public void traversal(){
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1,2,3});
        assertEquals("[1, 2, 3]",bst.inOrderTraversal().toString());
    }

    @Test
    public void preOrderTraversal(){
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1,2,3});
        System.out.println(bst.preOrderTraversal());
        assertEquals("[2, 1, 3]",bst.preOrderTraversal().toString());
    }

    @Test
    public void postOrderTraversal(){
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1,2,3});
        assertEquals("[1, 3, 2]",bst.postOrderTraversal().toString());
    }

    @Test
    public void inOrderTraversalNonRecursive(){
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1,2,3,4,5,6,7});
        assertEquals("[1, 2, 3, 4, 5, 6, 7]",bst.inOrderTraversalNonRecursive().toString());
    }
    @Test
    public void keyInRangeNR(){
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>(new Integer[]{1,2,3,4,5,6,7});
        assertEquals("[3, 4, 5]",bst.keysNR(3,5).toString());
        assertEquals("[1, 2]",bst.keysNR(1,2).toString());
        assertEquals("[6, 7]",bst.keysNR(6,7).toString());
    }


}
