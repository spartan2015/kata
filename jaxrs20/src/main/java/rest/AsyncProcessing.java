package rest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("async")
public class AsyncProcessing {

    private static final Logger LOG = Logger.getLogger("AsyncProcessing.class");

    private ObjectMapper mapper = new ObjectMapper(new JsonFactory());

    @GET
    public void getAsync(@Suspended final AsyncResponse asyncResponse){
        CompletableFuture.supplyAsync(()->"Hello World Async").thenApply(hello->{
            if (hello!=null) {
                asyncResponse.resume(mapper.getNodeFactory().textNode(hello));
            }else{
                throw new NotFoundException();
            }
            return null;
        }).exceptionally(throwable -> {
            if (throwable instanceof CompletionException) {
                throwable = throwable.getCause();
            }
            asyncResponse.resume(throwable);
            return null;
        });
    }
}
