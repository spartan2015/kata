package y2021;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * /challenges/the-grid-search/problem
 */
public class GridSearch {

    public static String gridSearch(List<String> G, List<String> P) {
        for(int i = 0; i <= G.size() - P.size() && i + P.size() <= G.size(); i++){
            int index= -1;
            a: do {
                index = G.get(i).indexOf(P.get(0), index+1);
                if (index != -1) {
                    for (int k = 1; k < P.size(); k++) {
                        if (!G.get(i + k).substring(index, index + P.get(k).length()).equals(P.get(k))) {
                            continue a;
                        }
                    }
                    return "YES";
                }
            }while(index!=-1);
        }
        return "NO";
    }

    @Test
    public void t1(){
        assertEquals("YES", gridSearch(
                Arrays.asList(
                        """
                        7283455864
                        6731158619
                        8988242643
                        3830589324
                        2229505813
                        5633845374
                        6473530293
                        7053106601
                        0834282956
                        4607924137
                        """.split("\n")),
                Arrays.asList(
                        """
                        9505
                        3845
                        3530
                        """.split("\n"))
        ));
    }

    @Test
    public void t2(){
        assertEquals("NO", gridSearch(
                Arrays.asList(
                        """
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
                       
                        """.split("\n")),
                Arrays.asList(
                        """
                        99
                        99
                        """.split("\n"))
        ));
    }

    @Test
    public void t3() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(GridSearch.class.getResourceAsStream("/y2021/GridSearch-input.txt")));

        BufferedReader resultsReader = new BufferedReader(
                new InputStreamReader(GridSearch.class.getResourceAsStream("/y2021/GridSearch-output.txt")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = gridSearch(G, P);
                assertEquals(resultsReader.readLine(), result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    @Test
    public void t4(){
        assertEquals("YES", gridSearch(
                Arrays.asList(
                        """
123412
561212
123634
781288
                                                       
                                """.split("\n")),
                Arrays.asList(
                        """
12
34
                                """.split("\n"))
        ));
    }

}
