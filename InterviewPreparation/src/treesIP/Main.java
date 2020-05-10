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

		TreeToDLinkList t2d = new TreeToDLinkList();
		BinaryNode head = t2d.treeToDLinkList(tree);

		System.out.println();
		for(BinaryNode node = head; node != null; 
				System.out.print(node.getValue() + " "),node = node.getRight());
		
	}
		
}
