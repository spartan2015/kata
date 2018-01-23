package ian2008.hash.graph.unidrected;


public class CommonUnigraphAlgos {

    public static int degree(UnidirectedGraph g, int v){
        int degree = 0;
        for(int w : g.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(UnidirectedGraph g){
        int max = 0;
        for(int v = 0 ; v < g.V(); v++){
            max = Math.max(max, degree(g,v));
        }
        return max;
    }

    public static int avgDegree(UnidirectedGraph g){
        return 2 * g.E() / g.V();
    }

    public static int selfLoops(UnidirectedGraph g){
        int count = 0;
        for(int v = 0; v < g.V(); v++){
            for(int w : g.adj(v)){
                if (w == v){
                    count++;
                }
            }
        }
        return count / 2;
    }
}
