package ian2008.hash.graph.unidrected;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UnidirectedGraph {
    int[] v;
    List<Integer>[] e;
    int E;

    public UnidirectedGraph(int V){
        init(V);
    }

    private void init(int V) {
        v = new int[V];
        e = new List[V];
        for(int i = 0; i < V; i++){
            e[i] = new LinkedList();
        }
    }

    public UnidirectedGraph(String s){
        Scanner sc = new Scanner(s);
        int V = sc.nextInt();
        init(V);
        int E = sc.nextInt();
        for(int i = 0; i < E; i++){
            int v= sc.nextInt();
            int w = sc.nextInt();
            addEdge(v,w);
        }
    }

    public int V(){
        return v.length;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        e[v].add(w);
        e[w].add(v);
        E+=2;
    }

    Iterable<Integer> adj(int v){
        return e[v];
    }

    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i = 0; i < v.length; i++) {
            sb.append(i + " : " + adj(i));
        }
        return sb.toString();
    }
}
