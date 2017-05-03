package java8.collections.newapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * With List
 *
 * using removeIf
 * using replaceAll
 */
public class RemoveIf {
    @Test
    public void removeIf(){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");


        boolean removedAny = list.removeIf((s)-> s.length() == 0);
    }

   
}
