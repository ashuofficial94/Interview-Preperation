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
	
		LevelSpiral ls = new LevelSpiral();
		for(BinaryNode node: ls.levelSpiral(tree)) {
			System.out.print(node.getValue() + " ");
		}
	}
}
