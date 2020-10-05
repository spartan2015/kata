package y2020;

/**
 * Purpose of ServiceLane is
 *
 *
 * given width array - containing width available
 * given cases - which pin start and end in width array
 * find max size vehicle that can fit all width (a min problem)
 *
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
