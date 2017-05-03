package trees.algo.s2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LinkedListOfNodesAtEachDepth {

	@Test
	public void test() {
		TreeNode<Integer> root = SortedArrayToBinaryTree.arrayToBinaryTree(new Integer[] { 1, 2, 3, 4, 5 });

		Map<Integer, List<Integer>> map = new HashMap<>();
		eachLevel(root, map, 0);
		System.out.println(map);
	}

	private void eachLevel(TreeNode<Integer> node, Map<Integer, List<Integer>> map, int level) {
		if (node == null)
			return;
		if (map.get(level) == null) {
			map.put(level, new LinkedList<Integer>());
		}
		map.get(level).add(node.value);
		eachLevel(node.left, map, level + 1);
		eachLevel(node.right, map, level + 1);
	}

}
