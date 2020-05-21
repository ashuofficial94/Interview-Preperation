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
		
		System.out.println("Tree - ");
		init.printTree(tree);
		
		while(true) {
			System.out.print("Enter Root : ");
			root_val = Integer.parseInt(br.readLine());
			BinaryTree sub_tree = new BinaryTree(new BinaryNode(root_val));
	
			sub_tree = init.initializeTree(sub_tree);
			
			System.out.println("Sub Tree - ");
			init.printTree(sub_tree);
			
			SubTree sub = new SubTree();
			System.out.println(sub.subTree(sub_tree, tree) + "\n");
		}
	}
}
