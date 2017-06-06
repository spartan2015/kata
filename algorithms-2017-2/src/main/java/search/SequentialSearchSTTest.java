package search;

import static org.junit.Assert.*;

import org.junit.Test;

public class SequentialSearchSTTest {

	@Test
	public void put() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
		for (int i = 0; i < 10; i++) {
			String key = Integer.toString(i);
			assertFalse(st.contains(key));
			st.put(key, i);
			assertTrue(st.contains(key));
			assertEquals(Integer.valueOf(i), st.get(key));
			assertTrue(st.size == i + 1);
		}

		for (int i = 0; i < 10; i++) {
			String key = Integer.toString(i);
			st.delete(key);
			assertNull(st.get(key));
		}
	}
}
