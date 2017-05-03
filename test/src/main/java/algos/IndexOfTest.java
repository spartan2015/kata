package algos;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Battlestar on 1/30/2015.
 */
public class IndexOfTest {
    @Test
    public void myIndexOf(){
        assertTrue(indexOf("abc", "ab") == 0);

        assertTrue(indexOf("abc", "bc") == 1);

        assertTrue(indexOf("abc","d") == -1);

        assertTrue(indexOf("abc","dc") == -1);

        assertTrue(indexOf("abc","dcb") == -1);

        assertTrue(indexOf("abc","acb") == -1);

        assertTrue(indexOf("abc","bca") == -1);

        assertTrue(indexOf("abc","abcd") == -1);

        assertTrue(indexOf("abc","bcad") == -1);

        assertTrue(indexOf("abc","bac") == -1);

        assertTrue(indexOf("abc", "a") == 0);

        assertTrue(indexOf("abc", "b") == 1);

        assertTrue(indexOf("abc", "c") == 2);
    }

    int indexOf(String str, String substring){
        if (substring.length() ==0) return -1;
        if (substring.length() > str.length()) return -1;
        else{
            char[] ch = str.toCharArray();
            char[] sub = substring.toCharArray();
            for(int i =0; i < ch.length; i++){
                boolean matches = true;
                if (i + sub.length > ch.length){
                    break;
                }
                for(int j = 0; j < sub.length && i+j < ch.length;j++){
                    if (ch[i+j] != sub[j]){
                        matches = false;
                        break;
                    }
                }
                if (matches){
                    return i;
                }
            }
            return -1;
        }
    }
}
