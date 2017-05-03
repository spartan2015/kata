package strings.algo.searching.test;

import static org.junit.Assert.*;

import org.junit.Test;

import strings.algo.searching.TrieSearchTable;

public class TrieTest {

	@Test
	public void test() {
		TrieSearchTable<Integer> st = new TrieSearchTable<>();
		
		st.put("abc", 1);
		assertEquals(Integer.valueOf(1),st.get("abc"));
		
		assertNull(st.get("a"));
		assertNull(st.get("b"));
		assertNull(st.get("ab"));
		
		st.put("a", 3);
		assertEquals(Integer.valueOf(3),st.get("a"));
		
		st.put("ab", 2);
		
		assertEquals(Integer.valueOf(2),st.get("ab"));
		
		assertNull(st.get("b"));
		st.put("b", 10);
		assertEquals(Integer.valueOf(10),st.get("b"));
		
		System.out.println(st.keys());
		
		System.out.println(st.keysWithPrefix("a"));
		
		System.out.println(st.keysWithPrefix("ab"));
		
		System.out.println(st.longestPrefixOf("abcd"));
		
		st.delete("abc");
	}

}
