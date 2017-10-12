package java8.coreClassWithExceptions;

import java.util.function.Function;

/**
 * Created on 10/12/2017.
 */
@FunctionalInterface
public interface ThrowingFunction<T,R> extends Function<T,R> {

    default R apply(T a){
        try{
            return applyThrows(a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public R applyThrows(T a) throws Exception;
}
