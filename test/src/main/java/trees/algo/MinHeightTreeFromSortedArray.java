package trees.algo;

import org.junit.Test;

import trees.structures.TreeNode;

public class MinHeightTreeFromSortedArray {

	public <E extends Comparable<E>> TreeNode<E> createTree(Comparable<E>[] sortedArray, int start, int end, TreeNode<E> parent) {
		if (end == start) return null;
		int mid = (start + end) / 2;
		TreeNode<E> node = new TreeNode(sortedArray[mid]);
		node.parent = parent;
		node.left = createTree(sortedArray, start, mid, node);
		node.right = createTree(sortedArray, mid + 1, end, node);
		return node;
	}

	@Test
	public void test() {
		TreeNode<Integer> root = createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 9, null);
		new DrawTrees().draw(root);
	}
}
