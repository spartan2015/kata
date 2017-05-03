package algos2;

import sedgewick.StdDraw;
import sedgewick.StdOut;
import sedgewick.StdRandom;

public class VisualAccumulator {

	private double total;
	private int N;
	private double previous;
	private double previousMean;

	public VisualAccumulator(int trials, double max) {
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.005);
	}

	public static void main(String[] args) {
		int T = 100;//Integer.parseInt(args[0]);
		VisualAccumulator a = new VisualAccumulator(T, 1.0);
		for (int t = 0; t < T; t++)
			a.addDataValue(StdRandom.random());
		StdOut.println(a);
	}

	public void addDataValue(double val) {
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.line(N-1, previous, N, val);
		
		StdDraw.setPenColor(StdDraw.RED);
		
		double currentMean = total / N;		
		StdDraw.point(N, currentMean);		
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.line(N-1, previousMean, N, currentMean);
		
		previous = val;
		previousMean =  currentMean;
		
	}

	public double mean() {
		return total / N;
	}

	public String toString() {
		return "Mean (" + N + " values): " + String.format("%7.5f", mean());
	}
}