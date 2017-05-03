package recursive;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrintParenthsis {

	@Test
	public void test() {
		printPar(3,3,new char[6], 0);
	}
	
	/**
	 * nice recursion 
	 * 
	 * @param l
	 * @param r
	 * @param store
	 * @param index
	 */
	public void printPar(int l, int r, char[] store, int index) {
		if (l < 0 || r < l) {
			return;
		} else if(l ==0 && r == 0){
			System.out.println("=" + new String(store));
		}else {
			if (l > 0) {
				store[index] = '(';
				printPar(l - 1, r, store, index + 1);
			}
			if (r > l) {
				store[index] = ')';
				printPar(l, r - 1, store, index + 1);
			}
		}
	}
}
