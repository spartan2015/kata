package bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalStringToBinary {

	@Test
	public void test() {
		assertEquals("10", decimalStringToBinary("2"));

		assertEquals("101110100", decimalStringToBinary("372"));
	}

	private String decimalStringToBinary(String string) {
		int n = Integer.valueOf(string);
		return decimalToBinary(n);
	}

	private String decimalToBinary(int n) {
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(n % 2);
			n = n / 2;
		} while (n > 0);
		return sb.reverse().toString();
	}

	private String decimalToBinaryVersion2(int n) {
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(n % 2);
			n >>= 1;
		} while (n > 0);
		return sb.reverse().toString();
	}

	public String convertDoubleDecimalStringToBinary(String number) {
		return decimalToBinary(Integer.parseInt(number.substring(0, number.indexOf(".")))) + "."
				+ convertDoubleDecimalStringToBinary(number.substring(number.indexOf(".")));
	}

	public String convertDoubleDecimalToBinary(String floatingPointNumberString) {
		if (floatingPointNumberString.length() > 32)
			return "ERROR";
		return convertDoubleDecimalToBinary(Double.parseDouble(floatingPointNumberString));
	}

	public String convertDoubleDecimalToBinary(double floatingPointNumber) {
		StringBuilder sb = new StringBuilder();
		while (floatingPointNumber > 0) {
			if (floatingPointNumber == 1) {
				sb.append(1);
				break;
			}
			double r = floatingPointNumber * 2;
			if (r >= 1) {
				sb.append(1);
				floatingPointNumber = r - 1;
			} else {
				sb.append(0);
				floatingPointNumber = r;
			}
		}
		return sb.toString();
	}
}