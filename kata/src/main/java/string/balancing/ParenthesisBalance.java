package string.balancing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParenthesisBalance {

    @Test
    public void case1Test(){
        assertTrue(0 == balance("<>", 2));
    }

    @Test
    public void case2Test(){
        assertTrue(1 == balance("<", 2));
    }

    @Test
    public void case3Test(){
        assertTrue(0 == balance("><", 2));
    }

    @Test
    public void case4Test(){
        assertTrue(1 == balance("<<>", 2));
    }

    @Test
    public void case5Test(){
        assertTrue(0 == balance("<><>", 2));
    }

    @Test
    public void case6Test(){
        assertTrue(1 == balance("<><><", 2));
    }

    @Test
    public void case7Test(){
        assertTrue(0 == balance("<<<", 2));
    }

    @Test
    public void case8Test() {
        assertTrue(2 == balance("<<<>", 2));
    }

    private int balance(String string, int maxReplace) {
        int left = 0;
        for(int i =0; i<string.length(); i++){
            char c= string.charAt(i);
            if (c =='<') left++;
            if (c == '>') left--;
            if (left < 0) return 0;
        }
        return left <= maxReplace ? left : 0;
    }
}
