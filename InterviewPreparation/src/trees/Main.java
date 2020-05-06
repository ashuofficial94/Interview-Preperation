package trees;

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
		BinaryTreeOperations opr = new BinaryTreeOperations(tree);

		boolean exit = false;
		
		while(!exit) {
			
			System.out.println("\n1. Add to Tree");
			System.out.println("2. Print Tree");
			System.out.println("3. Preorder");
			System.out.println("4. Inorder");
			System.out.println("5. Postorder");
			System.out.println("6. New Tree");
			System.out.println("7. Height of Tree\n");
			
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(br.readLine());
			System.out.println();
			
			switch(choice) {
			
			case 1:
				tree = opr.initializeTree();
				break;
				
			case 2: 
				opr.printTree(tree);
				break;
				
			case 3:
				List<BinaryNode> preorder = opr.getPreorder();
				System.out.print("Preorder : ");
				
				for(BinaryNode node: preorder) 
					System.out.print(node.getValue() + " ");
				
				System.out.println();
				break;
				
			case 4:
				List<BinaryNode> inorder = opr.getInorder();
				System.out.print("Inorder : ");
				
				for(BinaryNode node: inorder) 
					System.out.print(node.getValue() + " ");
				
				System.out.println();
				break;
				
			case 5:

				List<BinaryNode> postorder = opr.getPostorder();
				System.out.print("Postorder : ");
				
				for(BinaryNode node: postorder) 
					System.out.print(node.getValue() + " ");
				
				System.out.println();
				break;
				
			case 6:
				
				System.out.print("Enter Root: ");
				root_val = Integer.parseInt(br.readLine());
				tree = new BinaryTree(new BinaryNode(root_val));
				opr = new BinaryTreeOperations(tree);
				break;
				
			case 7:
				
				System.out.println("Height of Tree: " + opr.height(tree.getRoot()));
				break;
				
			default:
				exit = true;
				System.out.println("Thanks for using Trees. Bye.\n");
				break;
			}
		}
	}
}
