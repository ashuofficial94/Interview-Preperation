package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> vertices;
	
	Graph() {
		vertices = new ArrayList<Node>();
	}
	
	public List<Node> getVertices() {
		return vertices;
	}
	
	public boolean addVertex(Node node) {
		return vertices.add(node);
	}
	
	public Node getNode(int val) {
		
		for(Node vertex: vertices)
			if(vertex.getValue() == val)
				return vertex;
		
		return null;
	}
}
