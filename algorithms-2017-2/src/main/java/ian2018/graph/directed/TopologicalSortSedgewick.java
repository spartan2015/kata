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

    public TopologicalSortSedgewick(Diagraph g) {
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

    Iterable pre(){
        return pre;
    }

    Iterable post(){
        return post;
    }

    Iterable reversePost(){
        return reversePost;
    }
}
