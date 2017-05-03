package strings.algo.sorting;

/**
 * complexity: worst case: N+R(man string)
 * average N logr N
 * @author vasil
 *
 */
public class MostSignigicantDigitGeneralPurposeStringSort {

	static final int M = 15; // cutoff for small subarrays

	int R = 256;
	String[] aux;

	public void sort(String[] a) {
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N - 1, 0);
	}

	private void sort(String[] a, int start, int end, int charIndex) {
		if (end <= start + M) {// simple sort for small arrays
			insertionSort(a, start, end, charIndex);
		}
		int[] count = new int[R+2/*!*/];
		for(int i = start; i<=end; i++){
			count[charAt(a[i],charIndex)+2/*!*/]++;
		}
		for(int r = 0; r < R+1/*!*/; r++){
			count[r+1] +=count[r];
		}
		for(int i = start; i<=end; i++){
			aux[count[charAt(a[i],charIndex)+1]++] = a[i];
		}
		for(int i = start; i<=end; i++){
			a[i] = aux[i-start];
		}
		// continue adding recursively all elements
		for(int r = 0; r < R; r++){
			sort(a, start + count[r], start + count[r+1] -1 , charIndex+1);
		}
	}

	private void insertionSort(String[] a, int start, int end, int charIndex) {
		
		int size = end - start;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (less(a, i, j, charIndex)) {
					String tmp = a[i];

					for (int x = i; x > j; x--) {
						a[i] = a[i - 1];
					}

					a[j] = tmp;

					break;
				}
			}
		}
		
	}

	private boolean less(String[] a, int i, int j, int charIndex) {
		if (charAt(a[i], charIndex) <= charAt(a[j], charIndex)) {
			return true;
		}
		return false;
	}

	static int charAt(String s, int d) {
		if (d > s.length() - 1)
			return -1;
		return s.charAt(d);
	}
}
