package hackerr.implementation;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.junit.Test;

public class DayOfTheProgrammer {

    @Test
    public void case1(){
        assertEquals("12.09.2016",solve(2016));
    }

    @Test
    public void case2(){
        assertEquals("12.09.1700",solve(1700));
    }

    @Test
    public void case3(){
        assertEquals("12.09.2000",solve(2000));
    }

    static String solve(int year){
        if (year == 1918){
            return "26.09.1918";
        }else {
            return 256-243+28-febDays(year) + ".09." + year;
        }
    }

    static String solve3(int year){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // if (year == 1918){
        //     return LocalDate.of(year, Month.FEBRUARY, 14).plusDays(255-32).format(formatter);
        // }else {
        return LocalDate.of(year, Month.JANUARY, 1).plusDays(255).format(formatter);
        // }
    }

    private static int febDays(int year) {
        if (isLeapYear(year)){
            return 29;
        }else{
            return 28;
        }
    }

    private static boolean isLeapYear(int year){
        if (year < 1917)
            return year % 4 ==0;
        else{
            return year % 400 == 0 | (year % 4 ==0 && year % 100 !=0);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
