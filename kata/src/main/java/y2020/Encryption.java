package y2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/encryption/problem
 * <p>
 * An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let L  be the length of this text
 * <p>
 * Then, characters are written into a grid, whose rows and columns have the following constraints:
 * <p>
 * floor(sqrt(L)) <= row <= column <= ceil(sqrt(L))
 * <p>
 * eg. s = if man was meant to stay on the ground god would have given us roots
 * <p>
 * ensure rows x column >=L
 * If multiple grids satisfy the above conditions, choose the one with the minimum area
 * <p>
 * The encoded message is obtained by displaying the characters in a column,
 * inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:
 * <p>
 * imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
 * <p>
 * You will be given a message to encode and print.
 */
public class Encryption {

    static String encryption(String s) {
        String stringWithNoSpaces = s.replaceAll(" ", "");
        int L = stringWithNoSpaces.length();
        int rows = (int) Math.floor(Math.sqrt(L));
        int columns = (int) Math.ceil(Math.sqrt(L));

        boolean second = rows > columns;
        while (
                (rows + (!second ? 1 : 0))
                        *
                        (columns + (second ? 1 : 0))
                        >= L) {
            rows = rows + (!second ? 1 : 0);
            columns = columns + (second ? 1 : 0);
            second = !second;
        }

        second = columns > rows;
        while (
                (rows - (!second ? 1 : 0))
                        *
                        (columns - (second ? 1 : 0))
                        >= L) {
            rows = rows - (!second ? 1 : 0);
            columns = columns - (second ? 1 : 0);
            second = !second;
        }

        char[][] grid = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int charIndex = columns * row + column;
                if (charIndex < stringWithNoSpaces.length()) {
                    grid[row][column] = stringWithNoSpaces.charAt(charIndex);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                if (grid[row][column] != 0)
                    sb.append(grid[row][column]);
            }
            if (column < columns - 1)
                sb.append(' ');
        }
        return sb.toString();

    }

    @Test
    public void t1() {
        assertEquals("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau", encryption("if man was meant to stay on the ground god would have given us roots"));
        assertEquals("hae and via ecy", encryption("haveaniceday"));
        assertEquals("fto ehg ee dd", encryption("feedthedog"));
        assertEquals("clu hlt io", encryption("chillout"));
        assertEquals("chi llo ut", encryption("clu hlt io"));
    }

}
