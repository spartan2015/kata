package rank.implementation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created on 6/11/2017.
 *
 * import java.util.stream.*;
 import java.util.function.*;

 */
public class DesignerPDFViewer {

    @Test
    public void t1(){
        System.out.println((short)'a');

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();

        System.out.println("" + stream(word.toCharArray()).map(c->h[c-97]).max().getAsInt() * word.length());
    }

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
