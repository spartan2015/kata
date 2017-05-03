package test;
import java.util.Scanner;


public class TestBinaryData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "6d,00,65,00,40,00,75,00,61,00,69,00,63,00,2e,00,72,00,6f,00";
		Scanner sc = new Scanner(s);
		sc.useDelimiter(",");
		
		while(sc.hasNext()){
			Integer i = Integer.valueOf(sc.next(), 16);
			char c = (char)i.shortValue();
			System.out.println(c);
			
		}

	}

}
