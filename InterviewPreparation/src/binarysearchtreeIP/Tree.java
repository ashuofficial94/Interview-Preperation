package binarysearchtreeIP;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private Node root;
	
	Tree(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public List<Node> getNodes() {
		
		List<Node> nodes = new ArrayList<Node>();
		List<Node> queue = new ArrayList<Node>();

		queue.add(root);
		
		while(queue.size() > 0) {
			
			nodes.add(queue.get(0));
			Node left_node = queue.get(0).getLeft();
			Node right_node = queue.get(0).getRight();
			
			if(left_node != null && !nodes.contains(left_node))
				queue.add(left_node);
			
			if(right_node != null && !nodes.contains(right_node))
				queue.add(right_node);
			
			queue.remove(0);
		}
		
		return nodes;
	}
	
	public boolean addNode(Node node) {
		
		Node current = root;	
		while(true) {
			
			if(node.getValue() < current.getValue()) {
				
				if(current.getLeft() == null) {
					current.setLeft(node);
					return true;
				}
				current = current.getLeft();
			}
			
			else if(node.getValue() > current.getValue()) {
				
				if(current.getRight() == null) {
					current.setRight(node);
					return true;
				}
				current = current.getRight();
			}
			
			else 
				return false;
		}
	}
	
	public Node getNode(int target) {
		
		Node current = root;	
		while(current != null) {

			if(target < current.getValue())
				current = current.getLeft();
			
			else if(target > current.getValue())
				current = current.getRight();
			
			else 
				return current;
		}
		
		return null;
	}
}
