package wallet;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.bouncycastle.util.Arrays;
import org.junit.Test;

public class ComplementaryPairs {

	@Test
	public void testFindsComplement(){
		int[] testData = new int[]{7,3,1,2};
		List<int[]> result = complementaryPairs(10, testData);
		assertTrue(result.size() == 1);
		assertTrue(Arrays.areEqual(result.get(0), new int[]{7,3}));
	}
	
	@Test
	public void testDoesnNotFindsComplement(){
		int[] testData = new int[]{7,3,1,2};
		List<int[]> result = complementaryPairs(20, testData);
		assertTrue(result.size() == 0);
	}
	
}
