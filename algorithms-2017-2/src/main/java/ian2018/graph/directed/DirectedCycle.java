package ian2018.graph.directed;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class DirectedCycle {
    boolean[] marked;
    boolean hasCycle = false;
    Iterable<Integer> cycle;

    public DirectedCycle(Diagraph g) {
        marked = new boolean[g.V()];

        class Line{
            int v;
            LinkedList<Integer> line = new LinkedList();

            public Line(int v, List<Integer> prev) {
                this.v = v;
                line.addAll(prev);
                line.add(v);
            }
        }

        cycleLabel:
        for (int s = 0; s < g.V(); s++) {
            if (marked[s]) continue;
            LinkedList<Line> q = new LinkedList<>();
            q.push(new Line(0, Collections.EMPTY_LIST));
            while (!q.isEmpty()) {
                Line current = q.pop();
                marked[current.v] = true;
                for (int w : g.adj(current.v)) {
                    if (!marked[w]) {
                        q.push(new Line(w, current.line));
                    } else if (current.line.contains(w)) {
                        hasCycle = true;
                        cycle = current.line;
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
