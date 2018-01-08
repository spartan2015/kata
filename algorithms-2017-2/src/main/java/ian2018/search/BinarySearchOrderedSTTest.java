package ian2018.search;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created on 1/5/2018.
 */
public class BinarySearchOrderedSTTest {

    @Test
    public void c1(){
      BinarySearchOrderedST<Integer, Integer> st = new BinarySearchOrderedST<>();
      for(int i = 20; i >0; i--){
          st.put(i,i);
          assertTrue(st.get(i)==i);
      }
      for(int i = 1; i <= 20; i++ ){
          assertEquals(st.select(i-1), Integer.valueOf(i));
          assertEquals(st.get(i), Integer.valueOf(i));
      }
    }

    @Test
    public void rankReturnsTheNumberOfElementsLessThanCurrentKeyWhenElementNotFound(){
        BinarySearchOrderedST<Integer, Integer> st = new BinarySearchOrderedST<>();
        st.put(1,1);
        st.put(3,3);
        st.put(5,5);

        assertEquals(3,st.rank(6));

        assertEquals(Integer.valueOf(5), st.floor(6));

        assertEquals(1,st.rank(2));

        assertEquals(Integer.valueOf(1), st.floor(2));

        assertEquals(2,st.rank(4));

        assertEquals(Integer.valueOf(3), st.floor(4));

    }

    @Test
    public void ceiling(){
        BinarySearchOrderedST<Integer, Integer> st = new BinarySearchOrderedST<>();
        st.put(1,1);
        st.put(3,3);
        st.put(5,5);

        assertEquals(Integer.valueOf(1), st.ceiling(1));
        assertEquals(Integer.valueOf(3), st.ceiling(2));
        assertEquals(Integer.valueOf(3), st.ceiling(3));
        assertEquals(Integer.valueOf(5), st.ceiling(4));
        assertEquals(Integer.valueOf(5), st.ceiling(5));
        assertNull(st.ceiling(6));
    }

    @Test
    public void testKeysIterator(){
        BinarySearchOrderedST<Integer, Integer> st = new BinarySearchOrderedST<>();
        st.put(1,1);
        st.put(3,3);
        st.put(5,5);

        Iterable<Integer> range = st.keys(1,4);
        Iterator<Integer> iterator = range.iterator();
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext());
    }
}
