package treesIP;

import java.util.ArrayList;
import java.util.List;

public class LowestComAncestor {
	
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
		LowestComAncestor lca = new LowestComAncestor();
		
		while(true) {
			System.out.print("Enter the first node : ");
			int node_val = Integer.parseInt(br.readLine());
			BinaryNode target1 = new BinaryNode(node_val);
			
			System.out.print("Enter the second node : ");
			node_val = Integer.parseInt(br.readLine());
			BinaryNode target2 = new BinaryNode(node_val);
	
			BinaryNode common = lca.lowestComAncestor(tree, target1, target2);
			System.out.println("Lowest Common Ancestor : " + common.getValue() + "\n");
		}
	}
	*/
	
	public BinaryNode lowestComAncestor(BinaryTree tree, BinaryNode target1, BinaryNode target2) {
		
		List<BinaryNode> path1 = findPath(tree, target1);
		List<BinaryNode> path2 = findPath(tree, target2);
		
		for(BinaryNode node : path1) {
			if(path2.contains(node))
				return node;
		}
		
		return null;
	}
	
	
	private List<BinaryNode> findPath(BinaryTree tree, BinaryNode target) {
		
		List <BinaryNode> path = new ArrayList<BinaryNode>();
		constructPath(tree.getRoot(), target, path);
		return path;
	}
	
	private boolean constructPath(BinaryNode node, BinaryNode target, List<BinaryNode> path) {

		if(node == null)
			return false;
		
		if(node.getValue() == target.getValue()) {
			path.add(node);
			return true;
		}
		
		if(constructPath(node.getLeft(), target, path) || constructPath(node.getRight(), target, path)) {
			path.add(node);
			return true;
		}
		
		return false;
	}
	
}
