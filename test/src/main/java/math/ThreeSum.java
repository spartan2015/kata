package math;

public class ThreeSum {
	public static int count(int[] a) { // Count triples that sum to 0.
		int N = a.length;
		int cnt = 0;
		// Complexiy N(N-1)(N-2)/6=N^3/6 -N^2/2+ N/3 - aproximates N^3 (tilde
		// aproximation - throwing away lower level powers with neglijibile
		// impact)
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static int countFast(int[] a) { // Count triples that sum to 0.
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		// ~N^2*logN
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				if (BinarySearch.rank(-a[i] - a[j], a) > j)
					cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		// int[] a = In.readInts(args[0]);
		// StdOut.println(count(a));
	}
}
