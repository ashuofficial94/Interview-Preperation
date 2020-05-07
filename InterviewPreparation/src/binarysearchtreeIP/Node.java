package binarysearchtreeIP;

public class Node {

	private int value;
	private Node left;
	private Node right;
	
	Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node getRight() {
		return right;
	}
}
