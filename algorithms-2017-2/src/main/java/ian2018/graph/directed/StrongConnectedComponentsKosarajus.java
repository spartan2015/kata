package ian2018.graph.directed;

/**
 *
 */
public class StrongConnectedComponentsKosarajus {
    Diagraph g;
    boolean[] marked;
    int[] id;
    private int count;

    public StrongConnectedComponentsKosarajus(Diagraph g) {
        marked = new boolean[g.V()];
        this.g = g;
        //1.compute topological order of graph reverse
        TopologicalSortSedgewick ts = new TopologicalSortSedgewick(g.reverse());
        //run DepthFirstSearch - but consider the unmarked vertices in the order just computed
        for(int s : ts.topologicalSorted()){
            if (!marked[s]){
                dfs(s);
                count++;
            }
        }
        // all vertices reached on a call to recursive DFS are in a strong component
    }

    private void dfs(int v){
        marked[v]=true;
        id[v]=count;
        for(int w : g.adj(v)){
            if (!marked[w]){
                dfs(w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w){
        return id[v]== id[w];
    }
}
