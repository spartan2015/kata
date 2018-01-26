package ian2018.unidrected;


import ian2018.unionfind.WeightedQuickUnionUnionFind;

import java.util.Stack;

public class SearchGraph {

    UnidirectedGraph graph;
    int s;
    boolean[] marked;
    int count = 0;

    public SearchGraph(UnidirectedGraph graph, int s) {
        this.graph = graph;
        this.s=s;
        marked = new boolean[graph.V()];

        //findAllConnectionsUnionFind(s)
        findAllConnectionsIterative(s);
        //findAllConnectionsRecursive(s)
    }

    private void findAllConnectionsUnionFind(int s) {
        WeightedQuickUnionUnionFind uf = new WeightedQuickUnionUnionFind(graph.V());
        for(int i = 0 ; i < graph.V(); i++){
            for(int w : graph.adj(i)){
                uf.connected(i, w);
            }
        }
        for(int i = 0 ; i < graph.V(); i++){
            marked[i]=uf.connected(s, i);
            if (marked[i]) count++;
        }
    }

    private void findAllConnectionsIterative(int s) {
        Stack<Integer> stack = new Stack();
        stack.push(s);
        while(!stack.isEmpty()){
            int v = stack.pop();
            if (marked[v]) continue;
            count++;
            marked[v]=true;
            for(int w : graph.adj(v)){
                stack.push(w);
            }
        }
    }

    public void findAllConnectionsRecursive(int v){
        if (marked[v]) return;
        count++;
        marked[v]=true;
        for(int w : graph.adj(v)){
            findAllConnectionsRecursive(w);
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
