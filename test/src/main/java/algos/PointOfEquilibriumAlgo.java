package algos;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 This is a demo task. You can read about this task and its solutions in .
 A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.
 A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
 */
public class PointOfEquilibriumAlgo {

    @Test
    public void te(){
        assertTrue(solution(new int[]{0}) == 0);

        assertTrue( solution(new int[]{0,1}) == 1);
        assertTrue( solution(new int[]{1,0}) == 0);

        assertTrue( solution(new int[]{1,1,1}) == 1);

        assertTrue( solution(new int[]{1,1,2,2}) == 2);
    }

    // 100% performance, 100% correctness
    public int solution(int[] A) {
        if (A.length == 0) return -1;

        long sum = 0;
        for(int e : A){
            sum+=e;
        }

        long firstSum = 0;
        long secondSum = A.length > 1 ? sum - A[0] : 0;

        for(int i=0; i<A.length;i++){
            if (firstSum == secondSum){
                return i;
            }

            firstSum += A[i];
            if (i+1 >= A.length){
                secondSum = 0;
            }else {
                secondSum -= A[i+1];
            }
        }
        return -1;
    }
}
