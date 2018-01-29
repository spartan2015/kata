package ian2018.graph.unidrected;

/**
 *
 */
public class DegreesOfSeparation /*or connection*/{

    ShortestPath sp;
    SymbolGraph sg;
    public DegreesOfSeparation(SymbolGraph sg) {
        this.sg = sg;
        sp = new ShortestPath(sg.G(), 0);
    }

    public String pathTo(String key){
        Integer v = sg.index(key);
        if (v == null){
            return "not in database";
        }
        if (sp.hasPathTo(v)){
            StringBuilder sb = new StringBuilder();
            for(int w : sp.shortedPathTo(v)){
                sb.append(sg.name(w)).append("-");
            }
            sb.delete(sb.length()-1, sb.length());
            return sb.toString();
        }else{
            return "not connected";
        }
    }
}
