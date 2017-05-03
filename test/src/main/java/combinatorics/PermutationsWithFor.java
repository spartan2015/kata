package combinatorics;

import java.util.ArrayList;

import datastructures.LocalIntStack;

public class PermutationsWithFor {
	static ArrayList<LocalIntStack> permutations(LocalIntStack stack) {
		ArrayList<LocalIntStack> ret = new ArrayList<LocalIntStack>();
		permutation(stack, 0, ret);
		return ret;
	}

	public static void permutation(LocalIntStack stack, int pos, ArrayList<LocalIntStack> list) {
		if (stack.currentIndex - pos == 1)
			list.add(new LocalIntStack().copy(stack)); // creates a copy
		else
			for (int i = pos; i < stack.currentIndex; i++) {
				swap(stack, pos, i);
				permutation(stack, pos + 1, list);
				swap(stack, pos, i);
			}
	}

	public static void swap(LocalIntStack stack, int pos1, int pos2) {
		int h = stack.arr[pos1];
		stack.arr[pos1] = stack.arr[pos2];
		stack.arr[pos2] = h;
	}
}
