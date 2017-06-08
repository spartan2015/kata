package rank.dynamicprogramming;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created on 6/7/2017.
 */
public class TheCoinChangeProblemOrderedCoins {

    @Test
    public void t1(){
        coins = new int[]{2,3,5,6};
        assertEquals(Integer.valueOf(5), Integer.valueOf(change(10)));
    }
    @Test
    public void t2(){
        coins = new int[]{1,2};
        assertEquals(Integer.valueOf(2), Integer.valueOf(change(3)));
    }

    static int[] solutions;
    static int count = 0;
    static int[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        coins = readArray(sc, m);
        Arrays.sort(coins);
        System.out.println(change(n));
    }

    private static int change(int n) {
        solutions = new int[n+1];
        Arrays.setAll(solutions, i -> -1);
        solutions[0] = 0;
        for(int i =1; i <= n; i++){
            solutions[i] = findSolution(i, i, 0,  new ArrayList());
        }
        return solutions[n];
    }

    private static int findSolution(int start, int n, int index, List soFar) {
        if (n == 0){
            System.out.println(start + " " + soFar);
            return 1;
        }

        if (solutions[n] != -1) {
            System.out.println(soFar + " solution from n="+n);
            return solutions[n];
        }

        int sum = 0;
        for(int i = index; i< coins.length; i++){
            int coin = coins[i];
            if (n - coin >=0){
                List newVariant = new ArrayList(soFar);
                newVariant.add(coin);
                sum += findSolution(n, n - coin, i, newVariant);
            }
        }
        return sum;
    }

    private static int[] readArray(Scanner sc, int n) {
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i]=sc.nextInt();
        }
        return ar;
    }

}
