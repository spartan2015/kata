package rank.implementation;

import java.util.Scanner;

/**
 Two cats named A and B

 are standing at integral points on the x-axis. Cat

 is standing at point

 and cat

 is standing at point

 . Both cats run at the same speed, and they want to catch a mouse named

 that's hiding at integral point

 on the x-axis. Can you determine who will catch the mouse?
 You are given

 queries in the form of

 ,

 , and

 . For each query, print the appropriate answer on a new line:
 If cat

 catches the mouse first, print Cat A.
 If cat

 catches the mouse first, print Cat B.
 If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.

 Input Format
 The first line contains a single integer,

 , denoting the number of queries.
 Each of the

 subsequent lines contains three space-separated integers describing the respective values of

 (cat

 's location),

 (cat

 's location), and

 (mouse

 's location).
 Constraints


 Output Format
 On a new line for each query, print Cat A if cat

 catches the mouse first, Cat B if cat

 catches the mouse first, or Mouse C if the mouse escapes.

 two cats at points x, y, running at same speed - cathing mouse at point z - who will be the first?
 */
public class CatsAndAMouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();

            int distanceFromX = Math.abs(z - x);
            int distanceFromY = Math.abs(z - y);
            if (distanceFromX < distanceFromY){
                System.out.println("Cat A");
            }else if (distanceFromX > distanceFromY){
                System.out.println("Cat B");
            }else{
                System.out.println("Mouse C");
            }
        }
    }
}
