package ian2008.hash;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * hashing function: easy to produce, low collision rate
 *
 * Properties:
 *  1. consistent - multiple calls => same hash value - hashCode(x) == hashCode(x)
 *  2. efficient - least compute effort possible
 *  3.uniform distribution - low collision
 *
 *
 * size of the array - PRIME NUMBER - compute remainder - Key % M - disperses the keys between 0 and M-1*
 * Positive integers:
 * if M is not prime that mean that not all of the bits of the key play a role - missing opportunity to disperse
 * values evenly, for example if M is 10^k only the least significant k bits contribute
 *
 * Floating point numbers (between 0 and 1)- least effective  round(Key * M) - the least significant bits play no
 * role - favors most significat bits (rounding) - use modular hashing on the bit representation (java default)
 *
 * String: use modular hashing (like java):
 *
 *
 * COLLISION resolution:
 * 1. separate chaining (linked list)
 * 2. linear probing
 *
 *
 */
public class Rules {

    private int hash;

    public int hashCodeModularHashing(String str) {
        char[] value = str.toCharArray();

        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }

            hash = h;
        }
        return h;
    }

    public static int hornetMethodHash(String str, int M){
        char[] value = str.toCharArray();
        int h = 17;
        int R = 31; // bigger than any char - smaller so it does not cause overflow

        for (int N = 0; N < value.length; N++) {
            h = ( makeSureIsPositive(R * h + value[N] )) % M; // do this N times (N = str.length)(multiply by R, add
            // value, modules)
            // compund keys (day month year) = h = ((((h * R + day ) % M) * R + month) % M) * R + year) %M
        }
        return h;
    }

    public static int useWithHavaHashCode(Object o, int M){
        return makeSureIsPositive(o.hashCode()) % M;
    }

    private static int makeSureIsPositive(int o) {
        return o & 0x7fffffff; // 2147483647 => 1111111111111111111111111111111 - yeah 31 bits - masks of the sign
        // bit - negative sign bit is 1 and 0 - > 0 - positive number
    }

    @Test
    public void t1(){
        assertEquals((Integer)31 ,(Integer)Integer.bitCount(0x7fffffff));
    }

    public static int compoundHash(List objects, int M){
        int h = 17;
        int R = 31; // make sure it does not cause overflow (small) - othersise the resulting value will not be bet 0
        // and M-1
        for(Object o : objects){
            h = makeSureIsPositive(R * h + o.hashCode()) % M;
        }
        return h;
    }




}
