package sorting.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLargeFiles {
	public void largeFileSort(File file) {
		int howManyBytes = 1024 * 1024 * 10; // 10 mb - max chunk size
		List<File> tmpFiles = new ArrayList<>(); // chunks - a external files

		int bytesRead = -1;
		int prevRead = 0;
		List<String> data = null;

		do { // sort chunk by chunk
			data = new ArrayList<>();
			Collections.sort(data);
			writeToTempFile(data);

		} while ((bytesRead = loadData(file, prevRead, howManyBytes, data)) != -1);

		// n-way merge; read the smallest from all chunks - write it to
		// file...n-way merge from n sorted files

	}

	private void writeToTempFile(List<String> data) {

	}

	/**
	 * how much mem you can afford ?
	 * 
	 * @return number of bytes read
	 */
	int loadData(File file, int fromByte, int howManyBytes, List<String> collector) {
		return -1;
	}
}