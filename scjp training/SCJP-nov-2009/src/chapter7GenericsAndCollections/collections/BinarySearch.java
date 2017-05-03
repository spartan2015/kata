package chapter7GenericsAndCollections.collections;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		String[] strs = {"b","d","e","a","c"};
		
		System.out.println(Arrays.toString(strs));
		
		System.out.println(Arrays.binarySearch(strs, "a") + " == not sorted - impredictable");
		
		Arrays.sort(strs);
		
		System.out.println(Arrays.toString(strs));
		
		System.out.println(Arrays.binarySearch(strs, "f") + " == -6 (should be at 5 then we substrct(-) 1)");
	}

}
