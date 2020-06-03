package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

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
}
