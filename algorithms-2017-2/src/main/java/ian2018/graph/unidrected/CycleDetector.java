package ian2018.graph.unidrected;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created on 1/26/2018.
 */
public class CycleDetector {

    boolean[] marked;
    int[] markedFrom;
    boolean hasCycle;


    public CycleDetector(UnidirectedGraph g) {
        marked = new boolean[g.V()];

        //detectCycle(g);

        sedgewick(g);
    }

    private void sedgewick(UnidirectedGraph g){
        for(int v = 0 ; v < g.V(); v++) {
            if (!marked[v]) {
                LinkedList<int[]> q = new LinkedList();
                q.push(new int[]{v,v});
                marked[v] = true;
                while (!q.isEmpty()) {
                    int[] x = q.poll();
                    for (int w : g.adj(x[0])) {
                        if (!marked[w]) {
                            marked[w] = true;
                            q.push(new int[]{w,x[0]});
                        }else{
                            if (w != x[1]){
                                hasCycle= true;
                            }
                        }
                    }
                }
            }
        }
    }

    private void detectCycle(UnidirectedGraph g) {
        markedFrom = new int[g.V()];
        Arrays.setAll(markedFrom, i->-1);

        for(int v = 0 ; v < g.V(); v++) {
            if (!marked[v]) {
                LinkedList<int[]> q = new LinkedList();
                q.push(new int[]{0,0});
                marked[v] = true;
                markedFrom[v]=v;
                while (!q.isEmpty()) {
                    int[] x = q.poll();
                    for (int w : g.adj(x[0])) {
                        if (w == x[1]) continue;
                        if (!marked[w]) {
                            markedFrom[w] = x[0];
                            marked[w] = true;
                            q.push(new int[]{w,x[0]});
                        } else {
                            if (markedFrom[w] != x[0] ) {
                                hasCycle = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }
}
