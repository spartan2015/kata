package trees.algo.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommonAncestorInARandomBinaryTree {

	@Test
	public void test() {
		TreeNode<Integer> root = new TreeNode<>(3);

		root.left = new TreeNode(1);
		root.right = new TreeNode(4);

		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(3);
		
		assertNull(findAncestor(root, -1, 3));
		assertEquals(Integer.valueOf(3), findAncestor(root, 0, 11));
		
		assertEquals(Integer.valueOf(1), findAncestor(root, 0, 5));
		
		assertEquals(Integer.valueOf(3), findAncestor(root, 1, 4));
		
		assertEquals(Integer.valueOf(4), findAncestor(root, 11, 6));
		
		assertEquals(Integer.valueOf(4), findAncestor(root, 11, 3));
		
	}

	private Integer findAncestor(TreeNode<Integer> node, int i, int j) {
		if (node == null)
			return null;
		TreeNode<Integer> inLeft = findNode(node.left, i);
		if (inLeft == null){
			return findAncestor(node.right,i,j);
		}else{
			TreeNode<Integer> inRight = findNode(node.right,j);
			if (inRight!= null) return node.value;
			else{
				return findAncestor(node.left,i,j);
			}
		}
	}

	private TreeNode<Integer> findNode(TreeNode<Integer> node, int i) {
		if (node == null)
			return null;
		if (node.value.equals(i)) {
			return node;
		} else {
			TreeNode<Integer> n = findNode(node.left, i);
			if (n != null)
				return n;
			return findNode(node.right, i);
		}
	}

}
