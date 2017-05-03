package java8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

/**
 * 
 * Cert java 8
 * 
 * @author vasilei
 *
 */
public class ExecutorsTest {

	@Test
	public void basic() {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadExecutor();

			Runnable task = () -> {
				printCurrentThreadName();
			};
			
			// execute()
			// Fire & Forget
			executorService.execute(task);

			// - submit runnable
			Future<?> futureResultFromRunnableGetReturnsNullOnSuccess = executorService.submit(task);
			// isDone - returns true if task was completed, aborted or threw an Exception
			boolean isDone = futureResultFromRunnableGetReturnsNullOnSuccess.isDone();
			// isCancelled
			boolean isCancelled = futureResultFromRunnableGetReturnsNullOnSuccess.isCancelled();
			// cancel(boolean)
			boolean mayInterruptIfRunning = true;
			futureResultFromRunnableGetReturnsNullOnSuccess.cancel(mayInterruptIfRunning);
			
			// get() throws InterruptedException, ExecutionException
			try {
				Object result = futureResultFromRunnableGetReturnsNullOnSuccess.get();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
			// get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
			try {
				Object result = futureResultFromRunnableGetReturnsNullOnSuccess.get(1, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			} catch (TimeoutException e1) {
				e1.printStackTrace();
			}
			
			
			// - submit callable
			Callable<String> callable = () -> printCurrentThreadName();
			Future<?> futureResultFromCallable = executorService.submit(callable);

			// - invokeAll
			// executed the given tasks synchronously
			List<Callable<String>> taskList = Arrays.asList(callable, callable);
			try {
				List<Future<String>> list = executorService.invokeAll(taskList);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// - invokeAny - synch call
			// returns the first the finishes canceling others
			try {
				executorService.invokeAny(taskList);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		} finally {
			if (executorService != null) {
				/**
				 * Initiates an orderly shutdown in which previously submitted
				 * tasks are executed, but no new tasks will be accepted.
				 * Invocation has no additional effect if already shut down.
				 * 
				 * This method does not wait for previously submitted tasks to
				 * complete execution. Use awaitTermination to do that.
				 * 
				 * shutdown returns before the executor finishes submitted tasks
				 * 
				 * if you do not shutdown the process never ends.
				 */
				executorService.shutdown();

				// awaitTermination(long timeout, TimeUnit unit)
				try {
					executorService.awaitTermination(1, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/**
				 * forced shutdown - attempts aborting of running tasks,
				 * discards previously sumitted tasks
				 */
				executorService.shutdownNow();
			}
		}
	}

	private String printCurrentThreadName() {
		String result = "Thread:" + Thread.currentThread().getName();
		System.out.println(result);
		return result;
	}

}
