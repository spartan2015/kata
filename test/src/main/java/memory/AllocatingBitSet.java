package memory;

import org.junit.Test;

public class AllocatingBitSet {

	@Test
	public void test(){
		System.out.println(Integer.MAX_VALUE / (8*1024*1024)); // 255 mb mem if you allocate a bitset that big
	}
	
}
