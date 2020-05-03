package graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int value;
	private List<Node> adjacents;
	
	Node(int value) {
		this.value = value;
		adjacents = new ArrayList<Node>();
	}
	
	public int getValue() {
		return value;
	}
	
	public List<Node> getAdjacents() {
		return adjacents;
	}
	
	public boolean addAdjacent(Node node) {
		
		if(adjacents.contains(node)) {
			return true;
		}
		
		return adjacents.add(node);
	}
	
}
