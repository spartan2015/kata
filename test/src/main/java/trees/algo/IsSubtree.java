package trees.algo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import trees.structures.TreeNode;

public class IsSubtree {
	@Test
	public void test() {
		TreeNode<Integer> mainTree = new MinHeightTreeFromSortedArray()
				.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 9, null);
		
		TreeNode<Integer> secondTreeNode = new MinHeightTreeFromSortedArray()
				.createTree(new Integer[] {6, 7, 8, 9 }, 0, 4, null);
	
		// for every node of first tree - match with second tree
		assertTrue(subTree(mainTree,secondTreeNode));
		
		//my first aproach - find node then match trees
		TreeNode< Integer> firstTreeNode = findNode(mainTree, secondTreeNode);		
		assertTrue(8 == firstTreeNode.value);
		assertTrue(matchTrees(firstTreeNode, secondTreeNode));
		
		// could also do a inOrder traversal - of both - obtain strings from them and then compare them with Boyers Moore algo - for small data
	}

	private TreeNode<Integer> findNode(TreeNode<Integer> node, TreeNode<Integer> nodeToFind) {
		if (node == null) return null;
		if (node.value == nodeToFind.value){
			return node;
		}
		TreeNode<Integer> left = findNode(node.left,nodeToFind);
		if (left != null) return left;
		return findNode(node.right,nodeToFind);
	}

	private boolean subTree(TreeNode<Integer> tree1, TreeNode<Integer> tree2){
		if (tree2 == null) return true;
		if (tree1 == null) return false;
		System.out.println("tree1: " + tree1.value + " with " + tree2.value);
		if (tree1.value == tree2.value){
			if ( matchTrees(tree1, tree2)) return true; // if not let it continue
		}
		return subTree(tree1.left, tree2) || subTree(tree1.right, tree2); // for each node of tree 1
	}
	
	private boolean matchTrees(TreeNode<Integer> secondTreeNode, TreeNode<Integer> firstTreeNode) {
		if (firstTreeNode == null && secondTreeNode == null){
			return true;
		}
		if (firstTreeNode == null || secondTreeNode ==null){
			return false;
		}
		if (firstTreeNode.value != secondTreeNode.value){
			return false;
		}
		return  matchTrees(secondTreeNode.left, firstTreeNode.left) &&  matchTrees(secondTreeNode.right,firstTreeNode.right);
	}
		
}
