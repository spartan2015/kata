package trees.algo.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsT2aSubtreeOfT1 {

	@Test
	public void test() {
		TreeNode<Integer> t1 = SortedArrayToBinaryTree
				.arrayToBinaryTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		TreeNode<Integer> t2 = SortedArrayToBinaryTree.arrayToBinaryTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		TreeNode<Integer> t2_2 = SortedArrayToBinaryTree.arrayToBinaryTree(new Integer[] { 9, 10, 11, 12, 13, 14, 15 });

		TreeNode<Integer> t2_1 = SortedArrayToBinaryTree.arrayToBinaryTree(new Integer[] { 1, 2, 3 });

		TreeNode<Integer> t2_3 = SortedArrayToBinaryTree.arrayToBinaryTree(new Integer[] { 9, 10, 11, });
		TreeNode<Integer> t2_4 = SortedArrayToBinaryTree.arrayToBinaryTree(new Integer[] { 13, 14, 15 });

		assertTrue(isSubtree(t1, t2));
		assertTrue(isSubtree(t1, t2_2));
		
		assertTrue(isSubtree(t1, t2_1));
		
		assertTrue(isSubtree(t1, t2_3));
		
		assertTrue(isSubtree(t1, t2_4));
		
		t2_4.left.left=new TreeNode(3);
		assertFalse(isSubtree(t1, t2_4));

	}

	private boolean isSubtree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		if (t1 == null || t2 == null)
			return false;
		if (match(t1, t2)) {
			return true;
		} else {
			return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
		}
	}

	private boolean match(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		if (t1 == null && t2 != null)
			return false;
		if (t1 != null && t2 == null)
			return false;
		if (t1 != null && t2 != null) {
			if (!t1.value.equals(t2.value)) {
				return false;
			} else {
				return match(t1.left, t2.left) && match(t1.right, t2.right);
			}
		} else {
			return true;
		}
	}
}
