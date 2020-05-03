package trees;

public class BinaryNode {
	private int value;
	private BinaryNode left;
	private BinaryNode right;

	BinaryNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	public int getValue() {
		return value;
	}

	public boolean setLeft(int l_val) {
		left = new BinaryNode(l_val);
		return true;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public boolean setRight(int r_val) {
		right = new BinaryNode(r_val);
		return true;
	}

	public BinaryNode getRight() {
		return right;
	}
}
