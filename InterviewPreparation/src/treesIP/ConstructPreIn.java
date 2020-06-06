package treesIP;

import java.util.ArrayList;
import java.util.List;

public class ConstructPreIn {

	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter preorder : ");
		
		String[] input = br.readLine().trim().split(" ");
		List<Integer> preorder = new ArrayList<Integer>();
		
		for(String val: input) {
			preorder.add(Integer.parseInt(val));
		}
		
		System.out.print("Enter inorder : ");
		
		input = br.readLine().trim().split(" ");
		List<Integer> inorder = new ArrayList<Integer>();
		
		for(String val: input) {
			inorder.add(Integer.parseInt(val));
		}
		
		ConstructPreIn cons = new ConstructPreIn();
		BinaryTree tree = cons.constructPreIn(preorder, inorder);
		
		System.out.println("Tree - ");
		InitializeTree init = new InitializeTree();
		init.printTree(tree);
	}
	*/
	
	public BinaryTree constructPreIn(List<Integer> preorder, List<Integer> inorder) {
		
//		BinaryNode root = new BinaryNode(preorder.get(0));
//		BinaryTree tree = new BinaryTree(root);
//		constructPreInRec(preorder, inorder, tree.getRoot());
		
		BinaryTree tree = new BinaryTree(buildTree(preorder, inorder));
		return tree;
	}
	
	//RBR Solution
	private BinaryNode buildTree(List<Integer> preorder, List<Integer> inorder) {

		if(inorder.size() > 0) {
			
			BinaryNode node = new BinaryNode(preorder.remove(0));
			int index = inorder.indexOf(node.getValue());
			
			node.setLeft(buildTree(preorder, inorder.subList(0, index)));
			node.setRight(buildTree(preorder, inorder.subList(index+1, inorder.size())));
			
			return node;
		}
		
		return null;
	}
	
	//My solution
	public void constructPreInRec(List<Integer> pre_temp, List<Integer> in_temp, BinaryNode node) {
		
		
		if(pre_temp.size() == 0)
			return;
		
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
