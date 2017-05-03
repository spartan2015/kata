package strings.algo;

public class Alphabet26 implements Alphabet{

	@Override
	public char toChar(int index) {
		return (char)(index + 97);
	}

	@Override
	public int toIndex(char c) {
		
		return c - 97;
	}

	@Override
	public boolean contains(char c) {
		int index = c - 97;
		return index >= 0 && index < 26 ;
	}

	@Override
	public int R() {
		return 26;
	}

	@Override
	public int lgR() {
		return 0;
	}

	@Override
	public int[] toIndices(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toChars(int[] indices) {
		// TODO Auto-generated method stub
		return null;
	}

}
