package hackerRank.implementation;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.junit.Test;

/**
 * Consider two sets of positive integers,  and . We say that a positive integer, , is between sets  and  if the following conditions are satisfied:

All elements in  are factors of .
 is a factor of all elements in .
Given  and , find and print the number of integers (i.e., possible 's) that are between the two sets.

 * @author vasil
 *
 */
public class BetweenTwoSets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
		}
		
		int count = factorsBetween(a, b);
		System.out.println(count);
	}

	@Test
	public void test(){
		assertTrue(3 == factorsBetween(new int[]{2, 4}, new int[]{16,32,96}));
	}
	
	@Test
	public void test2(){
		assertTrue(3 == factorsBetween(new int[]{3, 9, 6}, new int[]{36,72}));
	}
	
	private static int factorsBetween(int[] a, int[] b) {
		int count = 0;
		Map<Integer, Integer> factors = new HashMap<>();
		for (int k : a) {
			for (Entry<Integer, Integer> entry : decompose(k).entrySet()) {
				factors.merge(entry.getKey(), entry.getValue(), Integer::max);
			}
		}
		int cParent = factors.entrySet().stream().reduce(1,
				(s, entry) -> s * (int) Math.pow(entry.getKey(), entry.getValue()), (s1, s2) -> s1 * s2);

		for (int i = 1; i * cParent <= b[0]; i++) {
			boolean factorOf = true;
			for (int k : b) {
				if (k % (i * cParent) != 0) {
					factorOf = false;
				}
			}
			if (factorOf){
				count++;
			}
		}
		return count;
	}

	private static Map<Integer, Integer> decompose(int k) {
		Map<Integer, Integer> dec = new HashMap<>();
		boolean found = false;
		for (int i = 2; i <= k; i++) {
			while (k % i == 0) {
				k /= i;
				dec.merge(i, 1, Integer::sum);
				found = true;
			}
		}
		if (!found){
			dec.put(k,1);
		}
		return dec;
	}
}
