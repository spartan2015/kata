package collections.test;
import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class NavigableSetTests {

	
	@Test
	public void t1(){
		
		TreeSet<Integer> set = new TreeSet<>();
		
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);
		
		
		assertEquals(Integer.valueOf(3),set.floor(4)); // <= less than or equal to the given element
		assertEquals(Integer.valueOf(1),set.lower(3));
		
		assertEquals(Integer.valueOf(7),set.higher(5));
		assertEquals(Integer.valueOf(5),set.ceiling(5)); // >= greater than or equal to the given element
		
	}
	
}
