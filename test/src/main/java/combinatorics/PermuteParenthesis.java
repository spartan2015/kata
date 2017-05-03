package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PermuteParenthesis {

	@Test
	public void test() {
		List<char[]> perms = permuteParenthesis(3);
		perms.forEach(perm -> {
			System.out.println(Arrays.toString(perm));
		});

		System.out.println(permuteParenthesisStrings(4));

		System.out.println(permuteParenthesisStringsSecond(3));
		
		printPar(3,3,new char[6], 0);
	}

	public List<String> permuteParenthesisStrings(int i) {
		if (i == 1) {
			return Arrays.asList("()");
		} else {
			List<String> newPerms = new ArrayList<>();
			for (String perm : permuteParenthesisStrings(i - 1)) {
				newPerms.add(perm + "()");
				newPerms.add("(" + perm + ")");
				newPerms.add("()" + perm);
			}
			return newPerms;
		}
	}

	public Set<String> permuteParenthesisStringsSecond(int i) {
		if (i == 1) {
			return new HashSet(Arrays.asList("()"));
		} else {
			Set<String> newPerms = new HashSet<>();
			for (String perm : permuteParenthesisStrings(i - 1)) {
				newPerms.addAll(addNewLevelString(perm));
			}
			return newPerms;
		}
	}

	private Set<String> addNewLevelString(String perm) {
		Set<String> newPerms = new HashSet<>();
		for (int i = 0; i < perm.length(); i++) {
			newPerms.add(perm.substring(0, i) + "()" + perm.substring(i));
		}
		return newPerms;
	}

	private List<char[]> permuteParenthesis(int i) {
		if (i == 1) {
			return Arrays.asList(new char[] { '(', ')' });
		} else {
			ArrayList<char[]> newPermList = new ArrayList<>();
			for (char[] perm : permuteParenthesis(i - 1)) {
				newPermList.addAll(addNewLevel(i * 2, perm));
			}
			return newPermList;
		}
	}

	public List<char[]> addNewLevel(int newSize, char[] perm) {
		ArrayList<char[]> newPermList = new ArrayList<>();
		for (int i = 0; i < newSize; i += 2) {
			char[] newPerm = new char[newSize];
			int newPermIndex = i;
			newPerm[newPermIndex] = '(';
			newPerm[newPermIndex + 1] = ')';
			int permIndex = 0;
			for (int j = 0; j < newSize; j++) {
				if (j < newPermIndex || j > newPermIndex + 1) {
					newPerm[j] = perm[permIndex++];
				}
			}
			newPermList.add(newPerm);
		}
		char[] newPerm = new char[newSize];
		newPerm[0] = '(';
		int permIndex = 0;
		for (int j = 1; j < newSize - 1; j++) {
			newPerm[j] = perm[permIndex++];
		}
		newPerm[newSize - 1] = ')';

		newPermList.add(newPerm);
		return newPermList;
	}

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
