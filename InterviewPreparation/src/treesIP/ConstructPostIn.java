package treesIP;

import java.util.ArrayList;
import java.util.List;

public class ConstructPostIn {
	
	public BinaryTree constructPostIn(List<Integer> postorder, List<Integer> inorder) {
		
//		BinaryNode root = new BinaryNode(postorder.get(postorder.size()-1));
//		BinaryTree tree = new BinaryTree(root);	
//		constructPostInRec(postorder, inorder, tree.getRoot());
		
		BinaryTree tree = new BinaryTree(buildTree(postorder, inorder));
		return tree;
		
	}
	
	private BinaryNode buildTree(List<Integer> postorder, List<Integer> inorder) {
		
		if(inorder.size() > 0) {
			
			BinaryNode node = new BinaryNode(postorder.remove(postorder.size()-1));
			int index = inorder.indexOf(node.getValue());

			node.setRight(buildTree(postorder, inorder.subList(index+1, inorder.size())));
			node.setLeft(buildTree(postorder, inorder.subList(0, index)));
			return node;
		}
		
		return null;
	}
	
	public void constructPostInRec(List<Integer> post_temp, List<Integer> in_temp, BinaryNode node) {
		
		if(post_temp.size() == 0)
			return;

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
		
		if(post_left.size() > 0) {
			
			BinaryNode left = new BinaryNode(post_left.get(post_left.size() - 1));
			node.setLeft(left);
			constructPostInRec(post_left, in_left, left);
		}
		
		if(post_right.size() > 0) {

			BinaryNode right = new BinaryNode(post_right.get(post_right.size() - 1));	
			node.setRight(right);
			constructPostInRec(post_right, in_right, right);
		}
		
		return;
	}
	
	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter postorder : ");
		
		String[] input = br.readLine().trim().split(" ");
		List<Integer> postorder = new ArrayList<Integer>();
		
		for(String val: input) {
			postorder.add(Integer.parseInt(val));
		}
		
		System.out.print("Enter indorder : ");
		
		input = br.readLine().trim().split(" ");
		List<Integer> inorder = new ArrayList<Integer>();
		
		for(String val: input) {
			inorder.add(Integer.parseInt(val));
		}
		
		ConstructPostIn cons = new ConstructPostIn();
		BinaryTree tree = cons.constructPostIn(postorder, inorder);
		
		System.out.println("Tree - ");
		InitializeTree init = new InitializeTree();
		init.printTree(tree);
	}	
	*/
}
