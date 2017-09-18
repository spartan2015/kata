package rank.datastructures.arrays;

import org.junit.Test;
import utils.ReadingUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/sparse-arrays
 *
 */
public class SparseArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(howManyTimes(in));
    }

    private static String howManyTimes(Scanner in) {
        return perform(in, out->{
            int N = in.nextInt();
            Map<String, Long> map = new HashMap<>();
            for(int i =0; i < N; i++){
                String s= in.next();
                map.merge(s,1l,Long::sum);
            }
            String[] queries = getStrings(in);
            for(String s : queries){
                out.append(map.getOrDefault(s,0l)).append("\n");
            }
        });
    }

    private static String[] getStrings(Scanner in) {
        int N = in.nextInt();
        String[] list= new String[N];
        for(int i =0; i < N; i++){
            list[i] = in.next();
        }
        return list;
    }

    interface Algo{
        void solve(StringBuilder out);
    }

    private static String perform(Scanner in, Algo algo) {
        StringBuilder out = new StringBuilder();
        algo.solve(out);
        return out.toString();
    }

    @Test
    public void case1(){
        assertEquals("2\n" +
                "1\n" +
                "0\n", howManyTimes(new Scanner("4\n" +
                "aba\n" +
                "baba\n" +
                "aba\n" +
                "xzxb\n" +
                "3\n" +
                "aba\n" +
                "xzxb\n" +
                "ab")));
    }

}
