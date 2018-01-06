package ian2018.search;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created on 1/4/2018.
 */
public class SequentialSearchSTTest {

    @Test
    public void c1(){
        SequentialSearchST<Integer,Integer> st = new SequentialSearchST<>();
        st.put(1,1);
        assertTrue(st.head.key == 1);
        assertTrue(1 == st.get(1));

        st.put(2,2);
        assertTrue(st.head.key == 2);
        assertTrue(st.head.next.key == 1);
        assertTrue(1 == st.get(1));
        assertTrue(2 == st.get(2));

        st.put(1,3);
        assertTrue(st.head.next.value == 3);
        assertTrue(3 == st.get(1));
    }

    @Test
    public void c12(){
        SequentialSearchST<Integer,Integer> st = new SequentialSearchST<>();
        st.put2(1,1);
        assertTrue(st.head.key == 1);
        assertTrue(1 == st.get2(1));

        st.put2(2,2);
        assertTrue(st.head.key == 2);
        assertTrue(st.head.next.key == 1);
        assertTrue(1 == st.get2(1));
        assertTrue(2 == st.get2(2));

        st.put2(1,3);
        assertTrue(st.head.next.value == 3);
        assertTrue(3 == st.get2(1));
    }
}
