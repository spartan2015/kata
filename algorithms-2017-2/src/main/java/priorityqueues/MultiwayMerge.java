package priorityqueues;



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class MultiwayMerge {
	public static void merge(Scanner[] streams) {
		int N = streams.length;
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
		for (int i = 0; i < N; i++)
			if (!streams[i].hasNextLine())
				pq.insert(i, streams[i].nextLine());

		while (!pq.isEmpty()) {
			System.out.println(pq.minKey());
			int i = pq.delMin();

			if (!streams[i].hasNextLine())
				pq.insert(i, streams[i].nextLine());
		}
	}

	public static void main(String[] args) throws Exception{
		int N = args.length;
		Scanner[] streams = new Scanner[N];
		for (int i = 0; i < N; i++)
			streams[i] = new Scanner(args[i]);
		merge(streams);
	}
}
