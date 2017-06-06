package wallet.answers;

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
/*
Given a large file that does not fit in memory (say 10GB), find the top 100000 most frequent phrases. The file has 50 phrases per line separated by a pipe (|). Assume that the phrases do not contain pipe.
Example line may look like: Foobar Candy | Olympics 2012 | PGA | CNET | Microsoft Bing ….
The above line has 5 phrases in visible region.
*/
public class TopPhrases {

	private static final int CHUNK_LIMIT = 100_000;

	static class PhraseFrequency implements Comparable {
		private String phrase;
		private Integer frequency;

		PhraseFrequency(String phrase, Integer frequency) {
			this.phrase = phrase;
			this.frequency = frequency;
		}

		@Override
		public int compareTo(Object o) {
			return this.frequency.compareTo(((PhraseFrequency) o).frequency);
		}

	}

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

	/**
	 * 100.000 top phrases - 2 bytes each - 1 char - 195kb - 100 chars = 19500kb
	 * - ~ 19MB - + counter for each: 4bytes => 390 kb
	 * 
	 * Idea: assuming worse case - file contains all unique phrases - 10gb worth
	 * - can't bring to mem we have to store on disk
	 * 
	 * partition into 100.000 phrases a lot - do stats for the first 100_000
	 * write result to disk
	 * 
	 * Merge results retaining only the top 100.000
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		System.out.println(findTopPhrasesByFrequency(file));
	}

	/**
	 * complexity - n-1 * nLogN (the sorting) 
	 * - extra space for the sorted List - max 200k per merge 
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	private static Map<String, Integer> findTopPhrasesByFrequency(File file) throws FileNotFoundException, IOException, Exception {
		Scanner in = new Scanner(file);
		in.useDelimiter("\\||\n");

		Path folder = Files.createTempDirectory("frequency-processing");

		int filesIndex = createFrequencyChunks(in, folder);

		Map<String, Integer> initial = readMap(folder.resolve(Integer.toString(1)).toFile());
		for (int i = 2; i < filesIndex; i++) {
			merge(initial, readMap(folder.resolve(Integer.toString(i)).toFile()));
			retainTop(initial);
		}
		// now we should have the top 100_000
		return initial; 
	}

	private static int createFrequencyChunks(Scanner in, Path folder) throws Exception {
		int count = 0;
		int filesIndex = 1;
		HashMap<String, Integer> frequencyMap = new HashMap<>();
		while (in.hasNext()) {
			String phrase = in.next();
			frequencyMap.merge(phrase, 1, Integer::sum);
			count++;
			if (count == CHUNK_LIMIT) {
				writeMap(frequencyMap, folder.resolve(Integer.toString(filesIndex++)));
				frequencyMap.clear();
				count = 0;
			}
		}
		if (frequencyMap.size()!=0){
			writeMap(frequencyMap, folder.resolve(Integer.toString(filesIndex++)));
		}
		return filesIndex;
	}

	private static void retainTop(Map<String, Integer> initial) {
		if (initial.size() <= CHUNK_LIMIT) {
			return;
		}
		List<PhraseFrequency> list = initial.entrySet().stream()
				.map(entry -> new PhraseFrequency(entry.getKey(), entry.getValue())).collect(Collectors.toList());
		Collections.sort(list);
		for (int i = CHUNK_LIMIT - 1; i < list.size(); i++) {
			initial.remove(list.get(i).phrase);
		}
	}

	private static void merge(Map<String, Integer> initial, Map<String, Integer> mapToMerge) {
		for (Entry<String, Integer> entry : mapToMerge.entrySet()) {
			initial.merge(entry.getKey(), entry.getValue(), Integer::sum);
		}
	}
	
	private static void writeMap(HashMap<String, Integer> frequencyMap, Path destination) throws Exception {
		Files.createFile(destination);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destination.toFile()))) {
			oos.writeObject(frequencyMap);
		}
	}

	private static Map<String, Integer> readMap(File file) throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			return (Map<String, Integer>) ois.readObject();
		}
	}
}