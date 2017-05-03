package algos;

import org.junit.Test;

import javax.xml.transform.sax.SAXSource;

import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * Created by Battlestar on 2/4/2015.
 */
public class EATest {

    @Test
    public void t(){

        assertTrue(1 == solution("kayak"));

        assertTrue(1 == solution("aba"));

        assertTrue(1 == solution("dooernedeevrvn"));


    }

    @Test
    public void tLambada(){

        assertTrue(1 == solutionLambda("kayak"));

        assertTrue(1 == solutionLambda("aba"));

        assertTrue(1 == solutionLambda("dooernedeevrvn"));


    }

    public int solutionLambda(String S) {
        Map<String, List<String>> map =Arrays.asList(S.split("\\W*")).stream().collect(Collectors.groupingBy(String::toString));

        int count2 = 0;
        int count1= 0;
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            int i = entry.getValue().size();
            if (i > 0) {
                if (i % 2 == 0) count2+=i/2;
                else count1++;
            }
        }

        if (count2 == (S.length() / 2)){
            return 1;
        }else{
            return 0;
        }
    }

    public int solution(String S) {
        char[] string = S.toCharArray();
        int[] buckets = new int[26];
        int count2 = 0;
        int countAll = string.length;
        for (int i = 0; i < string.length; i++){
            char c = string[i];
            int position = (int)c - 97;
            buckets[position]++;

            if (buckets[position] %2 == 0){
                count2++;
            }
        }

        if (count2 == (countAll / 2)){
            return 1;
        }else{
            return 0;
        }
    }

    public int solution2(String S) {
        char[] string = S.toCharArray();
        int[] buckets = new int[26];

        int countAll = string.length;
        for (int i = 0; i < string.length; i++){
            char c = string[i];
            int position = (int)c - 97;
            buckets[position]++;
        }

        int count2 = 0;
        int count1= 0;
        for(int i : buckets){
            if (i > 0) {
                if (i % 2 == 0) count2+=i/2;
                else count1++;
            }
        }

        if (count2 == (countAll / 2)){
            return 1;
        }else{
            return 0;
        }
    }
}
