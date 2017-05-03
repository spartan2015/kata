package bitwise.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloatDecimalToBinaryString {

	@Test
	public void test() {
		System.out.println(toBinaryString(3.72));
		assertEquals("11.1011", toBinaryString(3.72));
	}

	private String toBinaryString(double d) {
		StringBuilder sb = new StringBuilder();
		int intPart = (int) d;
		sb.append(convertDecimalToBinary(intPart));

		double floatPart = d - intPart;
		if (floatPart > 0) {
			sb.append(".");
			sb.append(floatPartToBinaryString(floatPart));
		}
		return sb.toString();
	}

	private String floatPartToBinaryString(double floatPart) {
		StringBuilder sb = new StringBuilder();
		int count = 4;
		while (floatPart > 0 && count > 0) {
			int intPart = (int) (floatPart * 2);
			sb.append(intPart);
			floatPart = floatPart * 2 - intPart;
			count--;
		}
		return sb.toString();
	}

	private String convertDecimalToBinary(int intPart) {
		StringBuilder sb = new StringBuilder();
		while (intPart > 0) {
			sb.append(intPart % 2);
			intPart = intPart / 2;
		}
		return sb.reverse().toString();
	}

}
