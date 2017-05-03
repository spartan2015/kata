package trees.algo.s2;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FindAllTreePathsThatAreAGivenSum {

	@Test
	public void test(){
		TreeNode<Integer> t1 = SortedArrayToBinaryTree
				.arrayToBinaryTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		
		findSum(t1, 25, new LinkedList<Integer>());
		
		findSum(t1, 7, new LinkedList<Integer>());
		
		findSum(t1, 3, new LinkedList<Integer>());
	}

	private void findSum(TreeNode<Integer> node, int i, LinkedList<Integer> prev) {
		if (node == null) return;
		prev.add(node.value);
		check((LinkedList)prev.clone(),i);
		findSum(node.left, i, ((LinkedList)prev.clone()));
		findSum(node.right, i, (LinkedList)prev.clone());
		
	}

	private void check(LinkedList<Integer> prev, int lookingFor) {
		while(!prev.isEmpty()){
			System.out.println("check" + prev + "==" + lookingFor);
			if (prev.stream().mapToInt(i->i).sum() == lookingFor){
				System.out.println("Yes");
			}
			prev.removeFirst();
		}
	}	
}
