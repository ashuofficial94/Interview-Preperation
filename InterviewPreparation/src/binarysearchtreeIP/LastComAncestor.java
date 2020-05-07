package binarysearchtreeIP;

import java.util.List;

public class LastComAncestor {

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

		while(true) {
			System.out.print("\nEnter the first number : ");
			int val = Integer.parseInt(br.readLine());
			Node node1 = new Node(val);
			
			System.out.print("\nEnter the second number : ");
			val = Integer.parseInt(br.readLine());
			Node node2 = new Node(val);
			
			LastComAncestor lca = new LastComAncestor();
			Node com = lca.lastComAncestor(tree, node1, node2);
			
			System.out.println("\nLeast Common Node : " + com.getValue());
		}
	}
	 */
	
	//My solution
	public Node lastComAncestor(Tree tree, Node node1, Node node2) {
		
		FindPath fp = new FindPath();
		List<Node> path1 = fp.findPath(tree, node1);
		List<Node> path2 = fp.findPath(tree, node2);
		int min = Integer.min(path1.size(), path2.size());
		
		for(int i=0; i<min; i++) {
			if(!path1.get(i).equals(path2.get(i)))
					return path1.get(i-1);
		}
		
		if(path1.size() < path2.size())
			return path1.get(path1.size()-1);
		
		return path2.get(path2.size()-1);
	}
	
	//RBR Solution
	public Node lastCommAncestor(Tree tree, Node node1, Node node2) {
		
		Node curr = tree.getRoot();
		
		while(true) {
			
			if(curr.getValue() > node1.getValue() && curr.getValue() > node2.getValue())
				curr = curr.getLeft();
			
			else if(curr.getValue() < node1.getValue() && curr.getValue() < node2.getValue())
				curr = curr.getRight();
			
			else 
				return curr;
		}
	}
}
