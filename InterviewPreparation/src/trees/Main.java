package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinaryTreeOperations opr = new BinaryTreeOperations();

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		boolean exit = false;
		
		while(!exit) {
			
			System.out.println("\n1. Add to Tree");
			System.out.println("2. Print Tree\n");
			
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			
			case 1:
				tree = opr.initializeTree(tree);
				break;
				
			case 2: 
				opr.printTree(tree);
				break;
				
			default:
				exit = true;
				System.out.println("\nThanks for using Trees. Bye.\n");
				break;
			}
		}
	}
}
