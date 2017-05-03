package trees.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import trees.structures.TreeNode;

public class FromBinarySearchTreeToLinkedListsLevels {

	@Test
	public void test() {

		TreeNode<Integer> root = new MinHeightTreeFromSortedArray()
				.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 9, null);

		List[] lists = new List[(IsTreeBalanced.maxDepth(root))];
		IntStream.range(0, lists.length).forEach(i->{
			lists[i] = new LinkedList();
		});
		
		depthAddTraverse(root, lists, 0);
		
		IntStream.range(0, lists.length).forEach(i->{
			System.out.println(i + ": " + lists[i]);
		});
		new DrawTrees().draw(root);
	}

	private void depthAddTraverse(TreeNode<Integer> node, List[] lists, int i) {
		 if (node == null) return;
		 lists[i].add(node);
		 depthAddTraverse(node.left, lists, i+1);
		 depthAddTraverse(node.right, lists, i+1);
	}
}
