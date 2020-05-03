package trees;

import java.util.List;

public class BTree {

	private BNode root;
	private List<BNode> nodes;
	
	BTree(BNode root) {
		this.root = root;
	}
	
	public BNode getRoot() {
		return root;
	}
	
	public boolean addNode(BNode node) {
		if(nodes.contains(node))
			return true;
		
		return nodes.add(node);
	}
	
	public BNode getNode(int val) {
		
		for(BNode node: nodes) {
			if(node.getValue() == val)
				return node;
		}
		
		return null;
	}
}
