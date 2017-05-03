package console;

import java.io.Console;

public class ConsoleInput {

	
	public static void main(String[] args) {
	
		Console console = System.console();
		if (console != null){
			
			String s = console.readLine("give me the password: ",null);
			System.out.println("you entered: " + s);
			
			char[] ch = console.readPassword("give me the password now !: ");
			for(char c : ch){
				System.out.print(c);
			}
			System.out.println();
			
			
		}else{
			System.out.println("no console found");
		}

	}

}
