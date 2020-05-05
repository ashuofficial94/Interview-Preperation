package treesIP;

import treesIP.BinaryNode;

public class BinaryNode {
	
	private int value;
	private BinaryNode left;
	private BinaryNode right;

	public BinaryNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	public int getValue() {
		return value;
	}

	public void setLeft(BinaryNode l_node) {
		left = l_node;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setRight(BinaryNode r_node) {
		right = r_node;
	}

	public BinaryNode getRight() {
		return right;
	}
}
