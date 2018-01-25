package ian2008.hash.graph.unidrected;


import java.util.LinkedList;
import java.util.Stack;

public class ShortestPath {

    int s;
    boolean[] marked;
    int[] source;

    public ShortestPath(UnidirectedGraph g, int s){
        marked = new boolean[g.V()];
        source= new int[g.V()];
        this.s = s;

        LinkedList<Integer> q = new LinkedList();
        q.add(s);  // BFS - same as DFS but using a FIFO
        while(!q.isEmpty()){
            int v= q.pop();
            marked[v]=true;
            for(int w : g.adj(v)){
                if (!marked[w]){
                    source[w]=v;
                    q.add(w); // BFS - same as DFS but using a FIFO
                }
            }
        }
    }

    public boolean hasPathTo(int w){
        return marked[w];
    }

    public Iterable<Integer> shortedPathTo(int w){
        LinkedList<Integer> path = new LinkedList();
        for(int x  = w; x!=s; x = source[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
