package ian2018.graph.unidrected;

import java.util.LinkedList;

public class DetectBipartiteGraph {

    UnidirectedGraph g;
    boolean[] marked;
    boolean[] colors;
    boolean isBipartite = true;
    public DetectBipartiteGraph(UnidirectedGraph g) {
        if (g.V()<=1) {
            isBipartite = false;
            return;
        }
        marked = new boolean[g.V()];
        colors = new boolean[g.V()];
        this.g = g;

        for(int v = 0; v < g.V(); v++){
            startFrom(v);
        }
    }

    private void startFrom(int start) {
        if (marked[start]) return;
        LinkedList<Integer> q = new LinkedList();
        q.push(start);
        while(!q.isEmpty()){
            int v = q.pop();
            marked[v]=true;
            for(int w : g.adj(v)){
                if (!marked[w]){
                    q.push(w);
                    colors[w]=!colors[v];
                }else{
                    if (colors[w] != !colors[v]){
                        isBipartite = false;
                    }
                }
            }
        }
    }
}