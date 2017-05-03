package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * With List
 *
 * using removeIf
 * using replaceAll
 */
public class ListTest {
    @Test
    public void removeIf(){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");


        boolean removedAny = list.removeIf((strings)-> strings.length() == 0);
    }

    @Test
    public void replaceAll(){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // VOID
        list.replaceAll((string)->string+string);

        System.out.println(list);

    }
}
