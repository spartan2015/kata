package ian2008.hash.graph.unidrected;


public class ConnectedComponents {

    int[] ids;
    int countComponents = 0;
    public ConnectedComponents(UnidirectedGraph g){
        ids = new int[g.V()];
        int ccId = 1;

        for(int v = 0; v < g.V(); v++){
            if (ids[v]==0) {
                countComponents++;

                PathFind pathFind = new PathFind(g, v);
                for (int x = 0; x < g.V(); x++) {
                    if (pathFind.hasPathTo(x)) {
                        ids[x] = ccId;
                    }
                }

                ccId++;
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
