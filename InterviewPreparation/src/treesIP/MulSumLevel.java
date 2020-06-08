package treesIP;

import java.util.ArrayList;
import java.util.List;

//find the multiplication of the sum of data at each level

public class MulSumLevel {

	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - \n");
		init.printTree(tree);

		MulSumLevel msl = new MulSumLevel();
		System.out.println("Product of the sum of data at each level : " + msl.mulSumLevel(tree));
	}
	*/
	
	public int mulSumLevel(BinaryTree tree) {
		
		List<BinaryNode> curr_level = new ArrayList<BinaryNode>();
		curr_level.add(tree.getRoot());
		int product = 1;
		
		while(true) {
		
			int sum = 0;
			List<BinaryNode> next_level = new ArrayList<BinaryNode>();
			
			for(BinaryNode node: curr_level) {
				sum += node.getValue();
				if(node.getLeft() != null) next_level.add(node.getLeft());
				if(node.getRight() != null) next_level.add(node.getRight());
			}
			
			product *= sum;
			
			if(next_level.size() == 0) break;
			curr_level = next_level;
		}
		
		return product;
	}
}
