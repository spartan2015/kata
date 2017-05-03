package iowithstrings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class IoWithString {
	public static void main(String[] args) {

		File file = new File("test.txt");

		try {
			FileWriter fw = new FileWriter(file); // creates A NEW (always) file
													// & a FileWriter object -
													// throws IOException

			fw.write("bunica e pe camp"); // throws IOException

			fw.flush(); // throws IOException
			fw.close(); // throws IOException

			FileReader fr = new FileReader(file); // throws
													// FileNotFoundException
													// extends IOException

			int ch = 0;

			while ((ch = fr.read()) > 0) { // throws IOException
				System.out.print((char) ch);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		File dir = new File("xdir");
		dir.mkdir(); // interestingly enough - no exception here

		// create a file in a subdir

		File f = new File(dir, "new file.txt");
		
		try {
			f.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		boolean deleted = dir.delete(); // no exception
		System.out.println("deleted: " + deleted); // youn cna't delete a dir unless it's empty
		
		f.renameTo(new File("nu")); // no exception on renameing, creating or deleteing a dir;
	}
}
