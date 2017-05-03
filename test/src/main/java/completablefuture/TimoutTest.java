package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

public class TimoutTest {

	@Test
	public void t() {

		Supplier<Integer> priceFinder = () -> 1;
		Supplier<Integer> exchangeRate = () -> 2;

		CompletableFuture<Integer> exchangeRateAsync = CompletableFuture.supplyAsync(exchangeRate);
		CompletableFuture<Integer> priceFinderAsync = CompletableFuture.supplyAsync(priceFinder);

		BiFunction<Integer,Integer,Integer> biFuncCombiner = (i1, i2) -> i1 * i2;

		CompletableFuture<Integer> timeoutAfter = timeoutAfter(1, TimeUnit.SECONDS);
		Consumer<Integer> consumerAction = System.out::println;
		
		// first to complete will takes this chain forward to consumer action
		// pattern replaced in Java 9 by 2 methods added to CompletableFuture:
		//public CompletableFuture<T> orTimeout(long timeout, TimeUnit unit)
		//public CompletableFuture<T> completeOnTimeout(T value, long timeout, TimeUnit unit)
		priceFinderAsync.thenCombine(exchangeRateAsync, biFuncCombiner).acceptEither(timeoutAfter,
				consumerAction);

	}

	private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

	public <T> CompletableFuture<T> timeoutAfter(long timeout, TimeUnit unit) {
		CompletableFuture<T> result = new CompletableFuture<>();
		scheduledThreadPool.schedule(() -> result.completeExceptionally(new TimeoutException()), timeout, unit);
		return result;
	}

}
