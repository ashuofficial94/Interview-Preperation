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
		
		System.out.println("Tree - \n");
		init.printTree(tree);

		View view = new View(tree);
		
		List<BinaryNode> top_view = view.topView();
		List<BinaryNode> bottom_view = view.bottomView();
		List<BinaryNode> left_view = view.leftView();
		List<BinaryNode> right_view = view.rightView();
		
		System.out.print("Top View: ");
		printList(top_view);
		
		System.out.print("Bottom View: ");
		printList(bottom_view);
		
		System.out.print("Left View: ");
		printList(left_view);
		
		System.out.print("Right View: ");
		printList(right_view);
	}
		
	public static void printList(List<BinaryNode> list) {
		
		for(BinaryNode node: list) 
			System.out.print(node.getValue()+" ");
		
		System.out.println();
	}
}
