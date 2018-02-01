package ian2018.graph.directed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class TopologicalSort {
    private boolean isDag;
    private boolean[] marked;

    private LinkedList<LinkedList>[] preOrder;
    private LinkedList<LinkedList>[] postOrder;
    public TopologicalSort(Diagraph g) {
        preOrder = new LinkedList[g.V()];
        Arrays.setAll(preOrder, i->new LinkedList());
        postOrder = new LinkedList[g.V()];
        Arrays.setAll(postOrder, i->new LinkedList());

        for(int s = 0; s < g.V(); s++) {
            marked = new boolean[g.V()];
            if (marked[s]) continue;
            LinkedList<int[]> q = new LinkedList<int[]>();
            q.push(new int[]{s,s,s});
            while (!q.isEmpty()) {
                int[] vArray = q.pop();
                int v = vArray[0];
                int source = vArray[1];
                int previous = vArray[2];
                marked[v] = true;
                if (previous == s){ // this condition is wrong
                    preOrder[s].add(new LinkedList());
                    postOrder[s].add(new LinkedList());
                    preOrder[source].get(preOrder[source].size()-1).add(s);
                    postOrder[source].get(postOrder[source].size()-1).addFirst(s);
                }
                preOrder[source].get(preOrder[source].size()-1).add(v);
                postOrder[source].get(postOrder[source].size()-1).addFirst(v);
                for (int w : g.adj(v)) {
                    if (!marked[w]) {
                        q.push(new int[]{w, source, v});
                    }
                    else{
                        isDag = false;
                        q.push(new int[]{w, source, v});
                        break;
                    }
                }
            }
        }
    }

    public boolean isDAG(){ // otherwise toplogical sort is not possible due to cycles
        return isDag;
    }

    Iterable<Integer> inOrder(int s){
        return preOrder[s].get(1);
    }

    Iterable possiblePaths(int s){
        return preOrder[s];
    }
}
