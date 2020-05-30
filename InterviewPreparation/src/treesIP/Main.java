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
			System.out.print("Enter 1st Node: ");
			int val1 = Integer.parseInt(br.readLine());
			System.out.print("Enter 2nd Node: ");
			int val2 = Integer.parseInt(br.readLine());
			
			CousinNodes cn = new CousinNodes();
			
			if(cn.cousinNodes(tree, val1, val2)) System.out.println("Cousins");
			else System.out.println("Not Cousins");
			
			System.out.println();
		}
	}
}
