package ian2018.graph.unidrected;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolGraph {

    UnidirectedGraph g;
    Map<String, Integer> nameToVerticeIndex;
    String[] vertexToName;
    public SymbolGraph(String delimitedPairs, String delim) {
        String[] lines = delimitedPairs.split("\\n");
        nameToVerticeIndex = new HashMap();
        int index = 0;
        List<int[]> edges = new ArrayList();
        for(String line : lines){
            String[] elements = line.split(delim);
            int[] pair = new int[2];
            if (null == nameToVerticeIndex.putIfAbsent(elements[0], index)){
                pair[0]=index;
                index++;
            }else{
                pair[0]=nameToVerticeIndex.get(elements[0]);
            }
            if (null == nameToVerticeIndex.putIfAbsent(elements[1], index)){
                pair[1]=index;
                index++;
            }else{
                pair[1]=nameToVerticeIndex.get(elements[1]);
            }
            edges.add(pair);
        }
        g = new UnidirectedGraph(nameToVerticeIndex.size());
        vertexToName = new String[nameToVerticeIndex.size()];
        for(String key : nameToVerticeIndex.keySet()){
            vertexToName[nameToVerticeIndex.get(key)] = key;
        }
        for(int[] pair : edges){
            g.addEdge(pair[0],pair[1]);
        }
    }

    boolean contains(String key){
        return nameToVerticeIndex.containsKey(key);
    }

    int index(String key){
        return nameToVerticeIndex.get(key);
    }

    String name(int v){
        return vertexToName[v];
    }

    public UnidirectedGraph G(){
        return g;
    }

    public String toString(){
        StringBuilder sb =new StringBuilder();
        for(int v= 0; v < g.V(); v++){
            sb.append(vertexToName[v]).append("\n");
            for(int w : g.adj(v)){
                sb.append("-" + vertexToName[w]).append("\n");
            }
        }
        return sb.toString();
    }
}
