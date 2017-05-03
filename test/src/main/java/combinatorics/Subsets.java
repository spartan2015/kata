package combinatorics;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * can be obtained with combinatorics also - see Combinatorics.allSubsets
 * 
 * @author vasil
 *
 */
public class Subsets {

	@Test
	public void test(){
		assertTrue(2 == noOfSubsets(2));
		assertTrue(8 == noOfSubsets(3));
	}
	
	@Test
	public void testMySubsts(){
		System.out.println(getAllSubset(new int[]{1,2,3}));
	}
	public int noOfSubsets(int setLength){
		return (int)Math.pow(2, setLength);
	}

	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> all;
		if (set.size() == index){
			all = new ArrayList<>();
			all.add(new ArrayList<Integer>()); // the empty subset
		}else{
			all = getSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> more = new ArrayList<>();
			for(ArrayList<Integer> subset : all){
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				more.add(newSubset);
			}
			all.addAll(more);
		}
		return all;
	}
	
	public List<Set<Integer>> getAllSubset(int[] data){
		List<Set<Integer>> all = new ArrayList<>();
		for(int i =0; i< data.length; i++){
			Set<Integer> newSet = new HashSet<>();
			newSet.add(data[i]);
			List<Set<Integer>> more =new ArrayList<>();
			for(Set<Integer> existing : all){
				Set<Integer> newSet2 = new HashSet<>();
				newSet2.addAll(existing);
				newSet2.add(data[i]);
				more.add(newSet2);
			}
			all.add(newSet);
			all.addAll(more);
		}
		return all;
	}
	
	public List<Set<Integer>> getAllSubsetsUsingBinaryOps(int[] data){
		List<Set<Integer>> all = new ArrayList<>();
		int max = 1 << data.length;
		for(int i =0; i< max; i++){
			Set<Integer> newSubset = new HashSet<>();
			int k = i;
			int index = 0;
			while(k > 0){
				if ((k & 1) > 0){
					newSubset.add(data[index]);
				}
				k >>=1;
				index++;
			}
			all.add(newSubset);
		}
		return all;
	}
}
