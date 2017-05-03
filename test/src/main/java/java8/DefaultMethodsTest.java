package java8;

import org.junit.Test;

import java.util.*;

/**
 * using static methods in Interfaces
 * using default methods
 * understanding default method inheritance rules
 */
public class DefaultMethodsTest {

    @Test
    public void listDefault(){
        List<String> list = Arrays.asList("c","b","a");

        // default sort
        list.sort(String::compareTo);

        list.sort(Comparator.naturalOrder());

        //default void replaceAll
        list.replaceAll((s)-> s+ "1");

        Spliterator<String> spliterator = list.spliterator();
        Spliterator<String> spl2 = spliterator.trySplit();
        spliterator.tryAdvance((s)->{}); // consume elements managed by spliterator - splits like fork/join framework would

    }

    @Test
    public void comparator(){
        Comparator<String> c = (s1,s2) -> {return s1.compareTo(s2);};
        Comparator<String> revesed = c.reversed();

        //Arrays.asList("").sort(Comparator.naturalOrder().thenComparing((String s1,String s2) -> s1.compareTo(s2)));



    }
}

interface SomeInterface extends List {

    default void sort(Comparator comparator){
        Collections.sort(this,comparator);
    }

}

@FunctionalInterface
interface StaticMethodToInterface {
    static void doer(){

    }

    default void then(){

    }

    Integer i = Integer.MAX_VALUE;

    String me();

}