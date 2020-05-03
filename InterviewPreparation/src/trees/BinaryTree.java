package trees;

import java.util.List;

public class BinaryTree {

	private BinaryNode root;
	private List<BinaryNode> nodes;
	
	BinaryTree(BinaryNode root) {
		this.root = root;
	}
	
	public BinaryNode getRoot() {
		return root;
	}
	
	public boolean addNode(BinaryNode node) {
		if(nodes.contains(node))
			return true;
		
		return nodes.add(node);
	}
	
	public BinaryNode getNode(int val) {
		
		for(BinaryNode node: nodes) {
			if(node.getValue() == val)
				return node;
		}
		
		return null;
	}
}
