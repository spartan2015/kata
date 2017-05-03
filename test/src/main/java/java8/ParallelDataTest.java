package java8;

import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Test;

public class ParallelDataTest {

	public long sum(int n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i;
		}
		return sum;
	}

	public long sumWithIterator(int n) {
		return Stream.iterate(0, i -> i + 1).limit(n)
				.reduce(0, Integer::sum);
	}

	public long sumWithIteratorInParallel(int n) {
		return Stream.iterate(0, i -> i + 1).parallel()
				.limit(n).reduce(0, Integer::sum);
	}

	public long sumWithRanged(int n) {
		return LongStream.range(0, n).sum();
	}

	public long sumWithRangedInParallel(int n) {
		return LongStream.range(0, n).parallel().sum();
	}

	long testPerformance(Runnable task) {
		long start = System.currentTimeMillis();
		task.run();
		return System.currentTimeMillis() - start;
	}

	static class Accumulator {
		long sum = 0;

		synchronized void add(int v) {
			sum += v;
		}
	}

	long sumRangeWithMutableAccumulator(int n) {
		Accumulator accumulator = new Accumulator();
		IntStream.range(0, n).forEach(accumulator::add);
		return accumulator.sum;
	}

	long sumRangeWithMutableAccumulatorParallel(int n) {
		Accumulator accumulator = new Accumulator();
		IntStream.range(0, n).parallel()
				.forEach(accumulator::add);
		return accumulator.sum;
	}

	@Test
	public void test2() {
		int n = 10_000_000;
		System.out
				.println("sumRangeWithMutableAccumulator: "
						+ testPerformance(() -> {
							long result = sumRangeWithMutableAccumulator(
									n);
							System.out.println(result);
						}));

		System.out.println(
				"sumRangeWithMutableAccumulatorInParallel: "
						+ testPerformance(() -> {
							long result = sumRangeWithMutableAccumulatorParallel(
									n);
							System.out.println(result);
						}));
	}

	static class SumRecursiveTask
			extends RecursiveTask<Long> {
		int start;
		int end;

		public SumRecursiveTask(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		protected Long compute() {
			if (canWeSplit()) {
				int middle = (start + end) / 2;
				SumRecursiveTask left = new SumRecursiveTask(
						start, middle);
				left.fork();
				SumRecursiveTask right = new SumRecursiveTask(
						middle + 1, end);
				long rightResult = right.compute();
				long leftResult = left.join();
				return leftResult + rightResult;
			} else {
				return computeInternally();
			}
		}

		private long computeInternally() {
			long sum = 0;
			for (int i = start; i < end; i++) {
				sum += i;
			}
			return sum;
		}

		private boolean canWeSplit() {
			return (end - start) > 10_000;
		}
	}

	long sumWithForkJoin(int n) {
		ForkJoinPool pool = new ForkJoinPool();
		SumRecursiveTask task = new SumRecursiveTask(0, n);
		return (Long) pool.invoke(task);
	}

	static class SumNSpliterator
			implements Spliterator<Integer> {
		int start;
		int end;
		int current = 0;

		public SumNSpliterator(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public boolean tryAdvance(
				Consumer<? super Integer> action) {
			action.accept(start + current++);
			return (start + current) <= end;
		}

		@Override
		public Spliterator<Integer> trySplit() {
			if (canWeSplit()) {
				int middle = (start + end) / 2;
				SumNSpliterator left = new SumNSpliterator(
						start, middle);
				end = middle + 1;
				return left;
			}
			return null;
		}

		@Override
		public long estimateSize() {
			return end - start;
		}

		@Override
		public int characteristics() {
			return ORDERED + SIZED + SUBSIZED + NONNULL
					+ IMMUTABLE + CONCURRENT;
		}

		private boolean canWeSplit() {
			return (end - start) > 10_000;
		}

	}
	
	public long testWithSpliterator(int n){
		Stream<Integer> ints = StreamSupport.stream(new SumNSpliterator(0,  n), true);
		return ints.mapToInt(i->i).sum();
	}

	@Test
	public void test() {
		int n = 10_000_000;
		System.out.println(
				"with for: " + testPerformance(() -> {
					sum(n);
				}));

		System.out.println(
				"Stream.iterate: " + testPerformance(() -> {
					sumWithIterator(n);
				}));

		System.out.println("Stream.iterate in parallel: "
				+ testPerformance(() -> {
					sumWithIteratorInParallel(n);
				}));

		System.out.println(
				"Stream.range " + testPerformance(() -> {
					sumWithRanged(n);
				}));

		System.out.println("Stream.range in parallel"
				+ testPerformance(() -> {
					sumWithRangedInParallel(n);
				}));
	}

}
