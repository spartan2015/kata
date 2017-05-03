package trees.algo;

import java.util.concurrent.TimeUnit;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import trees.structures.TreeNode;

public class DrawTrees {
	private SpriteManager spriteManager;

	/**
	 * http://graphstream-project.org/doc/Tutorials/Getting-Started/
	 */
	public void draw(TreeNode node) {
		Graph graph = new MultiGraph("Google Technical Lead");
		spriteManager = new SpriteManager(graph);

		inOrderAddNodes(graph, node);
		inOrderAddEdges(graph, node);

		Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		HierarchicalLayout hl = new HierarchicalLayout();
		viewer.enableAutoLayout(hl);
		View view = viewer.addDefaultView(true);
		viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.EXIT);

		// graph.display();
		try {
			TimeUnit.SECONDS.sleep(300);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	private void inOrderAddEdges(Graph graph, TreeNode<?> node) {
		if (node == null)
			return;
		addEdge(graph, node, node.left);
		inOrderAddEdges(graph, node.left);
		addEdge(graph, node, node.right);
		inOrderAddEdges(graph, node.right);
	}

	private void addEdge(Graph graph, TreeNode<?> parent, TreeNode<?> child) {
		if (child == null)
			return;
		graph.addEdge(parent.value + "" + child.value, parent.value.toString(), child.value.toString());
	}

	private void inOrderAddNodes(Graph graph, TreeNode node) {
		if (node == null)
			return;
		inOrderAddNodes(graph, node.left);

		org.graphstream.graph.Node someNode = graph.addNode(node.value.toString());
		someNode.addAttribute("ui.label", node.value.toString());

		Sprite sprite = spriteManager.addSprite("sprite-" + node.value.toString());
		sprite.attachToNode(node.value.toString());

		inOrderAddNodes(graph, node.right);
	}
}
