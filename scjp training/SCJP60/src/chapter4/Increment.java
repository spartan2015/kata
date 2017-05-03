package chapter4;

public class Increment {

	
	public static void main(String[] args) {
		int i = 0;
		System.out.println("" + i++ + " " + i);

		// YOU CAN NOT user ++ -- on a FINAL -  COMPILER ERROR
		final int y = 5;
		y++; // COMPILER ERROR
	}

}
