package treesIP;

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
	
	//My Solution
	
	public BinaryNode lowestComAncestor(BinaryTree tree, BinaryNode target1, BinaryNode target2) {
		
		FindPath fp = new FindPath();
		List<BinaryNode> path1 = fp.findPath(tree, target1);
		List<BinaryNode> path2 = fp.findPath(tree, target2);
		
		int index1, index2;
		
		for(index1 = path1.size()-1, index2 = path2.size()-1; index1 >= 0 && index2 >= 0; 
			index1--,index2--) {
			
			if(!path1.get(index1).equals(path2.get(index2)))
				return path1.get(index1+1);
			
		}
		
		if(index1 == -1)
			return path1.get(0);
		
		if(index2 == -1)
			return path2.get(0);
		
		return null;
	}
	
	//RBR Solution
	//For a node to be the least common ancestor, it's left subtree must contain one 
	//node and the right subtree must contain the other node
	
	public BinaryNode lowestCommAncestor(BinaryTree tree, BinaryNode target1, BinaryNode target2) {
		
		return lastCommon(tree.getRoot(), target1, target2);
	}
	
	private BinaryNode lastCommon(BinaryNode node, BinaryNode target1, BinaryNode target2) {
		
		if(node == null)
			return null;

		if(node.getValue() == target1.getValue() || node.getValue() == target2.getValue())
			return node;
		
		BinaryNode left_sub = lastCommon(node.getLeft(), target1, target2);
		BinaryNode right_sub = lastCommon(node.getRight(), target1, target2);
		
		if(left_sub != null && right_sub != null)
			return node;
		
		BinaryNode anc = left_sub != null ? left_sub : right_sub;
		
		return anc;
	}
}
