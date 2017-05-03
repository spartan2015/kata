package regexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import algo2.graphs.directed.DirectedDFS;
import algo2.graphs.directed.DirectedGraph;

public class NFA {
	private char[] re;
	private DirectedGraph G;
	private int M;
	
	public NFA(String regexp) {
		Stack<Integer> ops = new Stack<>();
		re = regexp.toCharArray();
		M = re.length;
		G = new DirectedGraph(M+1);
		for(int i = 0; i < M; i++){
			int lp = i;
			if (re[i]=='(' || re[i] == '|'){
				ops.push(i);
			}else if(re[i]==')'){
				int or = ops.pop();
				if (re[or] == '|'){
					lp = ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or+1, lp);
				}else{
					lp = or;
				}
			}
			
			if (i < M-1 && re[i+1] =='*'){
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}
			
			if (Arrays.asList('(',')','*').contains(re[i])){
				G.addEdge(i, i+1);
			}
		}
	}

	public boolean match(String line) {
		ArrayList<Integer> pc = new ArrayList<>();
		DirectedDFS dfs = new DirectedDFS(G,0);
		for(int v = 0; v < G.getNoOfVertices(); v++){
			if (dfs.isMarked(v)){
				pc.add(v);
			}
		}
		
		for(int i = 0; i < line.length(); i++){
			ArrayList<Integer> match = new ArrayList<>();
			for(int v : pc){
				if (v < M){
					if (Arrays.asList(line.charAt(i),'.').contains(re[v])){
						match.add(v+1);
					}
				}
			}
			
			pc = new ArrayList<>();
			dfs = new DirectedDFS(G, match);
			for(int v = 0; v < G.getNoOfVertices(); v++){
				if (dfs.isMarked(v)){
					pc.add(v);
				}
			}
		}

		for(int v : pc){
			if (v==M){
				return true;
			}
		}
		
		return false;
	}

}
