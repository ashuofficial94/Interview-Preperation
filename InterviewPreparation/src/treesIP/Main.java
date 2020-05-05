package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree1 = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init1 = new InitializeTree(tree1);
		tree1 = init1.initializeTree();
		
		System.out.print("Enter Root : ");
		root_val = Integer.parseInt(br.readLine());
		BinaryTree tree2 = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init2 = new InitializeTree(tree2);
		tree2 = init2.initializeTree();
		
		System.out.println("Tree 1 - \n");
		init1.printTree();
		System.out.println("Tree 2 - \n");
		init2.printTree();
		
		IdenticalTrees iden = new IdenticalTrees();
		
		if(iden.identicalTrees(tree1.getRoot(), tree2.getRoot()))
			System.out.println("Identical Trees");
		
		else
			System.out.println("Not Identical");
	}
		
}
