package parsing;

public class FormatExample {

	
	public static void main(String[] args) {
		
		System.out.printf("%2$d %1$d", 1, 2);
		System.out.println();
		
		System.out.printf("%1$,f", 1234.5678);
		System.out.println();
		System.out.printf("two decimals only: %1$.2f", 1234.5678);
		System.out.println();
		System.out.printf("With the sign: %1$+,f", 1234.5678);
		System.out.println();
		System.out.printf("Negative in paranthesis%1$(,f", -1234.5678);
		System.out.println("Min digits of the field:");
		System.out.printf("%1$20.2f", -1234.5678);System.out.println();
		System.out.printf("%1$20.2f", -123.5678);System.out.println();
		System.out.printf("%1$20.2f", -12.5678);System.out.println();
		System.out.println("zero padd with min digits:");
		System.out.printf("%1$020.2f", 1234.5678);
		System.out.println();
		System.out.printf("%1$020.2f", 12.5678);
		System.out.println();
		System.out.printf("%1$020.2f", 1.5678);
		System.out.println();
	
		
		/**
		 * Generic format example: %[arg_index]$[options][width][.precision][type]
		 * types: 
		 * d - integer
		 * b - boolean
		 * f - float
		 * s - string
		 * c - char
		 * 
		 * options:
		 * + show the sign
		 * - align left
		 * ( negative numbers in paranthesis
		 * 
		 * width
		 * 20.2 - min 20 digits of witch 2 are decimals
		 * 
		 */
	}

}
