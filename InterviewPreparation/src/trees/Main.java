package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
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
			System.out.println("2. Print Tree");
			System.out.println("3. Prefix");
			System.out.println("4. Infix");
			System.out.println("5. Postfix");
			System.out.println("6. New Tree\n");
			
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(br.readLine());
			System.out.println();
			
			switch(choice) {
			
			case 1:
				tree = opr.initializeTree(tree);
				break;
				
			case 2: 
				opr.printTree(tree);
				break;
				
			case 3:
				List<BinaryNode> prefix = opr.getPrefix(tree);
				System.out.print("Prefix : ");
				
				for(BinaryNode node: prefix) 
					System.out.print(node.getValue() + " ");
				
				System.out.println();
				break;
				
			case 4:
				List<BinaryNode> infix = opr.getInfix(tree);
				System.out.print("Infix : ");
				
				for(BinaryNode node: infix) 
					System.out.print(node.getValue() + " ");
				
				System.out.println();
				break;
				
			case 5:

				List<BinaryNode> postfix = opr.getPostfix(tree);
				System.out.print("Postfix : ");
				
				for(BinaryNode node: postfix) 
					System.out.print(node.getValue() + " ");
				
				System.out.println();
				break;
				
			case 6:
				
				System.out.print("Enter Root: ");
				root_val = Integer.parseInt(br.readLine());
				tree = new BinaryTree(new BinaryNode(root_val));
				break;
				
			default:
				exit = true;
				System.out.println("Thanks for using Trees. Bye.\n");
				break;
			}
		}
	}
}
