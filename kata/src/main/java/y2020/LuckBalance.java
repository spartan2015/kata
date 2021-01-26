package y2020;

import java.util.Arrays;

/**
 * LuckBalance
 * /challenges/luck-balance/problem
 */
public class LuckBalance {
    static int luckBalance(int k, int[][] contests) {
        // lose no more than k contests
        // contests[0][0] - luck - decrease on win - increase on lose
        // contests[0][1] - is the contest important
        // if we lose no more than k - maximum amount of luck -
        // in desceding order - sort contests but [0][0] luck -
        // add also the wins - as you go - sum of all luck - decrease luck with contests.length - k sum
        // max luck is possible (lose all contests) -

        // she is allowed to lose k important contests (contests with [0][1] = true
        // but can lose the un important all contests - so obviously
        // sum max luck - decrese but k - limit of important contest - filter ascending those

        Arrays.sort(contests, (a,b)->b[0]-a[0]);
        int sum =0;
        for(int[] contest : contests){
            if ((contest[1] == 1 && k > 0)){
                sum += contest[0];
                k--;
            } else if (contest[1] == 0){
                sum += contest[0];
            }
            else{
                sum -= contest[0];
            }
        }
        return sum;
    }



}
