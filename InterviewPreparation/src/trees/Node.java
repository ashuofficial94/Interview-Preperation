package trees;

import java.util.List;

public class Node {

	int value;
	List<Node> children;
	
	Node(int value) {
		this.value = value;
	}
	
	public void addChild(Node child) {
		children.add(child);
		return;
	}
	
}
