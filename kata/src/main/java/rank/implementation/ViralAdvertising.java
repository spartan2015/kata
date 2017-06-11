package rank.implementation;

import java.util.Scanner;

/**
 * Created on 6/11/2017.
 *
 * HackerLand Enterprise is adopting a new viral advertising strategy. When they launch a new product, they advertise it to exactly

 people on social media.
 On the first day, half of those

 people (i.e.,












 ) like the advertisement and each person shares it with

 of their friends; the remaining people (i.e.,














 ) delete the advertisement because it doesn't interest them. So, at the beginning of the second day,


















 people receive the advertisement.
 On the second day, half of the

 people who received the advertisement share it with

 new friends. So, at the beginning of the third day,


















 people receive the advertisement. The diagram below depicts the advertisement's virality over the first three days (green denotes a person that likes the advertisement and red denotes a person that disliked and deleted it):
 */
public class ViralAdvertising {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = 2;
        int lastLiked = 2;
        for(int i =0; i< n-1; i++){
            lastLiked = Math.floorDiv(lastLiked * 3,2);
            start += lastLiked;
        }
        System.out.println(start);
    }
}
