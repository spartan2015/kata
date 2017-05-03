package trees.algo.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InOrderSuccessor {

	@Test
	public void test() {
		TreeNode<Integer> root = SortedArrayToBinaryTree.arrayToBinaryTree(new Integer[] { 1, 2, 3, 4, 5 });

		assertEquals(inOrderSuccessor(1, root), Integer.valueOf(2));
		assertEquals(inOrderSuccessor(2, root), Integer.valueOf(3));
		assertEquals(inOrderSuccessor(3, root), Integer.valueOf(4));
		assertEquals(inOrderSuccessor(4, root), Integer.valueOf(5));
		assertNull(inOrderSuccessor(5, root));
	}

	private Integer inOrderSuccessor(int i, TreeNode<Integer> root) {
		TreeNode<Integer> node = findNode(root, i);
		if (node == null){
			return null;
		}
		TreeNode<Integer> successor = node.right!= null ? findFirst(node.right) : null;
		if (successor != null){
			return successor.value;
		}
		successor = node.parent != null ? findParent(node.parent, i)  : null;
		if (successor != null){
			return successor.value;
		}
		return null;
	}

	private TreeNode<Integer> findParent(TreeNode<Integer> parent, int i) {
		if (parent == null) return null;
		if (parent.value > i){
			return parent;
		}else{
			return findParent(parent.parent,i);
		}
		
	}

	private TreeNode<Integer> findFirst(TreeNode<Integer> node) {
		if (node.left != null){
			return findFirst(node.left);
		}
		return node;
	}

	private TreeNode<Integer> findNode(TreeNode<Integer> node, int i) {
		if (node == null) return null;
		if (node.value.equals(i)) return node;
		if (less(i, node.value)){
			return findNode(node.left,i);
		}else{
			return findNode(node.right,i);
		}		
	}

	private boolean less(int i, Integer value) {
		return i - value < 0;
	}

}
