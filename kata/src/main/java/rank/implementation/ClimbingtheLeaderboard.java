package rank.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 6/9/2017.
 *
 * Alice is playing an arcade game and wants to climb to the top of the leaderboard. Can you help her track her ranking as she beats each level? The game uses Dense Ranking, so its leaderboard works like this:

 The player with the highest score is ranked number  on the leaderboard.
 Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
 For example, four players have the scores , , , and . Those players will have ranks , , , and , respectively.

 When Alice starts playing, there are already  people on the leaderboard. The score of each player  is denoted by . Alice plays for  levels, and we denote her total score after passing each level  as . After completing each level, Alice wants to know her current rank.

 You are given an array, , of monotonically decreasing leaderboard scores, and another array, , of Alice's cumulative scores for each level of the game. You must print  integers. The  integer should indicate the current rank of alice after passing the  level.

 Input Format

 The first line contains an integer, , denoting the number of players already on the leaderboard.
 The next line contains  space-separated integers describing the respective values of .
 The next line contains an integer, , denoting the number of levels Alice beats.
 The last line contains  space-separated integers describing the respective values of .

 Constraints

 for
 for
 The existing leaderboard, , is in descending order.
 Alice's scores are cumulative, so  is in ascending order.
 Subtask

 For  of the maximum score:

 Output Format

 Print  integers. The  integer should indicate the rank of alice after passing the  level.

 */
public class ClimbingtheLeaderboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        //int[] scores = new int[n];
        int n = 7;
        int[] scores ={100,100,50,40,40,20,10};
        int count = 1;
        for(int scores_i=0; scores_i < scores.length; scores_i++){
            //scores[scores_i] = in.nextInt();
            if (scores_i > 0 && scores[scores_i]!=scores[scores_i-1]){
                count++;
            }
        }
        int[] scoresFix = new int[count];
        int index = count-1;
        for(int scores_i=0; scores_i < n; scores_i++){
            if (scores_i > 0 && scores[scores_i] == scores[scores_i-1]){
                continue;
            }
            scoresFix[index--]=scores[scores_i];
        }

        //int m = in.nextInt();
        //int[] alice = new int[m];
        int m = 4;
        int[] alice = {5,25,50,120};
        for(int alice_i=0; alice_i < m; alice_i++){
            //alice[alice_i] = in.nextInt();

            int position = Arrays.binarySearch(scoresFix, alice[alice_i]);
            if (position >=0) {
                System.out.println(count-position);
            }else{
                int pos = count-Math.abs(position)+1;
                if (pos == count){
                    System.out.println(count+1);
                }else if (pos == 0){
                    System.out.println(1);
                }else {
                    System.out.println(pos+1);
                }
            }
        }
        // your code goes here

    }

}
