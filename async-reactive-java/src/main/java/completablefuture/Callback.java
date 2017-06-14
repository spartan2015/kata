package completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created on 6/12/2017.
 */
public class Callback {

    public void work(CompletableFuture callback){
        CompletableFuture.runAsync(()->{
            System.out.println("Hello");
        }).thenAccept(s->{
            System.out.println("World");
            callback.complete(null);
        }).exceptionally(e->{
            callback.completeExceptionally(e);
            return null;
        });
    }

}
