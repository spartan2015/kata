package trees.algo;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import trees.structures.TreeNode;

public class FindNextNodeInOrderSuccession {
	@Test
	public void test() {
		TreeNode<Integer> root = new MinHeightTreeFromSortedArray()
				.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 9, null);

		assertTrue(4 == findInOrderSuccessor(root, 3).value);
		before();
		assertTrue(2 == findInOrderSuccessor(root, 1).value);
		before();
		assertTrue(6 == findInOrderSuccessor(root, 5).value);

	}

	@Before
	public void before() {
		foundNode = null;
		found = false;
	}

	private TreeNode<Integer> foundNode = null;
	private boolean found = false;

	private TreeNode<Integer> findInOrderSuccessor(TreeNode<Integer> node, int i) {
		findSuccessor(node, i);
		return foundNode;
	}

	private void findSuccessor(TreeNode<Integer> node, int i) {
		if (node == null || foundNode != null)
			return;
		findSuccessor(node.left, i);
		if (found && foundNode == null) {
			foundNode = node;
			return;
		}
		if (node.value == i) {
			found = true;
		}
		findSuccessor(node.right, i);
	}
}
