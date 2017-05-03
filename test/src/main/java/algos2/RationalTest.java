package algos2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RationalTest {

	@Test
	public void t1() {

		Rational r = new Rational(1, 2);
		r = r.plus(new Rational(2, 3));

		assertTrue(r.numerator == 7);
		assertTrue(r.denominator == 6);

	}
	
	@Test
	public void t11() {

		Rational r = new Rational(Long.MAX_VALUE, Long.MAX_VALUE -1 );
		r = r.plus(new Rational(Long.MAX_VALUE, Long.MAX_VALUE -1 ));

		assertTrue(r.numerator == 7);
		assertTrue(r.denominator == 6);

	}

	@Test
	public void t2() {

		Rational r = new Rational(1, 2);
		r = r.plus(new Rational(3, 4));

		assertTrue(r.numerator == 5);
		assertTrue(r.denominator == 4);

	}

	@Test
	public void t3() {

		Rational r = new Rational(1, 2);
		r = r.minus(new Rational(1, 4));

		assertTrue(r.numerator == 1);
		assertTrue(r.denominator == 4);

	}

	@Test
	public void multiplcation1() {

		Rational r = new Rational(1, 2);
		r = r.multiplication(new Rational(3, 4));

		assertTrue(r.numerator == 3);
		assertTrue(r.denominator == 8);

	}

	@Test
	public void multiplcation2() {

		Rational r = new Rational(1, 2);
		r = r.multiplication(new Rational(1, 2));

		assertTrue(r.numerator == 1);
		assertTrue(r.denominator == 4);

	}

	@Test
	public void division() {

		Rational r = new Rational(1, 2);
		r = r.devision(new Rational(1, 2));

		assertTrue(r.numerator == 1);
		assertTrue(r.denominator == 1);

	}
}

class Rational {

	final long numerator;
	final long denominator;

	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
		System.out.println(this.numerator + "/" + this.denominator);
	}

	private long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	Rational plus(Rational other) {
		multiplicationOverflowTest(this.numerator, other.denominator);
		multiplicationOverflowTest(other.numerator, this.denominator);
		additionOverflowTest(this.numerator * other.denominator, other.numerator * this.denominator);
		multiplicationOverflowTest(this.denominator, other.denominator);
		return new Rational(this.numerator * other.denominator + other.numerator * this.denominator,
				this.denominator * other.denominator);
	}

	private void additionOverflowTest(long a, long b) {
		if (Long.MAX_VALUE - a < b) {
			throw new RuntimeException(a + "+" + b + " > Long.MAX_VALUE");
		}
	}

	private void substractionOverflowTest(long a, long b) {
		if (b < Long.MIN_VALUE + a) {
			throw new RuntimeException(a + "-" + b + " < Long.MIN_VALUE");
		}
	}

	private void multiplicationOverflowTest(long a, long b) {
		if (Long.MAX_VALUE / a < b) {
			throw new RuntimeException(a + "*" + b + " > Long.MAX_VALUE");
		}
	}

	Rational minus(Rational other) {
		multiplicationOverflowTest(this.numerator, other.denominator);
		multiplicationOverflowTest(other.numerator, this.denominator);
		multiplicationOverflowTest(this.denominator, other.denominator);
		substractionOverflowTest(this.numerator * other.denominator, other.numerator * this.denominator);
		return new Rational(this.numerator * other.denominator - other.numerator * this.denominator,
				this.denominator * other.denominator);
	}

	Rational multiplication(Rational other) {
		multiplicationOverflowTest(this.numerator, other.numerator);
		multiplicationOverflowTest(other.denominator, this.denominator);
		return new Rational(this.numerator * other.numerator, other.denominator * this.denominator);
	}

	Rational devision(Rational other) {
		multiplicationOverflowTest(this.numerator, other.denominator);
		multiplicationOverflowTest(this.denominator, other.numerator);
		return new Rational(this.numerator * other.denominator, this.denominator * other.numerator);
	}
}
