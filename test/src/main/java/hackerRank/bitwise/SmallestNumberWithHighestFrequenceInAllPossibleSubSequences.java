package hackerRank.bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import utils.TimerUtils;

public class SmallestNumberWithHighestFrequenceInAllPossibleSubSequences {

	private int[] data;
	int[] frequencies = new int[65536];

	int maxFreqNo = -1;
	int maxFreq = -1;

	public SmallestNumberWithHighestFrequenceInAllPossibleSubSequences(Scanner in, int maxNo) {
		this.data = TimerUtils.timed(() -> readArr(in, maxNo));
		;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int maxNo = in.nextInt();
		SmallestNumberWithHighestFrequenceInAllPossibleSubSequences minmax = new SmallestNumberWithHighestFrequenceInAllPossibleSubSequences(
				in, maxNo);

		System.out.println("fre" + minmax.frequencies[40682]);
		
		TimerUtils.timed(() -> {
			minmax.combinations(maxNo);
			return null;
		});
		// is there a colrelation between highst frequencies and 40628 - the bits of this number 
		System.out.println(Arrays.toString(minmax.frequencies));
		System.out.println("max" + Arrays.stream(minmax.data).summaryStatistics().getMax());
		System.out.println("max" + Arrays.stream(minmax.data).summaryStatistics().getMin());
		System.out.println("max" + Arrays.stream(minmax.data).summaryStatistics().getAverage());
//		System.out.println("max " + minmax. maxNo);
//		System.out.println(minmax.maxFreqNo + " " + minmax.maxFreq);
		System.out.println(Integer.toString(40682,2));
		System.out.println(Integer.toString(minmax.maxNo,2));
//		System.out.println(Integer.toString(minmax.count16BitSet,2));
//		System.out.println(minmax.count16BitSet);
		
		
	}

	int maxNo;
	int count16BitSet;
	
	public int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		
		int[] fre0 = new int[16];
		int[] fre1 = new int[16];
		
		for (int i = 0; i < n; i++) {
			int nextInt = (int) in.nextInt();
			
			for(int b = 0; b< 16; b++ ){
				if ( (nextInt & 1<<b) == 0){
					fre0[b]++;
				}else{
					fre1[b]++;
				}
			}
			
			addFound(nextInt);
			maxNo ^= nextInt;
			//if ((nextInt & 1<<15)!=0) count16BitSet++;
			ar[i] = nextInt;
		}
		
//		for(int i =0; i < 16; i++){
//			System.out.println(fre0[i] + "  " + fre1[i]);
//			
//		}
		int count = 0;
		List<Integer> list= new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if ((ar[i]&maxNo)==0){
				count++;
				list.add(ar[i]);
			}
		}
		System.out.println(list.stream().mapToInt(i->i).summaryStatistics().getMin());
		System.out.println(list.stream().mapToInt(i->i).summaryStatistics().getMax());
		System.out.println(list.stream().mapToInt(i->i).summaryStatistics().getAverage());
		System.out.println("counter " + count);
		return ar;
	}

	/**
	 * well thinkin xoring large contiguous memory chunks - 64 bit longs - so 4
	 * x 16 - problem is a bitch to cut longs across longs
	 * 
	 * maybe bitsets - maybe other large data structures
	 * 
	 * there is xor in Bitset - but xoring is really not my biggest problems
	 * 
	 * incrementing the frequency is...
	 * 
	 * think differently - same array index indexed with all values next indexed
	 * with all value, etc - would address the 8 second bottleneck - lots of
	 * cache miss
	 * 
	 * do a lot of memory intensive work on single not sure how that is
	 * possible...that would mean to anticipate the result of xoring.
	 * 
	 * idea would be to have fewer writes...a buffer would mean more writes...
	 * 
	 * lots of dupes 100k no up to 65536 val
	 * 
	 * tried: secondary thread - horror of sync...incredible times -
	 * 
	 * tries sorting - nope - omg - added overtime +
	 * 
	 * tried intermediary buffer - nooooooope.... added overhead increased times
	 * 
	 * tried HUGE buffer - again no.
	 * 
	 * @param max
	 */
	private void combinations(int max) {
		//int[] d2 = data.clone();
		
		for (int i = 0; i < data.length; i++) {
			int d1 = data[i];
//			int count = 0;
			for (int j = i + 1; j < data.length; j++) {
				d1 ^= data[j];
				
//				(d1 ==40682)
//					count++;
				addFound(d1); // cut 6 seconds here. - how can we make this predictable ?
			}
//			System.out.println(count);
			
		}
	}
	
	private void addFound(int foundNo) {
			frequencies[foundNo]++;
			int freq = frequencies[foundNo];
			if (freq > maxFreq) {
				maxFreqNo = foundNo;
				maxFreq = freq;
			} else if (freq == maxFreq) {
				if (maxFreqNo > foundNo) {
					maxFreqNo = foundNo;
				}
			}
	}

}
