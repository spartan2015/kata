package algo2.graphs.directed;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.Viewer.CloseFramePolicy;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

public class DirectedGraph {
	private List<Integer>[] edgeTo;
	private int noOfVertices;
	private int noOfEdges;

	public DirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		edgeTo = new LinkedList[noOfVertices];
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public int getNoOfEdges() {
		return noOfEdges;
	}

	public void clearEdge(int v) {
		edgeTo[v] = new LinkedList<>();
	}
	
	public void addEdge(int v, int w) {
		if (edgeTo[v] == null) {
			edgeTo[v] = new LinkedList<>();
		}
		edgeTo[v].add(w);
		noOfEdges++;
	}

	public Iterable<Integer> adjacent(int v) {
		return edgeTo[v] != null ? edgeTo[v] : new LinkedList();
	}

	/**
	 * http://graphstream-project.org/doc/Tutorials/Getting-Started/
	 */
	public void draw() {
		Graph graph = new SingleGraph("Graph 1");
		IntStream.range(0, getNoOfVertices()).forEach(v -> {
			graph.addNode(v + "");
		});
		IntStream.range(0, getNoOfVertices()).forEach(v -> {
			for (int w : adjacent(v)) {
				graph.addEdge(v + "" + w, v + "", w + "");
			}
		});
		Viewer viewer = graph.display();

		View view = viewer.addDefaultView(true);
		viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.EXIT);
		ViewerPipe fromViewer = viewer.newViewerPipe();
		fromViewer.addViewerListener(new ViewerListener() {
			@Override
			public void viewClosed(String viewName) {
			}

			@Override
			public void buttonPushed(String id) {
			}

			@Override
			public void buttonReleased(String id) {
			}
		});
		fromViewer.addSink(graph);

		try {
			TimeUnit.SECONDS.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public DirectedGraph reverse() {
		DirectedGraph directedGraph = new DirectedGraph(noOfVertices);
		for (int v = 0; v < noOfVertices; v++) {
			for (int w : adjacent(v)) {
				directedGraph.addEdge(w, v);
			}
		}
		return directedGraph;
	}

	public String toString() {
		return "";
	}
}
