package treesIP;

import java.util.ArrayList;
import java.util.List;

public class ConstructPostIn {

	private List<Integer> postorder;
	private List<Integer> inorder;
	
	ConstructPostIn(List<Integer> postorder, List<Integer> inorder) {
		this.postorder = postorder;
		this.inorder = inorder;
	}
	
	//My Solution
	
	public BinaryTree constructPostIn() {
		
		BinaryNode root = new BinaryNode(postorder.get(postorder.size()-1));
		BinaryTree tree = new BinaryTree(root);
		
		constructPostInRec(postorder, inorder, tree, tree.getRoot());
		
		return tree;
		
	}
	
	private void constructPostInRec(List<Integer> post_temp, List<Integer> in_temp, BinaryTree tree, BinaryNode node) {
		
		if(post_temp.size() == 0)
			return;

		tree.addNode(node);	
		int index = in_temp.indexOf(node.getValue());
		
		List<Integer> in_left = in_temp.subList(0, index);
		List<Integer> in_right = in_temp.subList(index + 1, in_temp.size());
		
		List<Integer> post_left = new ArrayList<Integer>();
		List<Integer> post_right = new ArrayList<Integer>();
		
		for(int in_elem: post_temp) {
			
			if(in_left.contains(in_elem))
				post_left.add(in_elem);
			
			else if(in_right.contains(in_elem))
				post_right.add(in_elem);
		}

		BinaryNode left_node = null, right_node = null;
		
		if(post_left.size() > 0) {
			
			left_node = new BinaryNode(post_left.get(post_left.size() - 1));
			node.setLeft(left_node);
			constructPostInRec(post_left, in_left, tree, left_node);
		}
		
		if(post_right.size() > 0) {

			right_node = new BinaryNode(post_right.get(post_right.size() - 1));	
			node.setRight(right_node);
			constructPostInRec(post_right, in_right, tree, right_node);
		}
		
		return;
	}
}
