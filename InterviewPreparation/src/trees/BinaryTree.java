package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	private BinaryNode root;
	private List<BinaryNode> nodes;
	
	BinaryTree(BinaryNode root) {
		this.root = root;
		nodes = new ArrayList<BinaryNode>();
		nodes.add(root);
	}
	
	public BinaryNode getRoot() {
		return root;
	}
	
	public boolean addNode(BinaryNode node) {
		if(nodes.contains(node))
			return true;
		
		return nodes.add(node);
	}
	
	public List<BinaryNode> getNodeList() {
		return nodes;
	}
	
	public BinaryNode getNode(BinaryNode target) {
		
		for(BinaryNode node: nodes) {
			if(node.getValue() == target.getValue())
				return node;
		}
		
		return null;
	}
}
