package treesIP;

import java.util.ArrayList;
import java.util.List;

public class CousinNodes {
	
//	My solution
	public boolean cousinNode(BinaryTree tree, int val1, int val2) {
		
		BinaryNode node1 = tree.getNode(new BinaryNode(val1));
		BinaryNode node2 = tree.getNode(new BinaryNode(val2));
		
		BinaryNode parent1 = tree.getParent(node1);
		BinaryNode parent2 = tree.getParent(node2);
		
		BinaryNode grand1 = tree.getParent(parent1);
		BinaryNode grand2 = tree.getParent(parent2);
		
		return grand1.equals(grand2);
	}
	
	public boolean cousinNodes(BinaryTree tree, int val1, int val2) {
		
		int level1 = getLevel(tree.getRoot(), 1, val1);
		int level2 = getLevel(tree.getRoot(), 1, val2);

		if(level1 != level2 || level1 < 3)
			return false;
		
		List<BinaryNode> parent_nodes = new ArrayList<BinaryNode>();
		getParents(tree.getRoot(), level1-1, 1, parent_nodes);
		
		for(BinaryNode parent: parent_nodes) {
			
			boolean has_left = parent.getLeft() != null;
			boolean has_right = parent.getRight() != null;
			
			if(!has_left || !has_right)
				continue;
			
			boolean sibling = (parent.getLeft().getValue() == val1 && parent.getRight().getValue() == val2)
					|| (parent.getLeft().getValue() == val2 && parent.getRight().getValue() == val1);
			
			if(sibling)
				return false;
		}
		
		return true;
		
	}
	
	private void getParents(BinaryNode node, int t_level, int level, List<BinaryNode> parent_nodes) {
		
		if(node != null) {
		
			if(level == t_level) parent_nodes.add(node);
			getParents(node.getLeft(), t_level, level+1, parent_nodes);
			getParents(node.getRight(), t_level, level+1, parent_nodes);
		}
	}
	
	private int getLevel(BinaryNode node, int level, int val) {
		
		if(node != null) {
			
			if(node.getValue() == val)
				return level;

			int left_level = getLevel(node.getLeft(), level+1, val);
			if(left_level != -1)
				return left_level;
			
			int right_level = getLevel(node.getRight(), level+1, val);
			if(right_level != -1)
				return right_level;
		}
		
		return -1;
	}

}
