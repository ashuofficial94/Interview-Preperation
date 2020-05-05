package treesIP;

public class IdenticalTrees {

	public boolean identicalTrees(BinaryNode curr1, BinaryNode curr2) {
		
		if(curr1 == null && curr2 == null)
			return true;
		
		else if((curr1 != null && curr2 == null) || (curr1 == null && curr2 != null))
			return false;
		
		else {
			
			boolean val = (curr1.getValue() == curr2.getValue());
			boolean left = identicalTrees(curr1.getLeft(), curr2.getLeft());
			boolean right = identicalTrees(curr1.getRight(), curr2.getRight());
			
			return val && left && right;
		}
		
	}
}
