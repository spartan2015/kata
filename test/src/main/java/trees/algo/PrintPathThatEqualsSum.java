package trees.algo;

import java.util.LinkedList;

import org.junit.Test;

import trees.structures.TreeNode;

public class PrintPathThatEqualsSum {
	@Test
	public void test() {
		TreeNode<Integer> mainTree = new MinHeightTreeFromSortedArray()
				.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 9, null);

		printPathEqual(mainTree, 10, new LinkedList());
	}

	private void printPathEqual(TreeNode<Integer> node, int sum, LinkedList<Integer> path) {
		if (node == null) {
			// remove one by one and check
			Integer val = null;
			while ((val = path.poll()) != null) {
				checkPath(sum, path);
			}
			return;
		}

		path.offer(node.value);
		checkPath(sum, path);

		printPathEqual(node.left, sum, new LinkedList(path));
		printPathEqual(node.right, sum, new LinkedList(path));
	}

	private void checkPath(int sum, LinkedList<Integer> path) {
		System.out.println(path);
		if (path.stream().mapToInt(integer -> integer.intValue()).sum() == sum) {
			System.out.println("indeed");
		}
	}
}
