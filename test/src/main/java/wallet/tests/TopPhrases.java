package wallet;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

public class TopPhrases {



	@Test
	public void writeBigFile() throws Exception {
		File file = Files.createTempFile("frequency-process", "txt").toFile();
		Integer size = 3_500_000;
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int i = 0; i < size; i++) {
				pw.write("PGA | CNET | Microsoft Bing\n");
			}
		}
		
		Map<String, Integer> result = findTopPhrasesByFrequency(file);
		assertTrue(result.size() == 3);
		assertEquals(size, result.get("PGA"));
		assertEquals(size, result.get("CNET"));
		assertEquals(size, result.get("Microsoft Bing"));
	}

	
}