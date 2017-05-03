package java8;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureApplyToEither {

	public static void main(String[] args) {

		CompletableFuture futureA = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.currentThread().sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

		CompletableFuture timeoutTask = failAfter(Duration.ofSeconds(1));

		// first who finishes of futureA and timeoutTask
		futureA.applyToEither(timeoutTask, a -> {
			return null;
		}).thenApply(/* make sure an Optional is returned */Optional::ofNullable).exceptionally(ex -> Optional.empty())
				.join();
	}

	private static CompletableFuture failAfter(Duration ofSeconds) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
