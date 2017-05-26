package priorityqueues;

import java.util.Stack;

import priorityqueues.BinaryHeapPriorityQueue;
import priorityqueues.PQ;
import scala.math.BigDecimal;
import sedgewick.StdIn;
import sedgewick.StdOut;

public class TopM {
	static class Transaction implements Comparable<Transaction> {
		private BigDecimal value;

		public Transaction(String valueAsString) {
			this.value = BigDecimal.valueOf(Double.parseDouble(valueAsString));
		}

		@Override
		public int compareTo(Transaction o) {
			return this.value.compare(o.value);
		}
	}

	public static void main(String[] args) { // Print the top M lines in the
												// input stream.
		int M = Integer.parseInt(args[0]);
		PQ<Transaction> pq = new BinaryHeapPriorityQueue<Transaction>(M + 1);
		
		while (StdIn.hasNextLine()) { // Create an entry from the next line and
										// put on the PQ.
			pq.insert(new Transaction(StdIn.readLine()));
			if (pq.size() > M)
				pq.remove(); // Remove minimum if M+1 entries on the PQ.
		} // Top M entries are on the PQ.
		
		
		Stack<Transaction> stack = new Stack<Transaction>();
		while (!pq.isEmpty())
			stack.push(pq.remove());
		for (Transaction t : stack)
			StdOut.println(t);
	}
}
