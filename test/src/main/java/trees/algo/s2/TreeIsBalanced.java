package trees.algo.s2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TreeIsBalanced {
	@Test
	public void test(){
		BinaryTree<Integer> bst = new BinaryTree<>();
		bst.add(4);
		bst.add(2);
		bst.add(1);
		bst.add(0);
		bst.add(3);
		bst.add(6);
		bst.add(5);
		bst.add(7);
		
		assertTrue(isBalanced(bst.root));
		
		bst.add(9);
		
		assertTrue(isBalanced(bst.root));
		
		bst.add(10);
		
		assertFalse(isBalanced(bst.root));
	}
	
	public boolean isBalanced(TreeNode node){
		if (node == null) return true;
		if (Math.abs(height(node.left) - height(node.right)) > 1){
			return false;
		}
		return isBalanced(node.left) && isBalanced(node.right);
	}
	
	public int height(TreeNode node){
		if (node == null) return 0;
		return 1 + Math.max(height(node.left),height(node.right));
	}
	
}
