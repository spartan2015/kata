package bitwise;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Battlestar on 2/10/2015.
 */
public class BitTest {

    @Test
    public void t(){
        byte a = 0b10;

        byte b = (byte)(a & 2);

        assertTrue(b == 2);

        assertTrue((a & 1) == 0);

        assertTrue((a & 3) == 2);

        assertTrue((a & 0) == 0);
        // check or switch off - only what is common with
        // your comparator remains up - that is why it's a check

        assertTrue((a | 1) == 3); // switch on
    }
}
