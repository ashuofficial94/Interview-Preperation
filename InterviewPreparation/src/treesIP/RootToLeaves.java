package treesIP;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class RootToLeaves {
	
	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - ");
		init.printTree(tree);
	
		RootToLeaves rtl = new RootToLeaves();
		
		List<List<BinaryNode>> paths = rtl.rootToLeaves(tree);
		
		System.out.println("Root to Leave Paths - ");
		
		for(List<BinaryNode> path: paths) {
			for(BinaryNode node: path) {
				System.out.print(node.getValue() + " ");
			}
			System.out.println();
		}
	}
	 */

	public List<List<BinaryNode>> rootToLeaves(BinaryTree tree) {

		List<List<BinaryNode>> paths = new ArrayList<List<BinaryNode>>();
		Stack stack = new Stack();
		stack.push(tree.getRoot());
		boolean changed = true;
		
		Map<BinaryNode, Boolean> visited = new HashMap<BinaryNode, Boolean>();
		for(BinaryNode node: tree.getNodeList()) visited.put(node, false);
		visited.replace(tree.getRoot(), true);
		
		while(stack.getStack().size() > 0) {
			
			BinaryNode node = stack.getTop();
			boolean has_left = node.getLeft() != null;
			boolean has_right = node.getRight() != null;
			
			if(has_left && !visited.get(node.getLeft())) {
				stack.push(node.getLeft());
				visited.replace(node.getLeft(), true);
				changed = true;
				continue;
			}
			
			if(has_right && !visited.get(node.getRight())) {
				stack.push(node.getRight());
				visited.replace(node.getRight(), true);
				changed = true;
				continue;
			}
			
			if(changed) {
				changed = false;
				List<BinaryNode> path = new ArrayList<BinaryNode>(stack.getStack());
				paths.add(path);
			}
			
			stack.pop();
		}
		
		return paths;
	}

}
