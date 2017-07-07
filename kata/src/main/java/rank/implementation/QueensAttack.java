package rank.implementation;

import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created on 7/6/2017.
 *
 * /challenges/queens-attack-2
 *
 * you have a board at position
 *
 * 4 0 4 4 = means you have a chessboard of n size and 0 obstacles and queen is at 4 4
 *
 *5 3 4 3 5 5 4 2 2 3 - board is 5, 3 obstacles, queen at 4 3 - the others are the 3 obstacles  5 5 4 2 2 3
 *
 * count how many board squares the queen can attack
 *
 *
 * A queen is standing on an  chessboard. The chessboard's rows are numbered from  to , going from bottom to top; its columns are numbered from  to , going from left to right. Each square on the board is denoted by a tuple, , describing the row, , and column, , where the square is located.

 The queen is standing at position  and, in a single move, she can attack any square in any of the eight directions (left, right, up, down, or the four diagonals). In the diagram below, the green circles denote all the cells the queen can attack from :
 There are  obstacles on the chessboard preventing the queen from attacking any square that has an obstacle blocking the the queen's path to it. For example, an obstacle at location in the diagram above would prevent the queen from attacking cells , , and :
 */
public class QueensAttack {

    @Test
    public void case1(){
        Scanner in = new Scanner("4 0 4 4");
        assertEquals(Integer.valueOf(9), Integer.valueOf(getCount(in)));
    }

    @Test
    public void case2(){
        Scanner in = new Scanner("5 3 4 3 5 5 4 2 2 3");
        assertEquals(Integer.valueOf(10), Integer.valueOf(getCount(in)));
    }

    @Test
    public void case3(){
        Scanner in = new Scanner(this.getClass().getResourceAsStream("queensattackinput06"));
        assertEquals(Integer.valueOf(40), Integer.valueOf(getCount(in)));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = getCount(in);

        System.out.println(count);
    }

    private static int getCount(Scanner in) {
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = n-in.nextInt();
        int cQueen = in.nextInt()-1;

        Map<Integer,TreeSet<Integer>> rowToCol = new HashMap<>();
        Map<Integer,TreeSet<Integer>> colToRow = new HashMap<>();

        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();

            int matrixRow = n-rObstacle;
            int matrixCol = cObstacle-1;
            rowToCol.merge(matrixRow, new TreeSet(){ {add(matrixCol);}}, (o,ne)->{o.addAll(ne);return o; });
            colToRow.merge(matrixCol, new TreeSet(){ {add(matrixRow);}}, (o,ne)->{o.addAll(ne);return o; });
        }

        int count = 0;
        //up
        Integer lower = getColToRow(rQueen, cQueen, colToRow);
        count += rQueen == 0 ? 0 : (rQueen - ((lower!=null? lower+1 : 0)));
        //down
        Integer higher = getRowToCol(cQueen, rQueen, colToRow);
        count += (higher==null ? n-1 : higher-1) - rQueen;
        //left
        lower = getColToRow(cQueen, rQueen, rowToCol);
        count += cQueen - (lower == null ? 0 : lower+1);
        //right
        higher = getRowToCol(rQueen, cQueen, rowToCol);
        count += (higher==null ? n-1 : higher-1) - cQueen;
        //1 clockwise
        for(int row = rQueen-1, col = cQueen-1; row >=0 && col >=0; row--, col--){
            if (hasObstacle(rowToCol, row, col)){
                break;
            }
            count++;
        }
        //2
        for(int row = rQueen-1, col = cQueen+1; row >=0 && col <n; row--, col++){
            if (hasObstacle(rowToCol, row, col)){
                break;
            }
            count++;
        }
        //3
        for(int row = rQueen+1, col = cQueen+1; row < n && col <n; row++, col++){
            if (hasObstacle(rowToCol, row, col)){
                break;
            }
            count++;
        }
        //4
        for(int row = rQueen+1, col = cQueen-1; row < n && col >=0 ; row++, col--){
            if (hasObstacle(rowToCol, row, col)){
                break;
            }
            count++;
        }
        return count;
    }

    private static Integer getRowToCol(int rQueen, int cQueen, Map<Integer, TreeSet<Integer>> rowToCol) {
        TreeSet<Integer> integers = rowToCol.get(rQueen);
        return integers!=null ? integers.higher(cQueen) : null;
    }

    private static Integer getColToRow(int rQueen, int cQueen, Map<Integer, TreeSet<Integer>> colToRow) {
        TreeSet<Integer> integers = colToRow.get(cQueen);
        return integers != null ? integers.lower(rQueen) : null;
    }

    private static boolean hasObstacle(Map<Integer, TreeSet<Integer>> rowToCol, int row, int col) {
        TreeSet<Integer> integers = rowToCol.get(row);

        return integers!=null ? integers.contains(col) : false;
    }

}
