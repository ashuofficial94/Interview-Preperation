package treesIP;

public class SumTree {

	private boolean sum = true;
	
	public boolean sumTree(BinaryTree tree) {

		checkSum(tree.getRoot());
		return sum;
	}
	
	private void checkSum(BinaryNode node) {
		
		boolean leaf = node.getLeft() == null && node.getRight() == null;
		if(node != null && !leaf) {
			
			if(node.getValue() != getValue(node.getLeft()) + getValue(node.getRight())) {
				sum = false;
				return;
			}
			checkSum(node.getLeft());
			checkSum(node.getRight());
		}
		
	}
	private int getValue(BinaryNode node) {
		
		if(node == null)
			return 0;
		
		if(node.getLeft() == null && node.getRight() == null)
			return node.getValue();
		
		else
			return 2*node.getValue();
		
	}
}
