package formatting;

public class Formatting {

	
	public static void main(String[] args) {
		
		//%[arg_index$][flags][width][.precision]conversion char
		
		System.out.printf("%d %s %b %(f %c", 1,"a",true,-1.1,'c');
		
		System.out.println();
		// 2. parameters order with : %1$f
		System.out.printf("%2$d %1$d", 1, 2);
		
		System.out.println();
		// 3. width
		System.out.printf("%2$5d %1$5d", 1, 2);

		System.out.println();
		// 3. width + precision
		System.out.printf("%2$5.2f %1$5.2f", 1.0, 2.0);
		
		// flags:
		/*
		- left justify
		 */
		System.out.println();
		System.out.printf("%2$-5.2f %1$-5.2f", 1.0, 2.0);
		
		// flags:
		/*
		+ include a sign
		 */
		System.out.println();
		System.out.printf("%2$+5.2f %1$+5.2f", 1.0, 2.0);
		// flags:
		/*
		0 padd with zero
		 */
		System.out.println();
		System.out.printf("%2$05.2f %1$05.2f", 1.0, 2.0);
		// flags:
		/*
		, locale specific separators
		 */
		System.out.println();
		System.out.printf("%2$,5.2f %1$,5.2f", 1.0, 2.0);
		// flags:
		/*
		( enclose negative numbers in paranthesis
		 */
		System.out.println();
		System.out.printf("%2$(10.2f %1$(10.2f", 1.0, -2.0);
		
	}

}
