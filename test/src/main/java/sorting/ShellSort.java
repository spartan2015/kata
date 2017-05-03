package sorting;

public class ShellSort {

	public static void sort(Comparable[] arrayToSort) { // Sort a[] into increasing order.
		int numberOfElements = arrayToSort.length;
		int h = 1;
		h = incrementToClosestNumberUnderAThirdOfTheNumberOfElements(numberOfElements, h);
		while (h >= 1) { // h-sort the array.
			for (int i = h; i < numberOfElements; i++) { // Insert a[i] among a[i-h], a[i-2*h],
											// a[i-3*h]... .
				for (int j = i; j >= h && less(arrayToSort[j], arrayToSort[j - h]); j -= h)
					exch(arrayToSort, j, j - h);
			}
			h = h / 3;
		}
	}

	private static int incrementToClosestNumberUnderAThirdOfTheNumberOfElements(int numberOfElements, int h) {
		while (h < numberOfElements / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		return h;
	}
	
	private static boolean less(Comparable first, Comparable second) {
		return first.compareTo(second) < 0;
	}

	private static void exch(Comparable[] arrayToSort, int j, int i) {
		Comparable tmp = arrayToSort[j];
		arrayToSort[j]=arrayToSort[i];
		arrayToSort[i]=tmp;
		
	}

}
