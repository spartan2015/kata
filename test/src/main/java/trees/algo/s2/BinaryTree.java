package trees.algo.s2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.function.Consumer;

import org.junit.Test;

public class BinaryTree<E extends Comparable<E>> {

	TreeNode<E> root;
	
	public void add(E e){
		TreeNode<E> newNode = new TreeNode<>(e);
		if (root == null){
			root = newNode;
			return;
		}
		TreeNode<E> n = root;
		while(n!=null){
			if (less(e, n.value)){
				if (n.left == null){
					n.left = newNode;
					break;
				}
				n = n.left;
			}else{
				if (n.right == null){
					n.right = newNode;
					break;
				}else{
					n = n.right;
				}
			}
		}
	}

	private boolean less(E e, E value) {
		return e.compareTo(value) < 0;
	}
	
	public void inOrder(TreeNode<E> node, Consumer<E> assignment){
		if (node == null) return;
		inOrder(node.left,assignment);
		assignment.accept(node.value);
		inOrder(node.right,assignment);
	}
	
	public void preOrder(TreeNode<E> node, Consumer<E> consumer){
		if (node == null) return;
		consumer.accept(node.value);
		preOrder(node.left,consumer);
		preOrder(node.right,consumer);
	}
	
	public void postOrder(TreeNode<E> node, Consumer<E> assignment){
		if (node == null) return;
		postOrder(node.left,assignment);
		postOrder(node.right,assignment);
		assignment.accept(node.value);
	}
	
	@Test
	public void test(){
		BinaryTree<Integer> bst = new BinaryTree<>();
		bst.add(4);
		assertNotNull(bst.root);
		bst.add(2);
		bst.add(1);
		bst.add(0);
		bst.add(3);
		assertNotNull(bst.root.left);
		bst.add(6);
		assertNotNull(bst.root.right);
		bst.add(5);
		assertNotNull(bst.root.right.left);
		bst.add(7);
		assertNotNull(bst.root.right.right);
		assertEquals(Integer.valueOf(7),bst.root.right.right.value);
		
		StringBuilder sb = new StringBuilder();
		bst.inOrder(bst.root, value->{
			sb.append(value);
		});
		assertEquals("01234567",sb.toString());
		sb.delete(0, sb.length());
		
		bst.preOrder(bst.root, value->{
			sb.append(value);
		});
		assertEquals("42103657",sb.toString());
		sb.delete(0, sb.length());
		
		bst.postOrder(bst.root, value->{
			sb.append(value);
		});
		assertEquals("01325764",sb.toString());
	}
}
