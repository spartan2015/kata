package y2020;

/**
 * Purpose of ServiceLane is
 */
public class ServiceLane {

    static int[] serviceLane(int n, int[] width,  int[][] cases) {
        int[] results = new int[cases.length];
        int k = 0;
        for(int[] c : cases){
            int min =1000;
            for(int i = c[0]; i<= c[1]; i++){
                min = Math.min(min, width[i]);
            }
            results[k++] = min;
        }
        return results;
    }

}
