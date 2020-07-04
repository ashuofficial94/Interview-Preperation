package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Reverse the nodes at alternate levels in complete binarytree

public class ReverseAlternate {
	
	//RBR Solution
	private void reverseAlternateRec(BinaryNode node1, BinaryNode node2, int level) {
		
		if(node1 == null || node2 == null) return;
		
		if(level % 2 == 1) swapNodes(node1, node2);
		
		reverseAlternateRec(node1.getLeft(), node2.getRight(), level+1);
		reverseAlternateRec(node1.getRight(), node2.getLeft(), level+1);
	}
	
	private void swapNodes(BinaryNode node1, BinaryNode node2) {
		
		int temp = node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(temp);
	}
	
	
	//My Solution
	public void reverseAlternate(BinaryTree tree) {

//		reverseAlternateRec(tree.getRoot().getLeft(), tree.getRoot().getRight(), 1);
	
		int level = 1;
		Map<Integer, List<BinaryNode>> levels = new HashMap<Integer, List<BinaryNode>>();
		levels.put(level, new ArrayList<BinaryNode>());
		levels.get(level).add(tree.getRoot());
		
		while(true) {
			
			levels.put(++level, new ArrayList<BinaryNode>());
				
			for(BinaryNode node : levels.get(level-1)) {

					if(node.getLeft() != null) levels.get(level).add(node.getLeft());
					if(node.getRight() != null) levels.get(level).add(node.getRight());
			}
			
			if(levels.get(level).size() == 0) {
				levels.remove(level);
				break;
			}
		}
		
		//Changing the values
		
		for(int index = 2; index < level; index += 2) {
			for(int i=0, j=levels.get(index).size()-1; i<j; i++, j--)
				swapNodes(levels.get(index).get(i), levels.get(index).get(j));
		}
		
		//OR
		
		//Dereferencing the Nodes
		
		/*
		for(int index = 2; index < level; index++) {
			
			List<BinaryNode> parents = levels.get(index-1);
			
			if(index % 2 == 0) {
				int child_index = levels.get(index).size()-1;
				List<BinaryNode> children = new ArrayList<BinaryNode>();
				
				for(BinaryNode parent : parents) {
					
					parent.setLeft(levels.get(index).get(child_index));
					children.add(levels.get(index).get(child_index));
					child_index--;
					
					parent.setRight(levels.get(index).get(child_index));
					children.add(levels.get(index).get(child_index));
					child_index--;
				}
				
				levels.replace(index, children);
			}
			
			else {
				int child_index = 0;
				
				for(BinaryNode parent : parents) {
					
					parent.setLeft(levels.get(index).get(child_index));
					child_index++;
					parent.setRight(levels.get(index).get(child_index));
					child_index++;
				}
			}
		}
		*/
		
	}
}
