package bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhichNumberWasNotMentioned {

	@Test
	public void test(){
		assertTrue(2 == firstNumberWhichNumberWasNotMentioned(new int[]{0,1,3,4,5,6}, 7));
		
		assertTrue(7 == firstNumberWhichNumberWasNotMentioned(new int[]{0,1,2,3,4,5,6}, 7));
	}

	/**
	 * how many distinct integers can be tracked this way ?
	 * 8 per byte
	 * 8 * 1024 per kb
	 * 8 * 1024^2 per mb
	 * 8 * 1024^3 per gb - which is like 8.5 billion integers / per gb of memory
	 * 
	 * what if we don't have that much memory but would need to track 8 billion integers - chunk them
	 * 10mb chunks - 8 * 10 * 1024^2 - this is the chunk size - so from 0 to 10mb/
	 * 
	 * @param is
	 * @param max
	 * @return
	 */
	public int  firstNumberWhichNumberWasNotMentioned(int[] is, int max) {
		byte[] numberPerBitArray = new byte[1 + max / 8]; //how many bytes we need to set on and off for range 0 to max
		for(int i : is){
			numberPerBitArray[i/8] |= 1 << i % 8;
		}
		for(int currentByte = 0; currentByte < numberPerBitArray.length; currentByte++){
			for(int bit=0; bit < 8; bit++){
				if ((numberPerBitArray[currentByte] & (1 << bit)) == 0){
					return currentByte * 8 + bit;
				}
			}
		}
		return -1;
	}

	/**
	 * chunking for appropriate size
	 * 
	 * 
	 * @param is - this really should be an InputStream in real world scenarios or new Scanner(file) 
	 * @param max
	 * @param chunkSize
	 * @return
	 */
	public int firstNumberWhichNumberWasNotMentioned(int[] is, int max, int chunkSize) {
		int[] counters = new int[max / chunkSize];
		for(int i : is){
			counters[i / chunkSize]++;
		}
		
		// find first counter that is missing a value 
		for(int chunkNo = 0; chunkNo < counters.length; chunkNo++){			 
			if (counters[chunkNo] < chunkSize){ 
				return findMissingNumberInChunk(is, chunkSize, chunkNo);
			}
		}
		return -1;
	}

	public int findMissingNumberInChunk(int[] is, int chunkSize, int chunkNo) {
		final byte[] bitfield = new byte[chunkSize /8 + 1];
		for(final int n : is){
			if (n >= chunkNo * chunkSize && n < chunkNo* (chunkSize+1)){
				final int byteNoInBitField = n - chunkNo * chunkSize;
				bitfield[byteNoInBitField/8] |= 1 << byteNoInBitField % 8; 
			}
		}
		for(int byteNo=0; byteNo< bitfield.length; byteNo++){
			for(int bitNo=0; bitNo<8; bitNo++){
				if ((bitfield[byteNo * 8] & 1 << bitNo) == 0){
					return byteNo * 8 + bitNo;
				}
			}
		}
		return -1;
	}
}
