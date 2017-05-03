package myexperiments;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class GenerateFile {

	@Test
	public void t1() throws Exception {

		Path path = Files.createTempFile("t" + System.currentTimeMillis(), "txt");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toAbsolutePath().toString()))) {
			for (int i = 0; i < 10_000; i++) {
				bw.write("ABCDEFGHIJKLMNOPRSTQEXZ");
				bw.write("\n");
			}
			bw.flush();
		}

		System.out.println(Files.size(path) / 1024 + " kb");
		path.toFile().deleteOnExit();
	}
	
	@Test
	public void t2(){
		String str = "\"Hello\"";
		assertEquals("Hello",str.substring(1,str.length()-1));		
	}

}
