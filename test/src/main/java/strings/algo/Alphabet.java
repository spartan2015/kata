package strings.algo;

public interface Alphabet {

	/**
	 * index to char
	 * 
	 * @param index
	 * @return
	 */
	char toChar(int index);
	
	int toIndex(char c);
	
	boolean contains(char c);
	
	/**
	 * number of characters in the alphabet
	 * 
	 * @return
	 */
	int R();
	
	/**
	 * number of bits to represent an index 
	 * 
	 * @return
	 */
	int lgR();
	
	/**
	 * convert a string to base-R integers
	 * @param s
	 * @return
	 */
	int[] toIndices(String s);
	
	/**
	 * convert base R integers to string using the Alphabet
	 * 
	 * @param indices
	 * @return
	 */
	String toChars(int[] indices);
	
	
}
