package treesIP;

public class CountNodes {

	public int countNodes(BinaryNode curr) {
		
		if(curr == null)
			return 0;
		
		return 1 + countNodes(curr.getLeft()) + countNodes(curr.getRight());
	}
	
	public int countLeaves(BinaryNode curr) {
		
		if(curr == null)
			return 0;
		
		if(curr.getLeft() == null && curr.getRight() == null)
			return 1;
		
		return countLeaves(curr.getLeft()) + countLeaves(curr.getRight());
	}
}
