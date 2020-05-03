package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinaryTreeOperations opr = new BinaryTreeOperations();

		System.out.println("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		tree = opr.initializeTree(tree);
		
	}
}
