package search.test;

import org.junit.Test;
import search.BinarySearchTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created on 6/13/2017.
 */
public class BinarySearchTreeSTTest {
    @Test
    public void t1(){
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        bst.put(5,5);

        assertEquals(Integer.valueOf(5), bst.get(5));

        bst.put(8,8);


        assertEquals(Integer.valueOf(5), bst.min());
        assertEquals(Integer.valueOf(8), bst.max());

        assertEquals(Integer.valueOf(8), bst.get(8));

        bst.put(7,7);

        assertEquals(Integer.valueOf(7), bst.get(7));

        bst.put(4,4);

        assertEquals(Integer.valueOf(4), bst.min());
        assertEquals(Integer.valueOf(8), bst.max());

        assertEquals(Integer.valueOf(4), bst.get(4));

        bst.put(1,1);
        bst.put(100,100);

        assertEquals(Integer.valueOf(5), bst.floor(6));
        assertEquals(Integer.valueOf(1), bst.floor(1));
        assertEquals(Integer.valueOf(1), bst.floor(2));
        assertEquals(Integer.valueOf(4), bst.floor(4));
        assertEquals(Integer.valueOf(5), bst.floor(5));

        assertEquals(Integer.valueOf(7), bst.ceiling(6));

        assertEquals(Integer.valueOf(1), bst.min());
        assertEquals(Integer.valueOf(100), bst.max());

        assertEquals(Integer.valueOf(3),(Integer) bst.rank(7));
    }

    @Test
    public void t2(){
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        bst.putRecursive(5,5);

        assertEquals(Integer.valueOf(5), bst.getRecursive(5));

        bst.putRecursive(8,8);

        assertEquals(Integer.valueOf(8), bst.getRecursive(8));

        bst.putRecursive(7,7);

        assertEquals(Integer.valueOf(7), bst.getRecursive(7));

        bst.putRecursive(4,4);

        assertEquals(Integer.valueOf(4), bst.getRecursive(4));
    }

    @Test
    public void testDelete(){
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        bst.put(4,4);
        bst.put(2,2);
            bst.put(3,3);
        bst.put(1,1);

        bst.put(7,7);
        bst.put(6,6);
        bst.put(8,8);

        //bst.delete(1);
        bst.deleteMin();
        bst.deleteMin();

    }
}
