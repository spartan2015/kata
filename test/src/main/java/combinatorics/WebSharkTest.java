package combinatorics;

import org.junit.Test;

public class WebSharkTest {
	@Test
	public void createSubLevelsTest(){
		WetSharkSubsequence instance = new WetSharkSubsequence((byte)5,(short)7,(short)1,new short[]{2,3,4,5,6});
		System.out.println("matched: " + instance.match() % 1000_000_007);
	}
	
	@Test
	public void createSubLevelsTest2(){
		WetSharkSubsequence instance = new WetSharkSubsequence((byte)4,(short)5,(short)3,new short[]{1,1,1,4});
		System.out.println("matched: " + instance.match() % 1000_000_007);
	}
	
	
	
}
