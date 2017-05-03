package hackerRank.bitwise;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;
import java.util.Scanner;

import org.junit.Test;

import utils.TimerUtils;

/**
 * max points achieved
 * 
 * @author vasil
 *
 */
public class XorSequence {

	@Test
	public void test() {
		//computeXorSequence(0, 1);
		assertEquals(Long.valueOf(1), Long.valueOf(computeXorSequence(0, 1)));
		assertEquals(Long.valueOf(2), Long.valueOf(computeXorSequence(0, 2)));
		
		assertEquals(Long.valueOf(2), Long.valueOf(computeXorSequence(1, 2)));
		assertEquals(Long.valueOf(2), Long.valueOf(computeXorSequence(1, 3)));
		assertEquals(Long.valueOf(6), Long.valueOf(computeXorSequence(1, 4)));
		assertEquals(Long.valueOf(2), Long.valueOf(computeXorSequence(1, 5)));
		
		assertEquals(Long.valueOf(7), Long.valueOf(computeXorSequence(2, 4)));
		assertEquals(Long.valueOf(5), Long.valueOf(computeXorSequence(4, 9)));
	}
	
	@Test
	public void tests() {
		
		assertEquals(Long.valueOf(sumTo(2-1)^sumTo(4)), Long.valueOf(computeXorSequence(2,4)));
		
		assertEquals(Long.valueOf(sumTo(2-1)^sumTo(8)), Long.valueOf(computeXorSequence(2,8)));
		
		assertEquals(Long.valueOf(sumTo(5-1)^sumTo(9)), Long.valueOf(computeXorSequence(5,9)));
	}
	
	@Test
	public void testsLar() { // 11 sec
		TimerUtils.timed(()->{
			return Long.valueOf(sumTo(0)^sumTo(Integer.MAX_VALUE)); // finally a damn fast method for xor xequ
		});
	}
	
	@Test
	public void testTimer2(){ // 1 sec
		TimerUtils.timed(()->{
			return computeXorSequence(0, Integer.MAX_VALUE);
		});
		
	}
	
	@Test
	public void test1() {
		computeXorSequence(0,570);
	}


	@Test
	public void testGenerate(){
		assertEquals(Long.valueOf(2), genericPredict(4, 3));
	
	}
	
	@Test
	public void t(){
		assertEquals(Long.valueOf(1), Long.valueOf(powerOf2(0)));
		assertEquals(Long.valueOf(2), Long.valueOf(powerOf2(1)));
		assertEquals(Long.valueOf(4), Long.valueOf(powerOf2(2)));
		assertEquals(Long.valueOf(8), Long.valueOf(powerOf2(3)));
		assertEquals(Long.valueOf(16), Long.valueOf(powerOf2(4)));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();

		for (int a0 = 0; a0 < Q; a0++) {
			long L = in.nextLong();
			long R = in.nextLong();

			//System.out.println(computeXorSequence(L, R));;
			System.out.println(sumTo(L-1)^sumTo(R));;
		}
	}

	static char[] seq = { 0, 1, 3, 0, 4, 1, 7, 0, 8, 1, 1, 0, 2, 1, 5, 0, 6, 1, 9, 0 };

	private static long predict(long R) {
		long c = R / 10;
		int r = (int) (R % 20);
		long result = (R %2==0 ? c * 10 : 0) + seq[r];
		// System.out.println();
		return result;
	}

	private static long computeXorSequence(long L, long R) {
		long prev = predict(L);
		long result = predict(L);
		for (long i = L+1 ; i <= R; i++) { // does no caching in between
			long current = prev ^ i;
			result ^= current;
			System.out.println(String.format("%3s as bit: %8s as xor %10s - sum: %10s -  %10s",i,Long.toString(i,2),Long.toString(current,2),Long.toString(result,2),
					Long.toString(sumTo(i),2)
					));
			//System.out.println(i + " " + current + " " + predict(i) + " " + );
			//if (i >= L && i <= R) {
			//}
			prev = current;
		}
		// System.out.println(prev);
		//System.out.println("result L"+L+":" + Long.bitCount(L) + " ->R" + R+":"+ Long.bitCount(R) + " ->RE" + Long.bitCount(result));
		
		return result;
	}
	
	static long sumTo(long R){
		long mod6 = R+6 % 8;
		if (mod6 ==0 || mod6 == 1) return 2;
		
		long mod8 = R+2 % 8;
		if (mod8 ==0 || mod8 == 1) return 0;
		
		BitSet set = new BitSet();
		set.set(0, predictBit0(R));
		set.set(1, predictBit1(R));
		for(int i = 2; i<63 && i < 64-Long.numberOfLeadingZeros(R);i++){
			set.set(i, genericPredict(R, i+1));
		}
		long[] longArray = set.toLongArray();
		return longArray.length > 0 ? longArray[0] : 0;
	}

	private static boolean genericPredict(long R, int bitNo) {
		return generateList((R+powerOf2(bitNo-1)) % powerOf2(bitNo), powerOf2(bitNo-1));
	}

	private static boolean generateList(long modResult, long n) {
		if (modResult == 0) return true;
//		TimerUtils.timed(()->{
//		System.out.println("for n: " + n);
			return modResult < n && (modResult % 4 == 0 || (modResult-1)%4==0);
//			boolean ones = true;
//			for(long i =0; i < n; i++){
//				if (ones){
//					if (i == modResult) return true;
//				}
//				if ((i+1)%2 == 0) ones = !ones;
//			}
//			
//			return false;
//		});
		//return false;
	}
	
	private static boolean predictBit1(long R) {
		//return generateList(2).contains((R+2) % 4)  ? true : false;
		return ((R+2) / 4) %2 == 0  ? false : true;
	}
	
	private static boolean predictBit0(long R) {
		//return generateList(2).contains((R+0) %4 )  ? true : false;
		return R % 4 == 0 || R%4!=1 ? false : true;
	}
	static long[] powersOf2 = new long[65]; 
	
	
	
	private static long powerOf2(int bitNo) {
		if (bitNo==0) return 1;
		
		if (powersOf2[bitNo]==0)  powersOf2[bitNo] = powerOf2(bitNo-1) * 2;
		
		return powersOf2[bitNo];
	}
	
	
	
	static String bitToString(boolean value){
		if (value) return "1";
		else return "0";
	}
	
	private static boolean predictBit4(long R) {
		return generateList((R+16) % 32, 16);
	}
	
	private static boolean predictBit3(long R) {
		return generateList((R+8) % 16, 8);
	}
	
	private static boolean predictBit2(long R) {
		return generateList((R+4) % 8, 4);
	}
	
	
	
	
}
