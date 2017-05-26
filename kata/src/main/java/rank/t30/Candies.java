package hackerRank.t30;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class Candies {

	@Test
	public void test(){
		assertEquals(Long.valueOf(11), Long.valueOf(replenishedCandies(8, 4,  new int[]{3,1,7,5})));
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxNoOfCandies = in.nextInt();
        
        int maxTimeSlots = in.nextInt();
        
        int[] removedCandiesPerTimeSlot = new int[maxTimeSlots];
        
        for(int index=0; index < maxTimeSlots; index++){
            removedCandiesPerTimeSlot[index] = in.nextInt();
        }
        
        int noOfCandiesReplenished = replenishedCandies(maxNoOfCandies, maxTimeSlots, removedCandiesPerTimeSlot);
        
        System.out.println(noOfCandiesReplenished);
    }

	private static int replenishedCandies(int maxNoOfCandies,int allTimeSlots, int[] removedCandiesPerTimeSlot) {
		int noOfCandiesInBowl = maxNoOfCandies;
        int noOfCandiesReplenished = 0;
        for(int slot = 0; slot < allTimeSlots-1; slot++){
        	noOfCandiesInBowl-=removedCandiesPerTimeSlot[slot];
        	// robo replenishes
        	if (noOfCandiesInBowl < 5){
        		int howManyWereReplenished = maxNoOfCandies - noOfCandiesInBowl;
        		noOfCandiesReplenished+=howManyWereReplenished;
        		noOfCandiesInBowl = maxNoOfCandies;
        	}
        }
		return noOfCandiesReplenished;
	}
}
