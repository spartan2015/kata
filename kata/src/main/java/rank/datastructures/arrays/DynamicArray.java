package rank.datastructures.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 9/16/2017.
 *
 * challenges/dynamic-array
 *
 * crate a List of Lists
 */
public class DynamicArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println(computeLastElements(in));
    }

    private static String computeLastElements(Scanner in) {
        StringBuilder out = new StringBuilder();
        int N = in.nextInt();
        int Q = in.nextInt();

        List<Integer>[] seqList = new List[N];
        for(int i = 0; i < N; i++){
            seqList[i] = new ArrayList();
        }
        int lastAnswer = 0;

        for(int i =0; i < Q; i++){
            int queryType = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            if (queryType == 1) {
                int index = computeInt(N, lastAnswer, x);
                seqList[index].add(y);
            }else{
                int index = computeInt(N, lastAnswer, x);
                lastAnswer = seqList[index].get(y % seqList[index].size());
                out.append(lastAnswer).append("\n");
            }
        }

        return out.toString();
    }

    private static int computeInt(int n, int lastAnswer, int x) {
        return (x  ^ lastAnswer) % n;
    }

    @Test
    public void case1(){
        assertEquals("7\n3\n", computeLastElements(new Scanner("2 5 1 0 5 1 1 7 1 0 3 2 1 0 2 1 1")));
    }

}
