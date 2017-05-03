package combinatorics.s2;

import org.junit.Test;

public class ProperlyOpenedAndClosedCombinationsOfParenthsis {

	@Test
	public void test(){
		combinationOfParenthesis(3);
	}

	private void combinationOfParenthesis(int i) {
		combinations(i,i,"");
	}

	private void combinations(int left, int right, String comb) {
		if (left == 0 && right == 0){
			System.out.println(comb);
		}
		if (left > 0){
			combinations(left-1,right, comb+"(");
		}
		if (left < right && right > 0 ){
			combinations(left, right-1,comb+")");
		}
	}
	
}
