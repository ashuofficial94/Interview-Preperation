package treesIP;

public class DividedHalf {
	
	//Check if removing an edge can divide the tree into two halves
	//For all edges

	private BinaryNode child;
	
	public boolean dividedHalf(BinaryTree tree) {
		
		countNodes(tree.getRoot(), tree.getNodeList().size());
		
		if(child != null) {
			BinaryNode parent = tree.getParent(child);
			System.out.print("Remove " + parent.getValue() + "->" + child.getValue());
			return true;
		}
		
		return false;
	}
	
	private int countNodes(BinaryNode node, int target) {
		
		if(node == null) return 0;
		
		int count = countNodes(node.getLeft(), target) + countNodes(node.getRight(), target) + 1;
		
		if(2 * count == target) child = node;
		
		return count;
	}
	
}
