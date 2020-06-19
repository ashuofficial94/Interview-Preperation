package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Find the next right node of a given key in the same level

public class NextRight {
	
	public BinaryNode nextRight(BinaryTree tree, int target) {
		
		Map<Integer, List<BinaryNode>> levels = new HashMap<Integer, List<BinaryNode>>();
		levels.put(1, new ArrayList<BinaryNode>());
		levels.get(1).add(tree.getRoot());
		
		int level = 1;
		if(tree.getRoot().getValue() == target) return null;
		
		while(levels.get(level).size() > 0) {
			
			levels.put(++level, new ArrayList<BinaryNode>());
			boolean found = false;
			
			for(BinaryNode node : levels.get(level-1)) {
				
				if(node.getLeft() != null) {
					
					if(found) return node.getLeft();
					levels.get(level).add(node.getLeft());
					if(node.getLeft().getValue() == target) found = true;
				}
				
				if(node.getRight() != null) {
					
					if(found) return node.getRight();
					levels.get(level).add(node.getRight());
					if(node.getRight().getValue() == target) found = true;
				}
			}
		}
		
		return null;
	}

}
