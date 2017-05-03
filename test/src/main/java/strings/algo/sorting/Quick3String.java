package strings.algo.sorting;

/**
 * better than MSD sort - in space and time
 * 
 * no extra space la msd
 * 
 * could benefit from small subarray optimization with insertion sort
 * 
 * could benefit from Alphabet optimization - for different alphabets
 * replacing chartAt with alpha.toIndex(s.charAt(charIndex));
 * 
 * shuffling would help - as with the other quick sort algo
 * 
 * Performance: N * stringLengh + 2 N ln N
 * Average: ~2NlnN comparisions
 * 
 * No dependncy on the size of the alphabet
 * 
 * @author vasil
 *
 */
public class Quick3String {

	public void sort(String[] a){
		sort(a,0,a.length-1,0);
	}
	
	private void sort(String[] a, int start, int end, int charIndex) {
		if (end <= start) return;
		int lt = start;
		int gt = end;
		
		int v = charAt(a[start],charIndex);
		int i = start + 1;
		while(i <= gt){
			int t = charAt(a[i],charIndex);
			if (t < v) swap(a, lt++, i++);
			else if (t > v) swap(a, i, gt--);
			else i++;
		}
		
		sort(a, start, lt-1, charIndex);
		if (v >= 0){
			sort(a, lt, gt, charIndex+1);
		}
		sort(a, gt+1, end, charIndex);
	}

	private void swap(String[] a, int i, int j) {
		String tmp = a[i];
		a[i]=a[j];
		a[j] = tmp;
	}

	static int charAt(String s, int d) {
		if (d > s.length() - 1)
			return -1;
		return s.charAt(d);
	}
	
}
