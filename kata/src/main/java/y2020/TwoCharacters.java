package y2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



/**
 * /challenges/two-characters/problem
 *
 * Given a string, remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Determine the longest string possible that contains just two alternating letters.
 *
 */
public class TwoCharacters {

    // immediate solution - characters index - and do the combinations of any 2 chars found and do the removal and test
    static int alternate(String s) {


        Map<Character, Long> collect = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Character> list = new ArrayList(collect.keySet());

        int max = 0;
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
                ArrayList arrayList = new ArrayList(list);
                arrayList.removeAll(Arrays.asList(list.get(i),
                        list.get(j)));
               max  = Math.max(max, testValid(s, arrayList));
            }
        }
        return max;
    }

    static int testValid(String s, List<Character> remove){
        for(Character c : remove){
            s=s.replaceAll(c+"","");
        }
        char[] chars = s.toCharArray();
        for(int i = 1; i < chars.length; i++){
            if (chars[i] == chars[i-1]){
                return 0;
            }
        }
        return chars.length;
    }

    @Test
    public void t(){
        System.out.println(alternate("abaacdabd"));
    }
}
