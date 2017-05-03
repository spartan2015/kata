package trees.algo.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedArrayToBinaryTree {

	@Test
	public void test(){
		TreeNode<Integer> root = arrayToBinaryTree(new Integer[]{1,2,3,4,5});
		
		assertEquals(Integer.valueOf(3),root.value);
		
		assertEquals(Integer.valueOf(1),root.left.value);
		assertEquals(Integer.valueOf(2),root.left.right.value);
		
		assertEquals(Integer.valueOf(4),root.right.value);
		assertEquals(Integer.valueOf(5),root.right.right.value);
		
	}
	
	public static <T extends Comparable<T>> TreeNode<T> arrayToBinaryTree(T[] arr) {
		return assignMid(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<T>> TreeNode assignMid(T[] arr, int left, int right){
		if (right < left) return null;
		int mid = (left+right) / 2;
		TreeNode<T> newNode = new TreeNode<>(arr[mid]);
		newNode.left = assignMid(arr, left, mid-1);
		assignParent(newNode, newNode.left);
		newNode.right = assignMid(arr, mid+1, right);
		assignParent(newNode, newNode.right);
		return newNode;
	}

	private static void assignParent(TreeNode parent, TreeNode child) {
		if (child != null){
			child.parent = parent;
		}
	}

}
