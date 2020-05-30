package binarysearchtreeIP;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {

	public Tree balanceBST(Tree un_tree) {
		
		List<Node> nodes = new ArrayList<Node>();
		getNodes(nodes, un_tree.getRoot());
		
		for(Node node: nodes) {
			node.setLeft(null);
			node.setRight(null);
		}
		
		int mid = nodes.size()/2;
		Node root = nodes.get(mid);
		Tree bal_tree = new Tree(root);
		
//		addMids(nodes, 0, mid-1, bal_tree);
//		addMids(nodes, mid+1, nodes.size()-1, bal_tree);
		
		root.setLeft(constructBalancedBST(nodes, 0, mid-1));
		root.setRight(constructBalancedBST(nodes, mid+1, nodes.size()-1));
		
		return bal_tree;
	}
	
//	private void addMids(List<Node> nodes, int start, int end, Tree tree) {
//		
//		if(start <= end) {
//			int mid = (start+end)/2;
//			tree.addNode(nodes.get(mid));
//			addMids(nodes, start, mid-1, tree);
//			addMids(nodes, mid+1, end, tree);
//		}
//	}
	
	private Node constructBalancedBST(List<Node> nodes, int start, int end) {
		
		if(start <= end) {
			
			int mid = (start+end)/2;
			Node node = nodes.get(mid);
			node.setLeft(constructBalancedBST(nodes, start, mid-1));
			node.setRight(constructBalancedBST(nodes, mid+1, end));
			
			return node;
		}
		
		return null;
	}
	
	private void getNodes(List<Node> nodes, Node node) {
		
		if(node != null) {
			getNodes(nodes, node.getLeft());
			nodes.add(node);
			getNodes(nodes, node.getRight());
		}
	}
}
