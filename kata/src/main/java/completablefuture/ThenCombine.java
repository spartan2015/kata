package completablefuture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.junit.Test;

public class ThenCombine {

    /**
     * parallel task - then combine results
     *
     * @throws Exception
     */
    @Test
    public void test_then_combine_async() throws Exception {
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(simulatedTask(3, "combine all"));

        CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(simulatedTask(2, "task results"));

        CompletableFuture<String> combined = firstTask.thenCombineAsync(secondTask, (f, s) -> f + " " + s);

        assertThat(combined.get(), is("combine all task results"));
    }


    /**
     * sequential tasks - output from first becomes input for second
     *
     * @throws Exception
     */
    @Test
    public void test_then_compose_async() throws Exception {
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(simulatedTask(3, "combine all"));

        // the result of first task
        CompletableFuture<String> composedResult = firstTask.thenComposeAsync((s) -> CompletableFuture.supplyAsync(simulatedTask(4, "and " + s)));

        assertThat(composedResult.get(), is("combine all task results"));
    }

    /**
     * sequential tasks - output from first becomes input for second
     *
     * @throws Exception
     */
    @Test
    public void testThenApplyAsync() throws Exception{
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(simulatedTask(1, "first"));

        CompletableFuture<String> applyAsyncResult = firstTask.thenApplyAsync(s->s+ simulatedTask(2,"second").get());

        assertThat(applyAsyncResult.get(), is("firstsecond"));

    }

    private <T> Supplier<T> simulatedTask(int i, T object){
        System.out.println("task: " + i + " in thread id: " + Thread.currentThread().getId());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ()-> object;
    }
}
