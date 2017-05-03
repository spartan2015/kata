package algo2.graphs.edgeweighted.directed.acyclic;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;

/**
 * longest duration when parallel execution is avilable (more than 1 edge going
 * out)
 * 
 * @author vasil
 *
 */
public class CriticalPath {

	static class Job {
		int duration;
		List<Integer> successors;

		Job(int duration, List<Integer> successors) {
			this.duration = duration;
			this.successors = successors;
		}
	}

	@Test
	public void test() {
		List<Job> jobs = Arrays.asList(new Job(41, Arrays.asList(1, 7, 9)), new Job(51, Arrays.asList(2)),
				new Job(50, Arrays.asList()), new Job(36, Arrays.asList()), new Job(38, Arrays.asList()),
				new Job(45, Arrays.asList()), new Job(21, Arrays.asList(3, 8)), new Job(32, Arrays.asList(3, 8)),
				new Job(32, Arrays.asList(2)), new Job(29, Arrays.asList(4, 6)));

		EdgeWeightedDiagraph edgeWeightedDiagraph = new EdgeWeightedDiagraph(2 * jobs.size() + 2);

		int N = jobs.size();
		int s = 2 * N;
		int t = 2 * N + 1;
		
		for(int i =0; i< N; i++){
			// a job between s -> job-> t
			edgeWeightedDiagraph.addEdge(i,i+N, jobs.get(i).duration);
			
			edgeWeightedDiagraph.addEdge(s,i, 0);
			edgeWeightedDiagraph.addEdge(i+N,t, 0);
			// job dependencies;
			for(int successor : jobs.get(i).successors){
				edgeWeightedDiagraph.addEdge(i+N, successor, 0);
			}
		}
		
		DagLongestPath dag = new DagLongestPath(edgeWeightedDiagraph, s);
		for(int i = 0; i < N; i++){
			System.out.println(String.format("%4d: %5.1f", i, dag.distTo(i)));
		}
		System.out.println(String.format("finish time: %5.1f", dag.distTo(t)));
		
	}

}
