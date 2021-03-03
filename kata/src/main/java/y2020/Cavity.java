package y2020;

import org.junit.Test;

import java.util.Arrays;

/**
 * /challenges/cavity-map/problem
 * You are given a square map as a matrix of integer strings. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side, or edge.
 * <p>
 * Find all the cavities on the map and replace their depths with the uppercase character X.
 * 989
 * 191
 * 111
 * =>
 * <p>
 * 989
 * 1X1
 * 111
 */
public class Cavity {

    static String[] cavityMap(String[] grid) {
        for (int row = 1; row < grid.length - 1; row++) {

            for (int cell = 1; cell < grid.length - 1; cell++) {

                if (
                        gt(grid[row].charAt(cell), grid[row - 1].charAt(cell)) &&
                                gt(grid[row].charAt(cell), grid[row].charAt(cell - 1)) &&
                                gt(grid[row].charAt(cell), grid[row].charAt(cell + 1)) &&
                                gt(grid[row].charAt(cell), grid[row + 1].charAt(cell))

                ) {
                    grid[row] = new StringBuilder(grid[row]).replace(cell, cell + 1, "X").toString();
                }
            }
        }
        return grid;
    }

    public static boolean gt(char a, char b) {
        return a > b;
    }

    @Test
    public void t() {

        System.out.println(Arrays.toString(cavityMap(new String[]{"989", "191", "111"})));
        ;

    }

}
