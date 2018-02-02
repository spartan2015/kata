package ian2018.graph.directed;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class TopologicalSortSedgewick {
    boolean[] marked;

    Queue<Integer> pre = new LinkedList<>();
    Queue<Integer> post=  new LinkedList<>();
    Stack<Integer> reversePost = new Stack();

    boolean hasCycle = false;

    public TopologicalSortSedgewick(Diagraph g) {
        if (new DirectedCycle(g).hasCycle){
            hasCycle = true;
            return;
        }
        marked  = new boolean[g.V()];

        for(int v = 0; v < g.V(); v++){
            if (!marked[v]) dfs(g,v);
        }
    }

    private void dfs(Diagraph g, int v){
        pre.add(v);

        marked[v]=true;
        for(int w : g.adj(v)){
            if (!marked[w]) dfs(g,w);
        }

        post.add(v);
        reversePost.push(v);
    }

    Iterable<Integer> pre(){
        return pre;
    }

    Iterable<Integer> post(){
        return post;
    }

    Iterable<Integer> reversePost(){
        return reversePost;
    }

    Iterable<Integer> topologicalSorted(){
        if (hasCycle){
            return null;
        }
        return reversePost;
    }
}
