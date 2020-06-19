package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

		while(true) {
			
			System.out.print("Enter the Node - ");
			int target = Integer.parseInt(br.readLine());
			
			NextRight nr = new NextRight();
			BinaryNode right =  nr.nextRight(tree, target);
			if(right != null) System.out.println("Next Right - " + right.getValue() + "\n");
			else System.out.println("Not found.\n");
		}
	
	} 
}
