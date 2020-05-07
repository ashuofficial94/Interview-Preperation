package binarysearchtreeIP;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private Node root;
	private List<Node> list;
	
	Tree(Node root) {
		this.root = root;
		list = new ArrayList<Node>();
		list.add(root);
	}
	
	public List<Node> getNodes() {
		return list;
	}
	
	public boolean addNode(Node node) {
		
		Node current = root;	
		while(true) {
			
			if(node.getValue() < current.getValue()) {
				
				if(current.getLeft() == null) {
					current.setLeft(node);
					list.add(node);
					return true;
				}
				
				current = current.getLeft();
			}
			
			else if(node.getValue() > current.getValue()) {
				
				if(current.getRight() == null) {
					current.setRight(node);
					list.add(node);
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
