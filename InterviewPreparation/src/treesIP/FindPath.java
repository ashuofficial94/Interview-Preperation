package treesIP;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

	/*public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - \n");
		init.printTree(tree);

		System.out.print("Enter the node to be searched : ");
		int node_val = Integer.parseInt(br.readLine());
		
		BinaryNode target = new BinaryNode(node_val);
		LowestComAncestor lca = new LowestComAncestor();
		List<BinaryNode> path = lca.findPath(tree, target);
		
		System.out.print("Path : ");
		for(BinaryNode node: path) {
			System.out.print(node.getValue()+" ");
		}
		
	}*/
	
	public List<BinaryNode> findPath(BinaryTree tree, BinaryNode target) {
		
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
