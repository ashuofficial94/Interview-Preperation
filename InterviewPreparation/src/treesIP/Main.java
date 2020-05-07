package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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
		
}
