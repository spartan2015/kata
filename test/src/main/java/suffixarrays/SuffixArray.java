package suffixarrays;

import strings.algo.sorting.Quick3String;

/**
 * elementary implementation - good for natural languages
 * 
 * poor worse time - high repeating sequences - quadratic time
 * 
 * @author vasil
 *
 */
public class SuffixArray {
	private final String[] suffixes; // suffix array
	private final int N; // length of string (and array)

	public SuffixArray(String s) {
		N = s.length();
		suffixes = new String[N];
		for (int i = 0; i < N; i++)
			suffixes[i] = s.substring(i);
		new Quick3String().sort(suffixes);
	}

	public int length() {
		return N;
	}

	public String select(int i) {
		return suffixes[i];
	}

	public int index(int i) {
		return N - suffixes[i].length();
	}

	private static int lcp(String s, String t) {
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++)
			if (s.charAt(i) != t.charAt(i))
				return i;
		return N;
	}

	// See page page 875.
	public int lcp(int i) {
		return lcp(suffixes[i], suffixes[i - 1]);
	}

	public int rank(String key) { // binary search
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(suffixes[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
}