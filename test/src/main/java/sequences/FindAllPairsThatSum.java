package sequences;

import java.util.Arrays;

import org.junit.Test;

public class FindAllPairsThatSum {

	/**
	 * solutions:n^2 - all combinarions,  binary search - sort of nlogn; and hash search (search hash of sum - ith element) - sort of n (minus hashing which would be another n)
	 */
	// algo does not work unless particular cases like 12345 - no missing numbers in between - for symetry
	@Test
	public void test() {
		int[] array = { -5, -3, -2, -1, 0, 1, 2, 3, 4, 6, 7, 8, 9, 10 };
		// N/2 algo - with possible optimizations - find first number at most
		// equal to sum if all numbers are positive
		Arrays.sort(array);
		int targetSum = 5;
		int startIndex = 0;
		boolean hasNegatives = array[startIndex] < 0;

		while (array[startIndex] < 0 && Math.abs(array[startIndex]) * 2 < targetSum)
			startIndex++;
		int endIndex = array.length - 1;
		int maxPos = !hasNegatives ? targetSum : targetSum * 2;
		while (array[endIndex] > maxPos){
			endIndex--;
		}
			;
		// if negativses are permited
		// sum could from -x *2 - great optimizations are possible

		while (endIndex > startIndex) {
			if (array[startIndex] + array[endIndex] == targetSum) {
				System.out.println(array[startIndex] + " + " + array[endIndex] + " = " + targetSum);
				
				
			}
			startIndex++;
			endIndex--;
		}

	}

}
