package y2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


import static org.junit.Assert.assertEquals;

/**
 * /challenges/happy-ladybugs/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * <p>
 * Happy Ladybugs is a board game having the following properties:
 * <p>
 * The board is represented by a string, b, of length n. The ith character of the string b[i] denotes the ith cell of the board
 * if b[i] is an underscore _ it meanst the ith cell of the board is empty
 * if it is uppercase english it mans it contains a ladybug of color b[i]
 * string b will not contain any other characters
 * <p>
 * a ladybug is happe only when it is left or right adjacent cell b[i+-1] is occupied by another ladybug of the same color
 * in a single move you can move a ladybug from its current position to any empty cell
 * given the values n and b for g games og happy ladybugs determine if it is possible to make all the ladybugs happy.
 * For each game, print yes on a new line if all the ladybugs can be happy through any number of moves otherwise print no
 * <p>
 * eg. b = {YYR_B_B_R} can become -> {YYRRBB__} and all ladybugs are happy
 */
public class HappyLadybugs {

    public static final String CHAR = "_";

    static String happyLadybugs(String b) {

        char[] characters = b.toCharArray();
        int streak = 1;
        char last = characters[0];
        boolean hasToMove = false;
        for(int i = 1; i < characters.length; i++){
            if (characters[i] == last){
                streak++;
            }else{
                if (streak == 1){
                    hasToMove = true;
                }
                if (i == characters.length-1){
                    hasToMove = true;
                }
                streak = 1;
                last = characters[i];
            }
        }
        if (characters.length == 1 && last != '_'){
            hasToMove = true;
        }

        Map<String, Long> result = Arrays.stream(b.split(""))
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        long single = result.entrySet().stream()
                .filter(e -> !e.getKey().equals(CHAR) && e.getValue() == 1)
                .count();


        boolean canMove = result.get(CHAR) != null;


        return hasToMove == false || (single == 0 && canMove) ? "YES" : "NO";

    }

    @Test
    public void t1() {

        assertEquals("NO", happyLadybugs("D"));

        assertEquals("YES", happyLadybugs("DD__FQ_QQF"));

        assertEquals("YES", happyLadybugs("DDD_DD"));


        assertEquals("NO", happyLadybugs("AABBC"));

        assertEquals("NO", happyLadybugs("AABCBC"));

        assertEquals("NO", happyLadybugs("X_Y__X"));

        assertEquals("YES", happyLadybugs("B_RRBR"));

        assertEquals("YES", happyLadybugs("YYR_B_B_R"));
        assertEquals("YES", happyLadybugs("AABBC_C"));
        assertEquals("YES", happyLadybugs("_"));



        assertEquals("YES", happyLadybugs("RBY_YBR"));
        assertEquals("YES", happyLadybugs("__"));

    }


}
