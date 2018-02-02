package ian2018.graph.directed;

/**
 *
 */
public class StrongConnectedComponents {

    DepthFirstDirectedPath[] paths;
    Diagraph g;

    public StrongConnectedComponents(Diagraph g) {
        this.g = g;
        paths = new DepthFirstDirectedPath[g.V()];
        for(int s =0; s < g.V(); s++){
            paths[s] = new DepthFirstDirectedPath(g,s);
        }
    }

    public boolean stronglyConnected(int v, int w){
        return paths[v].hasPathTo(w) && paths[w].hasPathTo(v);
    }
}
