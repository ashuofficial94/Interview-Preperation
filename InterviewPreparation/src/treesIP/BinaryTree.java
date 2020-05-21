package treesIP;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	private BinaryNode root;
	
	public BinaryTree(BinaryNode root) {
		this.root = root;
	}
	
	public BinaryNode getRoot() {
		return root;
	}
	
	public List<BinaryNode> getNodeList() {
		
		List<BinaryNode> node_list = new ArrayList<BinaryNode>();
		addNodes(root, node_list);
		return node_list;
	}
	
	private void addNodes(BinaryNode node, List<BinaryNode> node_list) {
		if(node != null) {
			node_list.add(node);
			addNodes(node.getLeft(), node_list);
			addNodes(node.getRight(), node_list);
		}
	}
	
	public BinaryNode getParent(BinaryNode target) {
		
		target = getNode(target);
		if(target.equals(root) || target == null) return null;
		
		BinaryNode parent = findParent(target, root);
		
		return parent;
	}
	
	private BinaryNode findParent(BinaryNode target, BinaryNode parent) {
		
		if(parent == null) return null;
		
		if(parent.getLeft() != null) {
			
			if(parent.getLeft().equals(target)) return parent;
			BinaryNode left_parent = findParent(target, parent.getLeft());			
			if(left_parent != null) return left_parent;
		}
		
		if(parent.getRight() != null) {
			
			if(parent.getRight().equals(target)) return parent;
			BinaryNode right_parent = findParent(target, parent.getRight());
			if(right_parent != null) return right_parent;
		}
		
		return null;
	}
	
	
	public BinaryNode getNode(BinaryNode target) {

		BinaryNode node = findNode(root, target);
		return node;
	}
	
	private BinaryNode findNode(BinaryNode node, BinaryNode target) {
		
		if(node == null) return null;
		if(node.getValue() == target.getValue()) return node;
		if(findNode(node.getLeft(), target) != null) return findNode(node.getLeft(), target);
		if(findNode(node.getRight(), target) != null) return findNode(node.getRight(), target);
		
		return null;
	}
}
