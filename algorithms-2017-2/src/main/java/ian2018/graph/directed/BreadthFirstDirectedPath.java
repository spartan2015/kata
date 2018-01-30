package ian2018.graph.directed;


import java.util.LinkedList;

public class BreadthFirstDirectedPath {

    int s;
    boolean[] marked;
    int[] source;

    public BreadthFirstDirectedPath(Diagraph g, int source) {
        marked = new boolean[g.V()];
        this.source = new int[g.V()];
        this.s = source;

        breathFirstSearch(g, source);
    }

    public BreadthFirstDirectedPath(Diagraph g, int... sources) {
        marked = new boolean[g.V()];
        source = new int[g.V()];
        for (int s : sources) {
            breathFirstSearch(g, s);
        }
    }

    private void breathFirstSearch(Diagraph g, int s) {
        if (marked[s]) return;
        LinkedList<Integer> q = new LinkedList();
        q.add(s);  // BFS - same as DFS but using a FIFO
        while (!q.isEmpty()) {
            int v = q.pop();
            marked[v] = true;
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    source[w] = v;
                    q.add(w); // BFS - same as DFS but using a FIFO
                }
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public Iterable<Integer> shortestPathTo(int w) {
        LinkedList<Integer> path = new LinkedList();
        for (int x = w; x != s; x = source[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
