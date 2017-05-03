package bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MissingNumber {

	@Test
	public void test(){
		assert(7 == missingNumber(Arrays.asList(0,1,2,3,4,5,6),7, 0));
		assert(6 == missingNumber(Arrays.asList(0,1,2,3,4,5,7),7, 0));
		assert(5 == missingNumber(Arrays.asList(0,1,2,3,4,6,7),7, 0));
		assert(4 == missingNumber(Arrays.asList(0,1,2,3,5,6,7),7, 0));
		assert(3 == missingNumber(Arrays.asList(0,1,2,4,5,6,7),7, 0));
		assert(2 == missingNumber(Arrays.asList(0,1,3,4,5,6,7),7, 0));
		assert(1 == missingNumber(Arrays.asList(0,2,3,4,5,6,7),7, 0));
		assert(0 == missingNumber(Arrays.asList(1,2,3,4,5,6,7),7, 0));
	}

	private int missingNumber(List<Integer> list, int max, int column) {
		if (column > 2){
			return 0;
		}
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		for(Integer i : list){
			if (onBitValue(i, column)){
				odd.add(i);
			}else{
				even.add(i);
			}
		}
		if (odd.size() > even.size()){
			return missingNumber(even,7, column+1) << 1 | 0;
		}else{
			return missingNumber(even,7, column+1) << 1 | 1;
		}
	}

	private boolean onBitValue(int i, int column) {
		return (i & (1 << column)) != 0;
	}
	
}
