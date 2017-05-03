package strings.algo.searching.test;

import static org.junit.Assert.*;

import org.junit.Test;

import strings.algo.searching.TernarySearchTrie;

public class TernarySearchTrieTest {
	@Test
	public void test() {
		TernarySearchTrie<Integer> tst = new TernarySearchTrie<>();
		tst.put("b", 1);
		tst.put("a", 2);
		tst.put("c", 3);
		
		tst.put("ba", 4);
		
		assertEquals(Integer.valueOf(1), tst.get("b"));
		assertEquals(Integer.valueOf(2), tst.get("a"));
		assertEquals(Integer.valueOf(3), tst.get("c"));
		assertEquals(Integer.valueOf(4), tst.get("ba"));
		assertNull(tst.get("bac"));
		
		tst.put("x", 5);
		assertEquals(Integer.valueOf(5), tst.get("x"));
	}
}
