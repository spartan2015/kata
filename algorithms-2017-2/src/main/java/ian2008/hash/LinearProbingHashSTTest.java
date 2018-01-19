package ian2008.hash;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinearProbingHashSTTest {

    @Test
    public void c1(){
        LinearProbingHashST<Integer,Integer> st = new LinearProbingHashST();

        for(int i = 0; i < 16; i++) {
            st.put(i, i);
            assertEquals(Integer.valueOf(i), (Integer) ((Object[]) st.keys)[i]);
            assertEquals(Integer.valueOf(i), st.get(i));
        }
        assertEquals(Integer.valueOf(16), Integer.valueOf(st.size()));

        for(int i = 15; i >0; i--) {
            st.delete(i);
            assertNull(((Object[]) st.keys)[i]);
            assertEquals(i, st.size());
        }
    }

    @Test
    public void c2(){
        LinearProbingHashST<Integer,Integer> st = new LinearProbingHashST();
        st.put(0,0);
        st.put(16,16);
        st.put(32,32);

        assertEquals(Integer.valueOf(0), (Integer) ((Object[]) st.keys)[0]);
        assertEquals(Integer.valueOf(16), (Integer) ((Object[]) st.keys)[1]);
        assertEquals(Integer.valueOf(32), (Integer) ((Object[]) st.keys)[2]);

        st.delete(0);

        assertEquals(Integer.valueOf(16), (Integer) ((Object[]) st.keys)[0]);
        assertEquals(Integer.valueOf(32), (Integer) ((Object[]) st.keys)[1]);

        st.delete(16);

        st.put(1,1);
        assertEquals(Integer.valueOf(1), (Integer) ((Object[]) st.keys)[1]);

        st.delete(32);
    }

    @Test
    public void c3(){
        LinearProbingHashST<Integer,Integer> st = new LinearProbingHashST();
        st.put(0,0);
        st.put(16,16);
        st.put(1,1);
    }
}
