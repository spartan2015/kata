package java8.second;

import algos.Utils;
import lombok.Data;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by Battlestar on 2/23/2015.
 */
public class CompletableFuturesTest {

    public static void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Data
    static class Shop {
        String name;

        Shop() {
        }

        Shop(String n) {
            name = n;
        }

        public int getPrice() {
            delay();
            return ThreadLocalRandom.current().nextInt(2, 100);
        }

        public Future<Integer> getPriceAsyncSimple() {
            CompletableFuture future = new CompletableFuture();
            new Thread(() -> {
                try {
                    future.complete(getPrice());
                    System.out.println("done: " + name);
                } catch (Exception ex) {
                    future.completeExceptionally(ex);
                }
            }).start();

            return future;
        }

        public Future<Integer> getPriceAsync() {
            return CompletableFuture.supplyAsync(() -> {
                return getPrice();
            });
        }
    }

    List<Shop> shops = new ArrayList() {
        {
            add(new Shop("a"));
            add(new Shop("b"));
            add(new Shop("c"));
            add(new Shop("d"));
            add(new Shop("e"));
        }
    };

    @Test
    public void t() {


        // don't do sequential
        Utils.cron("seq", () -> {
            shops.stream().map(s -> s.getPrice()).collect(Collectors.toList());
        });

        // alternative 1
        Utils.cron("async Future", () -> {
            List<Future> futurePrices = shops.stream().map(s -> s.getPriceAsync()).collect(Collectors.toList());
        });

        // alternative 2
        Utils.cron("paralel Stream", () -> {
            List<Integer> prices = shops.parallelStream().map(Shop::getPrice).collect(Collectors.toList());
        });

        // alternative 3 - no async in Shop
        Utils.cron("ALL paralel Stream create completable on the spot", () -> {
            List<CompletableFuture<Integer>> futurePrices = shops.parallelStream().map(s -> CompletableFuture.supplyAsync(() -> {
                return s.getPrice();
            })).collect(Collectors.toList());

            // MUST BE PARALLEL
            //ALL
            List<Integer> prices = futurePrices.parallelStream().map(CompletableFuture::join).collect(Collectors.toList());
        });

        // FIND ANY - first one wins
        Utils.cron("firstPrice Stream create completable on the spot", () -> {
            Integer firstPrice = shops.parallelStream().map(s -> CompletableFuture.supplyAsync(() -> {
                return s.getPrice();
            })).map(CompletableFuture::join).findAny().orElse(-1);

        });



        CompletableFuture any = CompletableFuture.supplyAsync(()->"");

        try {

            Object result1 = any.get();

            any.get(100, TimeUnit.DAYS); // timeoutException

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Object result2 = any.getNow("default");

        int depNo = any.getNumberOfDependents(); // how many other futures must complete before this must complete

        boolean complete = any.complete("withValue");
        any.obtrudeValue("");
        /**
         * Forcibly causes subsequent invocations of method get() and related methods to throw the given exception, whether or not already completed.
         */
        any.obtrudeException(new NullPointerException());

        CompletableFuture c20 = any.completedFuture("def value"); // return a future completed with the def value



        // COMBINE
        /**
         * All of - returns whenn all the futures are complete         *
         */
        CompletableFuture all = CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> "firstService"),
                CompletableFuture.supplyAsync(() -> "firstService"),
                CompletableFuture.supplyAsync(() -> "firstService")
        );

        /**
         * Any of - returns whenn all the futures are complete         *
         */
        CompletableFuture any1 = CompletableFuture.anyOf(
                CompletableFuture.supplyAsync(() -> "firstService"),
                CompletableFuture.supplyAsync(() -> "firstService"),
                CompletableFuture.supplyAsync(() -> "firstService")
        );



        // ====================>RUN then RUN som action


        // run the runnable after c1 is complete
        CompletableFuture c17 = any.thenRun(()->{});

        CompletableFuture c10 = any.runAfterBoth(CompletableFuture.supplyAsync(()->{ return ""; }), ()->{String s = "run after both future are COMPLETE";});

