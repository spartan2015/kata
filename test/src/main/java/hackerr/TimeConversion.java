package hackerRank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
	public static void main(String[] args) {
		//System.out.println(convert(new Scanner(System.in).nextLine()));
		
		System.out.println(convert("07:05:45PM"));
	}

	private static String convert(String string) {
		LocalTime lt = LocalTime.parse(string, DateTimeFormatter.ofPattern("hh:mm:ssa"));
		return lt.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
