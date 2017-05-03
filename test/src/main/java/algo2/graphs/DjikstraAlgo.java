package algo2.graphs;

import org.junit.Test;

import java.util.*;

/**
 * Created by Battlestar on 1/11/2015.
 */
public class DjikstraAlgo {

    @Test
    public void test(){
        int[][] distances = {
                {0,7,9,0,0,14},
                {7,0,10,11,0,9},
                {9,10,0,11,0,2},
                {0,15,11,0,6,0},
                {0,0,0,6,0,9},
                {14,0,2,0,9,0},
        };

        long[] minPath = minPath(distances); //[0, 7, 9, 18, 20, 11]
        System.out.println(Arrays.toString(minPath));
    }

    long[] minPath(int[][] distances){

        long[] minPath = new long[distances.length];
        for(int i = 0; i<distances.length; i++){
            if (i ==0){
                minPath[i] = 0;
            }else{
                minPath[i] = Integer.MAX_VALUE;
            }

        }

        for(int nodeIndex = 0 ; nodeIndex < distances.length; nodeIndex++){

            for(int neighbourIndex= 0 ; neighbourIndex < distances.length; neighbourIndex++){
                if (distances[nodeIndex][neighbourIndex] != 0) {
                    long newMinPath = minPath[nodeIndex] + distances[nodeIndex][neighbourIndex];
                    if (newMinPath < minPath[neighbourIndex]) {
                        minPath[neighbourIndex] = newMinPath;
                    }
                }
            }

        }

        return minPath;
    }

    long[] minPathWorse(int[][] distances){
        Set<Integer> notVisited  = new LinkedHashSet<>();
        long[] minPath = new long[distances.length];
        for(int i = 0; i<distances.length; i++){
            if (i ==0){
                minPath[i] = 0;
            }else{
                minPath[i] = Integer.MAX_VALUE;
            }
            notVisited.add(i);
        }

        Iterator<Integer> notVisitedIterator = notVisited.iterator();
        while(notVisitedIterator.hasNext()){
            Integer nodeIndex = notVisitedIterator.next();

            for(int neighbourIndex= 0 ; neighbourIndex < distances.length; neighbourIndex++){
                if (distances[nodeIndex][neighbourIndex] != 0) {
                    long newMinPath = minPath[nodeIndex] + distances[nodeIndex][neighbourIndex];
                    if (newMinPath < minPath[neighbourIndex]) {
                        minPath[neighbourIndex] = newMinPath;
                    }
                }
            }

            notVisitedIterator.remove();
        }

        return minPath;
    }
}
