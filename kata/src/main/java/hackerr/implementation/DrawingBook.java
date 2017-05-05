package hackerr.implementation;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class DrawingBook {
    @Test
    public void case1(){
        assertEquals(Integer.valueOf(1), Integer.valueOf(minimumNumberOfTurns(6,2)));
    }

    @Test
    public void case2(){
        assertEquals(Integer.valueOf(0), Integer.valueOf(minimumNumberOfTurns(5,4)));
    }

    static int minimumNumberOfTurns(int noOfPagesInBook, int turnToPage){
        return Math.min(minimumNumberOfTurnsFromStart(noOfPagesInBook, turnToPage), minimumNumberOfTurnsFromEnd(noOfPagesInBook, turnToPage));
    }

    private static int minimumNumberOfTurnsFromEnd(int noOfPagesInBook, int turnToPage) {
        int turns = 0;
        int lastSeenPage = noOfPagesInBook%2 == 0 ? noOfPagesInBook : noOfPagesInBook -1 ;
        while(lastSeenPage>turnToPage){ turns++; lastSeenPage-=2;}
        return turns;
    }

    private static int minimumNumberOfTurnsFromStart(int noOfPagesInBook, int turnToPage) {
        int turns = 0;
        int lastSeenPage = 1;
        while(lastSeenPage<turnToPage) {turns++; lastSeenPage+=2;}
        return turns;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfPagesInBook = in.nextInt();
        int turnToPage = in.nextInt();
        int result = minimumNumberOfTurns(noOfPagesInBook, turnToPage);
        System.out.println(result);
    }
}
