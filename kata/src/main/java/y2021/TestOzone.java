package y2021;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestOzone {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("1","2","3");
        System.out.printf(list.stream().collect(Collectors.joining(",")));

    }

}
