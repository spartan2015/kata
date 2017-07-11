package rank.implementation;

import java.util.Scanner;

/**
 * Created on 7/11/2017.
 * /challenges/organizing-containers-of-balls/problem
 * <p>
 * you have n contains and n different types of ball
 * distribution is of balls per container is a n x n matrix M
 * where Mct is the numbers of balls of type t in container c.
 * example: M = [[1,4],[2,3]];
 * In a single operation David can swap two balls
 * located in different contains
 * Perform swap operations such that both conditions are satisfied:
 * - each container contains balls of the same type - not necessarly the same container n *
 * - no 2 balls of the same type are locate in different contains
 * <p>
 * you must perform q queries where each query is in the form of a matrix M
 * For each query print Possible on a new line if David can satisfy the conditions above for
 * the given matrix otherwise print Impossible instead.
 * first lines contains number of queies, q
 * for each query we have an integer n denoting the size of the matrix
 * each following line describes the row of the matrix - size n
 * <p>
 * q < 0
 * 1 <= n <=100
 * 0 <= Mct <= Math.pow(10,9) - billions of balls but under integer type
 */
public class OrganizingContainersofBalls {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[][] M = new int[n][n];
            for (int M_i = 0; M_i < n; M_i++) {
                for (int M_j = 0; M_j < n; M_j++) {
                    M[M_i][M_j] = in.nextInt();
                }
            }
            // your code goes here
            // interesting one ball type can remain - once
            //boolean[][] marked = new boolean[n][];
            // in each container [col] we can have only one row with value > 0
            // - rest of the balls have to be exchanged
            // but after the exchange -
            // all exchanges - all containers must have only one type
            // when is this possible ? first container contains 1 ball of each type 1 1 1 -
            // one you chose one ball type for container 1 - the others can't must recevei each one ball - so the thing they receive must be a their choice - so container 1 can choose either row 1 or row 2 to have values - once he made the choise he must exchange his other - and see if he can find prober locatio - also not that row col 0 0 becomes
            // and a swap is possible only if the receiver contains the chosen ball of the giver - so the give has to be able to get rid of his balls
            // so the number of balls he must give must be equal with the number of balls of the chosen type he must receive - swap
            // also the chosen col becomes frozen - and moves forward - so if col 1 contains any ball of type chose prev
            // can t swap with previous cause prev has no balls to swap
            int[] chosen = new int[n];
            boolean possible = true;
            l1:
            for (int col = 0; col < n; col++) {
                int impossible = 0;
                for (int row = 0; row < n; row++) {
                    if ( M[row][col] != M[col][row]) {
                        //marked[row][col] = true;
                       // marked[col][row] = true;
                        impossible++;
                    }
                }
                if (impossible > 1){
                    possible = false;
                    break l1;
                }
            }
            if (possible) {
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }
        }

    }
}
}
