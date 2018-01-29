package ian2018.graph.unidrected;


import java.util.LinkedList;

public class ConnectedComponents {

    boolean[] marked;
    int[] ids;
    int countComponents = 0;

    public ConnectedComponents(UnidirectedGraph g){
        ids = new int[g.V()];
        marked = new boolean[g.V()];

        for(int v = 0; v < g.V(); v++){
            if (!marked[v]) {
                countComponents++;
                LinkedList<Integer> q = new LinkedList();
                q.push(v);
                marked[v] = true;
                ids[v] = countComponents;

                while (!q.isEmpty()) {
                    int x = q.poll();
                    for (int w : g.adj(x)) {
                        if (!marked[w]) {
                            marked[w] = true;
                            ids[w] = countComponents;
                            q.push(w);
                        }
                    }
                }
            }
        }
    }

    public int count(){
        return countComponents;
    }

    public int id(int v){
        return ids[v];
    }

    public boolean connected(int v, int w){
        return ids[v]==ids[w];
    }
}
