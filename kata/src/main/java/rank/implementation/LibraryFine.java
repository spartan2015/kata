package rank.implementation;

import org.junit.Test;

import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

/**
 * Created on 6/13/2017.
 */
public class LibraryFine {

    @Test
    public void t1(){
        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(1, 1,1, 1,1,1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(1, 1,0, 1,1,1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(1, 0,0, 1,1,1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(0, 0,0, 1,1,1)));

        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(0, 1,1, 1,1,1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(0, 0,1, 1,1,1)));


        assertEquals(Integer.valueOf(150), Integer.valueOf(comFine(11, 1,1, 1,1,1)));


        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(0, 0,0, 1,1,1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(comFine(2, 2,0, 1,1,1)));

        assertEquals(Integer.valueOf(500), Integer.valueOf(comFine(2, 2,1, 1,1,1)));
        assertEquals(Integer.valueOf(500), Integer.valueOf(comFine(2, 2,1, 1,1,1)));

        assertEquals(Integer.valueOf(1500), Integer.valueOf(comFine(10, 10,20, 1,1,1)));
        assertEquals(Integer.valueOf(1500), Integer.valueOf(comFine(2, 2,2, 1,1,1)));
        assertEquals(Integer.valueOf(1500), Integer.valueOf(comFine(0, 0,4, 1,1,1)));


    }

    @Test
    public void t2(){

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int returnDay = in.nextInt();
        int returnMonth = in.nextInt();
        int returnYear = in.nextInt();

        int dueDay = in.nextInt();
        int dueMonth = in.nextInt();
        int dueYear = in.nextInt();
        System.out.println(
        comFine(returnDay, returnMonth, returnYear, dueDay, dueMonth, dueYear));
    }

    private static int comFine(int returnDay, int returnMonth, int returnYear, int dueDay, int dueMonth, int dueYear) {
        int fine = 0;
        if (returnYear == dueYear && returnMonth == dueMonth && dueDay < returnDay){
            fine = 15 * (returnDay-dueDay);
        }else if (returnYear == dueYear && returnMonth > dueMonth){
            fine = 500 * (returnMonth-dueMonth);
        }else if (returnYear > dueYear){
            fine = 10000;
        }
        return fine;
    }
}
