package trees.algo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import trees.structures.BinaryTree;
import trees.structures.TreeNode;

public class IsTreeBalanced {

	@Test
	public void test() {
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		bt.root = new TreeNode<Integer>(5);
		bt.root.left = new TreeNode<>(4);
		bt.root.left.left = new TreeNode<>(3);
		assertFalse(isTreeBalanced(bt.root));
		assertFalse(isTreeBalancedMinMaxDepth(bt.root));
		bt.root.left.left = null;
		assertTrue(isTreeBalanced(bt.root));
		assertTrue(isTreeBalancedMinMaxDepth(bt.root));
		bt.root.left.left = new TreeNode<>(3);
		bt.root.right = new TreeNode<>(6);
		bt.root.right.right = new TreeNode<>(7);
		bt.root.right.right.right = new TreeNode<>(7);
		assertFalse(isTreeBalanced(bt.root));
		assertFalse(isTreeBalancedMinMaxDepth(bt.root));
		bt.root.right.right.right = null;
		bt.root.right.right.left = new TreeNode<>(6);
		assertFalse(isTreeBalanced(bt.root));
		assertFalse(isTreeBalancedMinMaxDepth(bt.root));
	}

	/**
	 * min max depth comparison
	 * 
	 * @param root
	 * @return
	 */
	public boolean isTreeBalancedMinMaxDepth(TreeNode root){
		return maxDepth(root) - minDepth(root) <=1; 
	}
	
	public static int minDepth(TreeNode node) {
		if (node == null) return 0;
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}

	public static int maxDepth(TreeNode node) {
		if (node == null) return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	private boolean isTreeBalanced(TreeNode<Integer> root) {
		computeBalanceFactor(root,0);
		return isTreeNodeBalanced(root);
	}

	private boolean isTreeNodeBalanced(TreeNode<Integer> node) {
		if (isNotBalanced(node)){
			return false;
		}else{
			if (isNotBalanced(node.left)){
				return false;
			}else if (isNotBalanced(node.right)){
				return false;
			}
		}
		return true;
	}

	private boolean isNotBalanced(TreeNode<Integer> node) {
		if (node == null) return false;
		return node.balance > 1;
	}

	private int computeBalanceFactor(TreeNode<Integer> node, int prevHeight) {
		if (node == null) {
			return prevHeight;
		}
		int left = computeBalanceFactor(node.left, prevHeight + 1);
		int right = computeBalanceFactor(node.right, prevHeight + 1);
		node.balance = Math.abs(left - right);
		return Math.max(left, right);
	}
}