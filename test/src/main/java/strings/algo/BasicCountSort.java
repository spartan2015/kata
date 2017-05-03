package strings.algo;

import org.junit.Test;

/**
 * KeyIndexed counting 
 * fundamental to string sorting - also usefull for age based sorting or any small integer - that can be used as key 
 * @author vasil
 *
 */
public class BasicCountSort {

	@Test
	public void test() {
		// sorting using the size property of the string
		String[] strs = { "a", "ab", "abc" };

		// N
		 // we assumen at most every string
											// is a unique size in this case -
											// which may not be the case
		int[] count = new int[strs.length + 1];
		for (String s : strs) {
			int computedIndex = s.length()+1; // NOTICE the +1 - the first has to start from 0 always for sort to work;
			count[computedIndex]++;
		}
		
		// transform count to indices start
		// R complexity - 2 reads + 1 write - so kinda of 3 R
		for (int r = 0; r < strs.length - 1; r++) { // the radix R could me much
													// smaller - alphabet radix
													// can lead to more
													// efficient implementations
													// here
			count[r + 1] += count[r];
		}

		// use this to sort the initial array of strings - stable sort - one
		// pass sort - efficient sort - N size - not quadratic or like any
		// previous sorting algos n log n type
		String[] sorted = new String[strs.length];
		// N - 1 write + N read + N write
		for (String s : strs) {
			sorted[count[s.length()]++] = s;
		}
	}

}
