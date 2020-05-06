package treesIP;

import java.util.ArrayList;
import java.util.List;

public class ConstructPreIn {

	private List<Integer> preorder;
	private List<Integer> inorder;
	private BinaryTree tree;
	
	ConstructPreIn(List<Integer> preorder, List<Integer> inorder) {
		this.preorder = preorder;
		this.inorder = inorder;
	}
	
	public BinaryTree constructPreIn() {
		
		BinaryNode root = new BinaryNode(preorder.get(0));
		tree = new BinaryTree(root);
		
		constructPreInRec(preorder, inorder, tree.getRoot());
		
		return tree;
	}
	
	private void constructPreInRec(List<Integer> pre_temp, List<Integer> in_temp, BinaryNode node) {
		
		if(pre_temp.size() == 0)
			return;
		
		tree.addNode(node);
		int index = in_temp.indexOf(node.getValue());
		
		List<Integer> in_left = in_temp.subList(0, index);
		List<Integer> in_right = in_temp.subList(index+1, in_temp.size());
		
		List<Integer> pre_left = new ArrayList<Integer>();
		List<Integer> pre_right = new ArrayList<Integer>();
		
		for(int pre_val : pre_temp) {
			
			if(in_left.contains(pre_val)) 
				pre_left.add(pre_val);
				
			else if(in_right.contains(pre_val))
				pre_right.add(pre_val);
		}
		
		if(pre_left.size() > 0) {
			
			BinaryNode left = new BinaryNode(pre_left.get(0));
			node.setLeft(left);
			constructPreInRec(pre_left, in_left, left);
		}
		
		if(pre_right.size() > 0) {
			
			BinaryNode right = new BinaryNode(pre_right.get(0));
			node.setRight(right);
			constructPreInRec(pre_right, in_right, right);
		}
		
		return;
	}
}
