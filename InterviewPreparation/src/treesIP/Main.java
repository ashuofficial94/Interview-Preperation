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

		DiameterBinary db = new DiameterBinary();
		
		List<BinaryNode> diameter = db.diameterListBinary(tree);
		System.out.print("\nDiameter : ");
		
		for(BinaryNode node : diameter) {
			System.out.print(node.getValue() + " ");
		}
		
		System.out.println();
		System.out.print("Length : " + (db.diameterBinary(tree)-1));
		
	}
		
}
