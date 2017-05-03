package test.strings;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.util.function.ToIntFunction;

import org.junit.Test;

import sedgewick.StdDraw;

public class StringSizeInBytesFunctionTest {

	private static final int MAX_SIZE = 1026;

	class NextLine {
		int prev = 0;
		Color penColor;

		NextLine(Color penColor) {
			this.penColor = penColor;
		}

		public void draw(int N, int newVal) {
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
			StdDraw.point(N, newVal);
			StdDraw.setPenColor(penColor);
			StdDraw.line(N - 1, prev, N, newVal);

			prev = newVal;
		}

	}

	@Test
	public void main() {
		StringBuilder sb = new StringBuilder();

		StdDraw.setXscale(0, MAX_SIZE);
		StdDraw.setYscale(0, MAX_SIZE);
		StdDraw.setPenRadius(.005);

		NextLine line1 = new NextLine(StdDraw.RED);
		NextLine line2 = new NextLine(StdDraw.GREEN);

		NextLine digitGroupsLine = new NextLine(StdDraw.GREEN);

		ToIntFunction<String> f1 = (string) -> {
			int digitGroups = (int) (Math.log10(string.length()) / Math.log10(1024));
			return (int) (string.length() / Math.pow(1024, digitGroups));
		};

		ToIntFunction<String> f2 = (string) -> {
			try {
				return string.getBytes("UTF-8").length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return 0;

		};

		for (int i = 0; i < MAX_SIZE; i++) {
			sb.append("a");

			String string = sb.toString();

			int f1Result = f1.applyAsInt(string);
			line1.draw(i, f1Result);
			int f2Result = f2.applyAsInt(string);
			line2.draw(i, f2Result);

			System.out.println(f1Result + " ---  " + f2Result);

		}

		System.out.println("end");

	}

	@Test
	public void test2() {

		NextLine digitGroupsLine = new NextLine(StdDraw.GREEN);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < MAX_SIZE; i++) {
			sb.append("a");
			String string = sb.toString();

			
			double log10StrLength = Math.log10(string.length());
			double log101024 = Math.log10(1024);
			
			int digitGroups = (int) (log10StrLength / log101024 );

			double pow1024 = Math.pow(1024, digitGroups);
			
			int result = (int) (string.length() / pow1024);
			
			
			System.out.println(string.length() + " / Math.pow(1024, (" + log10StrLength + " / " + log101024 + ")) => where Math pow is + " + pow1024  + " with result " + result);

		}

		System.out.println("end");

	}

}
