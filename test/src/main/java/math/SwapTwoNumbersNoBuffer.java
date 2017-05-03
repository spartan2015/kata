package math;

public class SwapTwoNumbersNoBuffer {

	public int swap(int a, int b) {
		a = b - a; // 2 - 1 = 1
		b = b - a; // 2 - 1 = 1
		a = a + b; // 1+1 = 2
		return a;
	}

	public int swapBitUse(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		return a;
	}

}
