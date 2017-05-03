package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by Battlestar on 2/12/2015.
 */
public class CompletableFutureTest {

    @Test
    public void test(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        new Thread(()->{
            completableFuture.complete("str");
        }).start();

        try {

            System.out.println(completableFuture.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // same asL
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->"done");
        try {
            System.out.println(cf.get()); // WILL EXECUTE - observe no thread or thread poool was ewxplicit- it;s a fork/join framework
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t(){
        List<String> shops = Arrays.asList("1","2","3");

        // paralel with stream
        List<String> results = shops.parallelStream().map(s-> s).collect(Collectors.toList());

        // SAME performance as ComposableFuture.supplyAsync
        // paralele with Composable

        // you can pass an executor with Composable
        ExecutorService executorService = Executors.newFixedThreadPool(100, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                thread.setDaemon(true);
                return thread;
            }
        });

        List<CompletableFuture<String>> shopComposables =  shops.stream().map((s)-> CompletableFuture.supplyAsync(()->s,executorService)).collect(Collectors.toList());

        List<String> result = shopComposables.stream().map(CompletableFuture::join).collect(Collectors.toList());


        // combine completable futures - one after another in a stream
        List<CompletableFuture<Void>> li = shops.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> s))
                .map(cf -> cf.thenApply(s -> s + "1"))
                .map(cf -> cf.thenCompose((s) -> CompletableFuture.supplyAsync(() -> s + "2")))
                .map(cf->cf.thenAccept(System.out::println))
                .collect(Collectors.toList());
        li.stream().map(cf->cf.join());

        // the COmbine - in paralele
        CompletableFuture<String> paralelExecutionAndThenCombining =CompletableFuture.supplyAsync(() -> "1").thenCombine(CompletableFuture.supplyAsync(()->"2"), (s1,s2)->s1+s2);
        String resultCom = paralelExecutionAndThenCombining.join();

    }


}
