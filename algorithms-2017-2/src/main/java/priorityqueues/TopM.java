package priorityqueues;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

import priorityqueues.BinaryHeapPriorityQueue;
import priorityqueues.PQ;

public class TopM {
	static class Transaction implements Comparable<Transaction> {
		private BigDecimal value;

		public Transaction(String valueAsString) {
			this.value = BigDecimal.valueOf(Double.parseDouble(valueAsString));
		}

		@Override
		public int compareTo(Transaction o) {
			return this.value.compareTo(o.value);
		}
	}

	public static void main(String[] args) { // Print the top M lines in the
												// input stream.
		Scanner in = new Scanner(System.in);
		int M = Integer.parseInt(args[0]);
		PQ<Transaction> pq = new BinaryHeapPriorityQueue<Transaction>(M + 1);
		
		while (in.hasNextLine()) { // Create an entry from the next line and
										// put on the PQ.
			pq.insert(new Transaction(in.nextLine()));
			if (pq.size() > M)
				pq.remove(); // Remove minimum if M+1 entries on the PQ.
		} // Top M entries are on the PQ.
		
		
		Stack<Transaction> stack = new Stack<Transaction>();
		while (!pq.isEmpty())
			stack.push(pq.remove());
		for (Transaction t : stack)
			System.out.println(t);
	}
}