        CompletableFuture c11 = any.runAfterEither(CompletableFuture.supplyAsync(()->{ return ""; }), ()->{String s = "run after EITHER future are COMPLETE";});




       // ====================>FUNCTION  then execute FUNCTION in another completable future with result from prev
        /**
         * Returns a new CompletionStage that, when this stage completes normally, is executed with this stage's result as the argument to the supplied function.
         */
        CompletableFuture c14 = any.thenApply(/*function*/(one) -> {
            return "third";
        });
        any = CompletableFuture.supplyAsync(() -> "firstService")
                .applyToEither(CompletableFuture.supplyAsync(() -> "secondRedundancyServcer"), (param) -> "result"); // Function
        /*
        * same as then apply only this time YOU BUILD THE COMPOSABLE as return
        *
        * when c1 completes creates using a function with the result as param creates a new completable future
        * */
        //CompletableFuture c16 = any.thenCompose(/*Function*/(result)-> CompletableFuture.supplyAsync(()->{ return "a"; }));

        /* wait for both to finish and apply result to bi function*/
        CompletableFuture c15 = any.thenCombine(CompletableFuture.supplyAsync(()->""),/*bi function*/(first, second) -> {
            return "third";
        });
        /**
         * if this throws exception then the function as param is executd in another CompletableFuture - if executes normal the function is not executed
         *
         * Returns a new CompletableFuture that is completed when this CompletableFuture completes, with the result of the given function of the exception triggering this CompletableFuture's completion when it completes exceptionally; otherwise, if this CompletableFuture completes normally, then the returned CompletableFuture also completes normally with the same value.
         *
         */
        CompletableFuture c21 = any.exceptionally((fun)->"");
        /**
         * executes future and the result and expcetion are passed to a function executed in another completable future
         */
        CompletableFuture executeFunctionAfter = any.handle((result, exception) -> "result");




        // ============== > CONSUMER -  then execute a CONSUMER in another compeltable future

        CompletableFuture c12 = any.thenAccept((consumeMer)->{});

        CompletableFuture c13 = any.thenAcceptBoth(CompletableFuture.supplyAsync(()->""), /*bi consumer*/(first,second)->{});

        /**
         * Returns a new CompletionStage with the same result or exception as this stage, and when this stage completes, executes the given action with the result (or null if none) and the exception (or null if none) of this stage.
         */
        //CompletableFuture c18 = any.whenComplete(/*BiConsumer*/(prevResult, exception)->{});

        /**
         * Returns a new CompletionStage that, when either this or the other given stage complete normally, is executed with the corresponding result as argument to the supplied action.
         */
        CompletableFuture c2 = CompletableFuture.supplyAsync(() -> "firstService")
                .acceptEither(CompletableFuture.supplyAsync(() -> "secondRedundancyServcer"), (consumeMe) -> {
                }); // Consumer

        // WHY Async SUFFIX - will execute in another thread by submitting to the pool - without ASYNCH IS EXECUTED SAME THREAD AS PREVIOUS COMPLETABLE FUTURE

        /**
         * same +
         * using this stage's default asynchronous execution facility
         */
        CompletableFuture c3 = CompletableFuture.supplyAsync(() -> "firstService")
                .acceptEitherAsync(CompletableFuture.supplyAsync(() -> "secondRedundancyServcer"), (consumeMe) -> {
                });

        /**
         * same
         * + executor service param
         */
        CompletableFuture c4 = CompletableFuture.supplyAsync(() -> "firstService")
                .acceptEitherAsync(CompletableFuture.supplyAsync(() -> "secondRedundancyServcer"), (consumeMe) -> {
                }, Executors.newSingleThreadExecutor());

    }


    @Test
    public void customExecutor() {
        //n thread = n cpu * TargetUsageCPU * (1 + WaitTime/ComputeTime) - the bigger the WaitTime the more threads you may create to fill the CPU usage

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture.supplyAsync(() -> {
            return new Shop().getPrice();
        }, executorService);
    }


}
