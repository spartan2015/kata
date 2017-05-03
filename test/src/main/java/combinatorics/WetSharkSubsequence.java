package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 
 * @author vasil
 *
 *
 *         // elements are between 1 and 2000 // always between 0 and 2000 -
 *         discard anything between 0 and 2000 // INCLUSIVE - so if you get 2000
 *         you can only match it with one that // has 0 sum - which // (in
 *         distinct elements is 0 - in non distinctive elements is as many //
 *         zeroes) // sum is always positive (r) and // diff is always positive
 *         (s)
 */
/**
 * 
 * only 5 timeouts - so guesing performance issue
 * rest working
 *
input5 witch timeouts on their machine on mine has diff result:

Match count: 290230319 vs expected 160921269 - for a 250=250 case 500 0 peculiar case
3
 * 
 * improve String parsing
 * 
 * @author vasil
 *
 *
 *
 *
 */
public class WetSharkSubsequence {
	/**
	 * the length of the original array (input)
	 */
	private byte m;
	// sum of sum
	private short r;
	// sum of diff
	private short s;

	/**
	 * orig data
	 * 
	 */
	private short[] data;
	private long match = 0;

	private long[] isItWorthIt;
	
	private List<CombinationInfo> prevCombinationHere;
	private int xCount= 0;
	private int yCount=0;
	
	public WetSharkSubsequence(byte m, short r, short s, short[] data) {
		this.m = m;
		this.r = r;
		this.s = s;
		this.data = data;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Scanner sc = new Scanner(System.in);

		String headerLine = sc.nextLine();
		
		short[] intParts = toIntArray(headerLine);
		byte m = (byte)intParts[0];
		short r = intParts[1];
		short s = intParts[2];
		
		short[] data = new short[m];
		
		int index = 0;
		while(index < m){
			 data[index++]= sc.nextShort();
		}
		
		Arrays.sort(data);
		short[] reverse = new short[m];
		for(int i =0; i<m; i++){
			reverse[m-1-i]=data[i];
		}
		data=null;
		
		System.out.println("Match count: " + new WetSharkSubsequence((byte)m, (short)r, (short)s, reverse).match() % 1_000_000_007);
		System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start));
	}

	private void validate() {
		if (m != data.length) {
			throw new IllegalArgumentException(
					String.format("data size[%d] is not equals with m[%d] size.", data.length, m));
		}
		checkBounds(m, 1, 100);
		checkBounds(r, 0, 2000);
		checkBounds(s, 0, 2000);
	}

	private static void checkBounds(int m, int lower, int upper) {
		if (!(m >= lower && m <= upper)) {
			throw new IllegalArgumentException("m >= " + lower + " && m <=" + upper);
		}
	}

	public long match() {
		validate();

		int x = (r + s) / 2;
		int y = r - x;

		isItWorthIt = new long[m];
		for(int i = 0; i < m; i++){
			long sum = 0;
			for(int j = i+1; j < m; j++){
				sum+=data[j];
//				if (sum > x){
//					break;
//				}
			}
			isItWorthIt[i] = sum;
		}
		
		for (byte seqLength = 2; seqLength < m; seqLength++) {
			combinations(seqLength, x, y);
		}
		return match;
	}

	private void combinations(byte seqLength, int x, int y) {
		if (seqLength == 1){
			prevCombinationHere = new ArrayList<>();
			
			int xCount= 0;
			int yCount=0;	
			
			for(byte i = 0 ; i < data.length; i++){
				if (data[i] < x){
					prevCombinationHere.add(new CombinationInfo(i, data[i]));
				}
				if (data[i] == y) yCount++;
				if (data[i] == x) xCount++;
			}
			
			match+=xCount*yCount;
			//System.out.println("length: " + seqLength + " size: " + prevCombinationHere.size() + " matchest here: " + (xCount*yCount) + " matches: " +match);
		}else{
			if (prevCombinationHere == null) {combinations((byte)(seqLength-1), x,y);}
			
			if (prevCombinationHere.size() ==0) return;
			
			List<CombinationInfo> prevCombs = prevCombinationHere;
			
			xCount= 0;
			yCount=0;
			
			
//			if (prevCombs.size() > 5_000_000){
//				
//				prevCombinationHere = prevCombs.parallelStream().flatMap(combination->{
//					List<CombinationInfo> newCombinations = new ArrayList<CombinationInfo>();
//					
//					for(int i = (combination.lastIndex+1); i < data.length; i++){
//						
//						int newSum = data[i] + combination.sum;
//						if (newSum > x){ continue; }
//						if (newSum + isItWorthIt[i] < y){
//							//System.out.println("skip: " + newSum + " + " +  isItWorthIt[i] + " at i " + i);
//							continue;
//						}
//						CombinationInfo newComb = new CombinationInfo((byte)i, newSum);
//						
//						if (newComb.sum == y){
//							yCount++;
//						}
//						if (newComb.sum == x){
//							xCount++;
//						}
//						
//						newCombinations.add(newComb);
//					}
//					
//					return newCombinations.stream();
//					
//				}).collect(Collectors.toList());
//				
//			}else{
				prevCombinationHere = new ArrayList<>();
				
				for(CombinationInfo combination : prevCombs){
					for(int i = (combination.lastIndex+1); i < data.length; i++){
						
						int newSum = data[i] + combination.sum;
						if (newSum > x){ continue; }
						if (newSum + isItWorthIt[i] < y){
							//System.out.println("skip: " + newSum + " + " +  isItWorthIt[i] + " at i " + i);
							continue;
						}
						CombinationInfo newComb = new CombinationInfo((byte)i, newSum);
						
						if (newComb.sum == y){
							yCount++;
						}
						if (newComb.sum == x){
							xCount++;
						}
						
						prevCombinationHere.add(newComb);
					}
				
				};
//			}
			
			//System.out.println("length: " + seqLength + " size: " + prevCombinationHere.size() + " matchest here: " + (x == y ? (xCount/2) * (xCount/2)  : xCount*yCount) + " - " + xCount  + " matches: " +match);
			long result = 0;
					if (x == y){
						long inter =  xCount/2;
						result = inter*inter;
					} else{
						result = xCount*yCount;
					}
			match+= result;
		}
	}
	
	public static class CombinationInfo {
		byte lastIndex;
		int sum;
		
		CombinationInfo(byte lastIndex, int sum){
			this.lastIndex = lastIndex;
			this.sum = sum;
		}
	}
	
	private static short[] toIntArray(String headerLine) {
		String[] headerParts = headerLine.split(" ");
		short[] intParts = new short[headerParts.length];
		for (int i = 0; i < headerParts.length; i++) {
			intParts[i] = Short.valueOf(headerParts[i]);
		}
		return intParts;
	}
}
