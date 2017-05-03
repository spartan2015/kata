package combinatorics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Permutations {
	
	@Test
	public void test(){
		permutations(new String[]{"a","b","c","d"}).forEach(arr->{
			System.out.println(Arrays.toString(arr));
		});
	}

	@Test
	public void testPermutationBottomUp(){
		permutationsBottomUp(new String[]{"a","b","c","d"}).forEach(arr->{
			System.out.println(Arrays.toString(arr));
		});
	}
	
	public List<Object[]> permutations(Object[] original){
		return permutations(original, original.length-1);
	}

	private List<Object[]> permutationsBottomUp(Object[] original){
		List<Object[]> permutations = new LinkedList<>();
		permutations.add(new Object[]{original[0]});
		int start = 1;
		while(start < original.length){
			permutations.forEach(arr->{
				System.out.println(Arrays.toString(arr));
			});
			List<Object[]> newPermutations = new LinkedList<>();
			for(Object[] permutation : permutations){
				newPermutations.addAll(combine(permutation, original[start]));
			}
			permutations = newPermutations;
			start++;
		}
		return permutations;
	}

	
	private List<Object[]> permutations(Object[] original, int upTo){
		List<Object[]> permutations = new LinkedList<>();
		if (upTo==0){
			permutations.add(new Object[]{original[0]});
			return permutations;
		}

		for(Object[] permutation : permutations(original, upTo-1)){
			permutations.addAll(combine(permutation, original[upTo]));
		}
		return permutations;
	}

	private List<Object[]> combine(Object[] vector, Object newElement) {
		List<Object[]> permutations = new LinkedList<>();
		int newSize = vector.length + 1;
		for(int i = 0; i < newSize; i++){
			Object[] newPermutation = new Object[newSize];
			newPermutation[i] = newElement;
			addVector(vector, newSize, i, newPermutation);
			permutations.add(newPermutation);
		}
		return permutations;
	}

	private void addVector(Object[] original, int newSize, int i, Object[] newPermutation) {
		int n = 0;
		for(int j = 0; j < newSize; j++ ){
			if (j==i) continue;
			else{
				newPermutation[j] = original[n++];
			}
		}
	}
}
