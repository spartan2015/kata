package bitwise.s2;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Subset {

	@Test
	public void test(){
		System.out.println(allSubsets(Arrays.asList(1,2,3,4)));
	}

	private List<List<Integer>> allSubsets(List<Integer> list) {
		List<List<Integer>> allsubsets = new LinkedList<>();
		int bitfield = (1 << list.size())-1;
		while(bitfield >=0){
			allsubsets.add(createFromBitfield(list, bitfield));
			bitfield--;
		}
		return allsubsets;
	}

	private List<Integer> createFromBitfield(List<Integer> list, int bitfield) {
		List<Integer> set = new LinkedList<>();
		int noOfBits = list.size();
		for(int bitNo =0; bitNo< noOfBits; bitNo++){
			if ( (bitfield & 1<<bitNo) != 0){
				set.add(list.get(bitNo));
			}
		}
		return set;
	}
	
}
