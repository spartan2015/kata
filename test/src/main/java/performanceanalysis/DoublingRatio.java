package performanceanalysis;

import math.ThreeSum;
import sedgewick.StdRandom;

/**
 * simple tool to estimate the factor of growth of computation time as N doubles
 * 
 * you can use it to experiment and find out what sort of time you would expect
 * for various N size inputs
 * 
 * @author vasil
 *
 */
public class DoublingRatio {
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-MAX, MAX);
		Stopwatch timer = new Stopwatch();
		
		int cnt = ThreeSum.count(a);
		
		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		double prev = timeTrial(125);
		for (int N = 250; true; N += N) { // as you double the input - find by
											// what order the algo computes
			double time = timeTrial(N);
			System.out.printf("%6d %7.1f ", N, time);
			System.out.printf("%5.1f\n", time / prev);
			prev = time;
		}
	}
}