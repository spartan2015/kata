package utils;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created on 6/11/2017.
 */
public class StreamUtils {
    public static IntStream stream(final char[] ar){
        return StreamSupport.intStream(new Spliterators.AbstractIntSpliterator(ar.length, Spliterator.SIZED){
            int index = 0;

            public boolean tryAdvance(IntConsumer action) {
                boolean can = index < ar.length;
                if (can){
                    action.accept((int)ar[index++]);
                }
                return can;
            }
        } ,true);
    }
}
