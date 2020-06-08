package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Find maximum difference between a node and it's ancestor in a binary tree

public class MaxAncestorDiff {

	//RBR Solution
	//Take the minimum of left subtree and right subtree 
	//Take the difference of node value and the minimum obtained
	//If greater than the result, change the result
	
	public int result;
	
	MaxAncestorDiff() {
		
	}
	
	MaxAncestorDiff(BinaryTree tree) {
		minChild(tree.getRoot());
	}
	
	private int minChild(BinaryNode node) {
		
		if(node != null) {
			
			if(node.getLeft() == null && node.getRight() == null) return node.getValue();
			
			int left_min = minChild(node.getLeft());
			int right_min = minChild(node.getRight());
			int minimum = Integer.min(left_min, right_min);
			
			result = Integer.max(result, node.getValue() - minimum);
			return Integer.min(minimum, node.getValue());
		}
		
		return Integer.MAX_VALUE;
	}
	
	//My solution
	public List<Integer> maxAncestorDiff(BinaryTree tree) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		Map<BinaryNode, Boolean> visited = new HashMap<BinaryNode, Boolean>();
		for(BinaryNode node : tree.getNodeList()) visited.put(node, false);
		visited.replace(tree.getRoot(), true);
		
		Stack stack = new Stack();
		stack.push(tree.getRoot());
		int max_diff = Integer.MIN_VALUE;
		
		while(stack.getStack().size() > 0) {
			
			BinaryNode node = stack.getTop();
			boolean has_left = node.getLeft() != null;
			boolean has_right = node.getRight() != null;
			boolean leaf = !has_left && !has_right;
			
			if(has_left && !visited.get(node.getLeft())) {
				stack.push(node.getLeft());
				visited.replace(node.getLeft(), true);
				continue;
			}
			
			if(has_right && !visited.get(node.getRight())) {
				stack.push(node.getRight());
				visited.replace(node.getRight(), true);
				continue;
			}
			
			if(leaf) {
				int min_val = Integer.MAX_VALUE;
				int max_val = Integer.MIN_VALUE;
				
				for(BinaryNode temp: stack.getStack()) {
					if(min_val > temp.getValue()) min_val = temp.getValue();
					if(max_val < temp.getValue()) max_val = temp.getValue();
				}
				
				int abs_val = Math.abs(min_val - max_val);
				if(max_diff < abs_val) {
					result = new ArrayList<Integer>();
					result.add(min_val);
					result.add(max_val);
					max_diff = abs_val;
				}
			}
			
			stack.pop();
		}
		
		return result;
	}
	
	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - \n");
		init.printTree(tree);
		
		MaxAncestorDiff mad = new MaxAncestorDiff();
		List<Integer> result = mad.maxAncestorDiff(tree);
		
		int x = result.get(0);
		int y = result.get(1);
		int diff = Math.abs(x - y);
		
		System.out.println("Maximum Difference :\n" + y + " - " + x + " = " + diff);		
	}
	*/
}
