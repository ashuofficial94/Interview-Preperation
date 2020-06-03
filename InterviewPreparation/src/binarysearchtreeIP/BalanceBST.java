package binarysearchtreeIP;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
	/*
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Elements - \n" );
		
		String[] input = br.readLine().trim().split(" ");
		List<Integer> elem = new ArrayList<Integer>();
		
		for(String in: input) {
			elem.add(Integer.parseInt(in));
		}
		
		InitializeTree init = new InitializeTree();
		Tree tree = init.initializeTree(elem);
		init.printTree(tree);

		BalanceBST bal = new BalanceBST();
		init.printTree(bal.balanceBST(tree));
	} 
	*/
	
	public Tree balanceBST(Tree un_tree) {
		
		List<Node> nodes = new ArrayList<Node>();
		getNodes(nodes, un_tree.getRoot());
		
		Node root = constructBalancedBST(nodes, 0, nodes.size()-1);
		Tree bal_tree = new Tree(root);
		
		return bal_tree;
	}
	
	private Node constructBalancedBST(List<Node> nodes, int start, int end) {
		
		if(start <= end) {
			
			int mid = (start+end)/2;
			Node node = nodes.get(mid);
			node.setLeft(constructBalancedBST(nodes, start, mid-1));
			node.setRight(constructBalancedBST(nodes, mid+1, end));
			
			return node;
		}
		
		return null;
	}
	
	private void getNodes(List<Node> nodes, Node node) {
		
		if(node != null) {
			getNodes(nodes, node.getLeft());
			nodes.add(node);
			getNodes(nodes, node.getRight());
		}
	}
}
