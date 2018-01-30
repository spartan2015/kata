package ian2018.graph.directed;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation examples:
 *
 * mark and sweep garbage collection
 */
public class DirectedDepthFirstSearch {
    boolean[] marked;
    public DirectedDepthFirstSearch(Diagraph g, int source) {
        marked = new boolean[g.V()];
        depthFirstSearch(g, source);
    }

    public DirectedDepthFirstSearch(Diagraph g, int... sources) {
        marked = new boolean[g.V()];
        for(int source : sources) {
            depthFirstSearch(g, source);
        }
    }

    private void depthFirstSearch(Diagraph g, int source) {
        if (marked[source]) return;
        LinkedList<Integer> q = new LinkedList();
        q.push(source);
        while(!q.isEmpty()){
            int v= q.pop();
            marked[v]=true;
            for(int w : g.adj(v)){
                if (!marked[w]){
                    q.push(w);
                }
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }
}
