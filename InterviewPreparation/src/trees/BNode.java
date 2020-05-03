package trees;

public class BNode {
	private int value;
	private BNode left;
	private BNode right;

	BNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	public int getValue() {
		return value;
	}

	public boolean setLeft(int l_val) {
		left = new BNode(l_val);
		return true;
	}

	public BNode getLeft() {
		return left;
	}

	public boolean setRight(int r_val) {
		right = new BNode(r_val);
		return true;
	}

	public BNode getRight() {
		return right;
	}
}
