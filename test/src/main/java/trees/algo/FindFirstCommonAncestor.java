package trees.algo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import trees.structures.TreeNode;

public class FindFirstCommonAncestor {
	@Test
	public void test() {
		TreeNode<Integer> root = new MinHeightTreeFromSortedArray()
				.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 9, null);
		//new DrawTrees().draw(root);
		assertTrue(5 == findCommonAncestor(root, 3,7).value);
		reset();
		assertTrue(5 == findCommonAncestor(root, 1,9).value);
		reset();
		assertTrue(3 == findCommonAncestor(root, 2,4).value);
		reset();
		assertTrue(3 == findCommonAncestor(root, 1,4).value);
		reset();
		assertTrue(5 == findCommonAncestor(root, 1,7).value);
		reset();
		assertTrue(8 == findCommonAncestor(root, 6,9).value);
	}

	private void reset() {
		commonAncestor = null;
	}
	
	private TreeNode<Integer> findCommonAncestor(TreeNode<Integer> node, int i, int j){
		findCommonAncestorHelper(node, i, j);
		return commonAncestor;
	} 
	
	private TreeNode<Integer> commonAncestor;
	private void findCommonAncestorHelper(TreeNode<Integer> node, int i, int j) {
		if (node == null){
			return;
		}
		if (commonAncestor!=null ){
			return;
		}
		boolean left =findNode(node.left, i);
		if (left && commonAncestor == null){
			findCommonAncestor(node.left, i, j);
		}
		boolean right = findNode(node.right, j);

		if (left && right && commonAncestor == null){
			commonAncestor = node;
		}
		if (right && commonAncestor == null){
			findCommonAncestor(node.right, i, j);
		}
	}

	private boolean findNode(TreeNode<Integer> node, int i) {
		if (node == null) return false;
		if (node.value == i){
			return true;
		}
		return findNode(node.left,i) || findNode(node.right,i);
	}
}
