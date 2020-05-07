package binarysearchtreeIP;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

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
		
		System.out.print("\nEnter the number to be search : ");
		int key = Integer.parseInt(br.readLine());
		System.out.print("Path - ");
		FindPath fp = new FindPath();
		
		List<Node> path = fp.findPath(tree, new Node(key));
		for(Node node: path)
			System.out.print(node.getValue() + " ");
	}
	*/
	
	public List<Node> findPath(Tree tree, Node node) {
		
		List<Node> path = new ArrayList<Node>();
		Node curr = tree.getRoot();
		
		while(true) {
			
			if(curr == null)
				return null;
			
			path.add(curr);
			
			if(node.getValue() == curr.getValue()) {
				return path;
			}
			
			else if(node.getValue() > curr.getValue()) {
				curr = curr.getRight();
			}
			
			else {
				curr = curr.getLeft();
			}
		}
	}
}
