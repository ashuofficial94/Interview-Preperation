package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoundaryTraversal {
	
	private Map<Integer, List<BinaryNode>> levels = new HashMap<Integer, List<BinaryNode>>();
	private int height;
	
	private void setLevels(BinaryTree tree) {

		int level = 1;
		levels.put(level, new ArrayList<BinaryNode>());
		levels.get(level).add(tree.getRoot());
		
		while(true) {

			levels.put(++level, new ArrayList<BinaryNode>());
			
			for(BinaryNode node : levels.get(level-1)) {
				
				BinaryNode l_node = node.getLeft();
				BinaryNode r_node = node.getRight();
				
				if(l_node != null) levels.get(level).add(l_node);
				if(r_node != null) levels.get(level).add(r_node);
				
			}
			
			if(levels.get(level).size() == 0) {
				levels.remove(level);
				height = level - 1;
				break;
			}
		}
		
	}
	
	private void leftBoundary(BinaryNode node, List<BinaryNode> left) {
		
		if(node != null) {
			if(node.getLeft() != null) {
				
				left.add(node);
				leftBoundary(node.getLeft(), left);
			}
			
			else if(node.getRight() != null) {
				
				left.add(node);
				leftBoundary(node.getRight(), left);
			}
		}
	}
	
	private void rightBoundary(BinaryNode node, List<BinaryNode> right) {
		
		if(node != null) {
			
			if(node.getRight() != null) {
				
				rightBoundary(node.getRight(), right);
				right.add(node);
			}
			
			else if(node.getLeft() != null) {
				
				rightBoundary(node.getLeft(), right);
				right.add(node);
			}
		}
	}
	
	private List<BinaryNode> leftView() {
		
		List<BinaryNode> left_view = new ArrayList<BinaryNode>();
		
		for(int level : levels.keySet()) {
			left_view.add(levels.get(level).get(0));
		}
		
		return left_view;
	}
	
	public void inorderLeaves(BinaryNode node, List<BinaryNode> leaves) {
		
		if(node != null) {
			
			inorderLeaves(node.getLeft(), leaves);
			if(node.isLeaf()) leaves.add(node);
			inorderLeaves(node.getRight(), leaves);
		}
	}
	
	private List<BinaryNode> rightView() {
		
		List<BinaryNode> right_view = new ArrayList<BinaryNode>();
		
		for(int i=height; i>0; i--) {
			BinaryNode node = levels.get(i).get(levels.get(i).size() - 1);
			right_view.add(node);
		}
		
		return right_view;
	}
	
	public List<BinaryNode> boundaryTraversal(BinaryTree tree) {
		
		setLevels(tree); 

		List<BinaryNode> left = new ArrayList<BinaryNode>();
		List<BinaryNode> right = new ArrayList<BinaryNode>();
		List<BinaryNode> bottom = new ArrayList<BinaryNode>();
		List<BinaryNode> boundary = new ArrayList<BinaryNode>();
		
//		left = leftView();
//		right = rightView();
		
		leftBoundary(tree.getRoot(), left);
		rightBoundary(tree.getRoot(), right);
		
		List<BinaryNode> leaves = new ArrayList<BinaryNode>();
		inorderLeaves(tree.getRoot(), leaves);

		for(BinaryNode leaf : leaves) {
			if(!left.contains(leaf) && !right.contains(leaf)) bottom.add(leaf);
		}
		
		boundary.addAll(left);
		boundary.addAll(leaves);
		boundary.addAll(right);
		
		return boundary;
	}
	
}
