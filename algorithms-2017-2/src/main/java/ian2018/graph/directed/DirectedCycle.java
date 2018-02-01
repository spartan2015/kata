package ian2018.graph.directed;

import java.util.LinkedList;

/**
 *
 */
public class DirectedCycle {
    boolean[] marked;
    boolean hasCycle = false;
    Iterable<Integer> cycle;

    public DirectedCycle(Diagraph g) {
        marked = new boolean[g.V()];

        cycleLabel:
        for (int s = 0; s < g.V(); s++) {
            LinkedList cycleList = new LinkedList();
            if (marked[s]) continue;
            LinkedList<Integer> q = new LinkedList<>();
            q.push(s);
            while (!q.isEmpty()) {
                int v = q.pop();
                cycleList.add(v);
                marked[v] = true;
                for (int w : g.adj(v)) {
                    if (!marked[w]) {
                        q.push(w);
                    } else {
                        hasCycle = true;
                        cycle = cycleList;
                        break cycleLabel;
                    }
                }
            }
        }
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public Iterable<Integer> cycle() {
        return cycle();
    }
}
