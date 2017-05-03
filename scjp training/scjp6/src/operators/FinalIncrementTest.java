package operators;

public class FinalIncrementTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int i = 1;
		//i++; // will never compile: The final local variable i cannot be assigned. It must be blank and not using a compound assignment

	}

}
