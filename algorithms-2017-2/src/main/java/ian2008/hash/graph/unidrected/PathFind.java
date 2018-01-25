package ian2008.hash.graph.unidrected;


import java.util.LinkedList;
import java.util.Stack;

public class PathFind {

    boolean[] marked;
    int[] source;
    int s;

    public PathFind(UnidirectedGraph g, int s) {
        marked = new boolean[g.V()];
        source = new int[g.V()];
        this.s = s;

        Stack<Integer> q = new Stack();
        q.push(s);
        marked[s]=true;
        while (!q.isEmpty()) {
            int v = q.pop();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    source[w] = v;
                    q.push(w);
                }
            }
        }
    }

    boolean hasPathTo(int w) {
        return marked[w];
    }

    Iterable<Integer> pathTo(int w) {
        LinkedList<Integer> path = new LinkedList<>();
        path.push(w);
        int current = w;
        while ((current = source[current]) != s) {
            path.push(current);
        }
        path.push(s);
        return path;
    }
}
