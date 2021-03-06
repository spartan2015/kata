package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 */
public class Fb {
	/**
	void printTreeByLevel(Node root)

	class Node {
	  Node[] children;
	  int id;
	}

	This means we can arrange a tree into levels based on how many steps it takes to reach the root, for example:

	      N0                  <� Level 1
	     /    \
	   N1      N2                <� Level 2
	    |      |  \
	   N3     N4   N5            < �Level 3
	           |
	          N6                 < � Level 4

	The goal of this function is to traverse the tree and print the id value of each Node in order of which level the Node is on, with an extra newline indicating level breaks.

	Output:
	0
	1 2
	3 4 5
	6
	*/
	  
	class Node{
	  Node[] children;
	  int id;
	}

	public void printTreeByLevel(Node root){
	    List<List> collector = new ArrayList<>();
	    
	    collectInfo(root, 0, collector);
	    /*
	    for(int i = 0; i < list.size(); i++){
	      System.out.println(list.get(i));
	    }
	  */
	}

	public void collectInfo(Node node, int level, List<List> collector){
	  if (node == null) return;
	  
	  if (collector.get(level)==null){
	    collector.add(new ArrayList());
	  }
	  collector.get(level).add(node.id);
	  /*
	  for(int i =0; i< children.length; i++){
	    Node child = children[i];
		  collectInfo(child, level+1, collector);
	  }
	  */
	}


	public void printTreeByLevel2(Node root){
	  Queue<Node> q = new LinkedList();
	  q.offer(root);
	  while(!q.isEmpty()){
	    Node n = q.remove();
	    System.out.println(n.id);
	    for(Node child : n.children){
	      q.offer(child);
	    }
	  }
	}

}
