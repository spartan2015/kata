package recursive.s2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SubsetsProblems {

	@Test
	public void test() {

		System.out.println(getAllSubset(Arrays.asList(1, 2, 3, 4)));;
	}

	private List<List<Integer>> getAllSubset(List<Integer> asList) {
		return getAllSubsets(asList, 0);
	}

	private List<List<Integer>> getAllSubsets(List<Integer> asList, int i) {
		if (i >= asList.size()) {
			List<List<Integer>> original = new LinkedList<>();
			original.add(new LinkedList<>());
			return original;
		} else {
			Integer val = asList.get(i);
			List<List<Integer>> subsets = getAllSubsets(asList, i + 1);
			List<List<Integer>> newSubsetList = new LinkedList<>();
			combineWithNewElement(val, subsets, newSubsetList);
			subsets.addAll(newSubsetList);
			return subsets;
		}
	}

	private void combineWithNewElement(Integer val, List<List<Integer>> subsets, List<List<Integer>> newSubsetList) {
		for (List<Integer> subset : subsets) {
			LinkedList<Integer> newSubset = new LinkedList<>();
			newSubset.addAll(subset);
			newSubset.add(val);
			newSubsetList.add(newSubset);
		}
	}

}
