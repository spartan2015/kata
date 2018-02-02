package ian2018.graph.directed;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class DirectedCycleRecursive {
    boolean[] marked;
    boolean hasCycle = false;
    boolean[] onStack;
    int[] path;
    LinkedList<Integer> cycle;
    Diagraph g;

    public DirectedCycleRecursive(Diagraph g) {
        this.g=g;
        marked = new boolean[g.V()];
        onStack =  new boolean[g.V()];
        path = new int[g.V()];

        for(int s = 0; s < g.V(); s++){
            if (!marked[s]) dfs(s);
        }
    }

    private void dfs(int v){
        onStack[v]=true;
        marked[v]=true;
        for(int w : g.adj(v)){
            if (!marked[w]){
                path[w]=v;
                dfs(w);
            }else if (onStack[w]){
                hasCycle=true;

                cycle = new LinkedList();
                for(int x = v; x!=w; x = path[x]){
                    cycle.push(x);
                }
                cycle.push(v);
                cycle.push(w);
            }
        }
        onStack[v]=false;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public Iterable<Integer> cycle() {
        return cycle();
    }
}
