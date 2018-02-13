/*
package rank.implementation;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

*/
/**
 * Created on 7/11/2017.
 * /challenges/organizing-containers-of-balls/problem
 * <p>
 * you have n contains and n different types of ball
 * distribution is of balls per container is a n x n matrix M
 * where Mct is the numbers of balls of type t in container c.
 * example: M = [[1,4],[2,3]];
 * In a single operation David can swap two balls
 * located in different contains
 * Perform swap operations such that both conditions are satisfied:
 * - each container contains balls of the same type - not necessarly the same container n *
 * - no 2 balls of the same type are locate in different contains
 * <p>
 * you must perform q queries where each query is in the form of a matrix M
 * For each query print Possible on a new line if David can satisfy the conditions above for
 * the given matrix otherwise print Impossible instead.
 * first lines contains number of queies, q
 * for each query we have an integer n denoting the size of the matrix
 * each following line describes the row of the matrix - size n
 * <p>
 * q < 0
 * 1 <= n <=100
 * 0 <= Mct <= Math.pow(10,9) - billions of balls but under integer type
 *//*

public class OrganizingContainersofBalls {

    static class BallType implements Comparable<BallType> {
        int n;
        int count;

        public BallType(int n, int count) {
            this.n = n;
            this.count = count;
        }

        @Override
        public int compareTo(BallType o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    @Test
    public void t1() {
        assertEquals("Possible", isPossible(new Scanner("1 1 1 1"), 2));
        assertEquals("Impossible", isPossible(new Scanner("0 2 1 1"), 2));
    }

    @Test
    public void t2() throws Exception {
        assertEquals(
                new BufferedReader(new InputStreamReader(this.getClass()
                        .getResourceAsStream("OrganizingContainersofBalls.expected.txt")))
                        .lines()
                        .collect(Collectors.joining("\n")),
                testCasesPossible(new Scanner(this.getClass()
                        .getResourceAsStream("OrganizingContainersofBalls.txt"))));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(
                testCasesPossible(in));
        ;
    }

    private static String testCasesPossible(Scanner in) {
        int q = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            sb.append(isPossible(in, n) + "\n");
        }
        return sb.toString();
    }

    private static String isPossible(Scanner in, int n) {
        Map<Integer, Map<Integer, Integer>> containersMap = new HashMap<>();
        for (int M_i = 0; M_i < n; M_i++) {
            HashMap currentContainer = new HashMap();
            containersMap.put(M_i, currentContainer);
            for (int M_j = 0; M_j < n; M_j++) {
                currentContainer.put(M_j, in.nextInt());
            }
        }


        // is possible if the exchange is possible - if the number of balls you need to get rid of < number of balls you decide to keep
        // what about do all other containers combined have more balls you need to keep than you need to get rid off ?
        // not important what you keep - keep
        for (int col = 0; col < n; col++) {
            Map<Integer, Integer> values = containersMap.get(col);
            if (values.size() == 1){
                continue;
            }
            boolean possible = false;
            for (Map.Entry<Integer, Integer> keep : values.entrySet()) {
                int exchangeables = 0;
                for (Map.Entry<Integer, Integer> ridOf : values.entrySet()) {
                    if (ridOf.getKey() != keep.getKey()) {
                        int countKeepersInOther = 0;
                        for (int g = 0; g < n; g++) {
                            if (g != col) {
                                Integer count = containersMap.get(g).get(keep.getKey());
                                if (count != null) {
                                    countKeepersInOther += count;
                                }
                            }
                        }
                        if (countKeepersInOther >= ridOf.getValue()) {
                            exchangeables++;
                        }
                    }
                }
                if (exchangeables == values.size()-1){
                    possible = true;
                    break;
                }
            }
            if (!possible) {
                return "Impossible";
            }
        }
        return "Possible";
    }
}
*/
