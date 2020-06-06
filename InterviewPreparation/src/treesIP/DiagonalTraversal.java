package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {

	//Solution : increment the diagonal number when going left of the node
	//Keep diagonal number same when going to the right of the node
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
		
		System.out.println("Diagonal Traversal : ");
		
		DiagonalTraversal dt = new DiagonalTraversal();
		dt.diagonalTraversal(tree);
	}
	*/
	public void diagonalTraversal(BinaryTree tree) {
		
		Map<Integer, List<BinaryNode>> diagonals = new HashMap<Integer, List<BinaryNode>>();
		setDiagonals(tree.getRoot(), 0, diagonals);

		int max = Integer.MIN_VALUE;
		for(int key: diagonals.keySet()) {
			if(key > max) max = key;
		}
		
		for(int i=0; i<=max; i++) {
			System.out.print(i + " : ");
			for(BinaryNode node: diagonals.get(i)) System.out.print(node.getValue()+" ");
			System.out.println();
		}
		
		return;
	}
	
	private void setDiagonals(BinaryNode node, int diagonal, Map<Integer, List<BinaryNode>> diagonals) {
		
		if(node != null) {
			
			if(!diagonals.containsKey(diagonal)) diagonals.put(diagonal, new ArrayList<BinaryNode>());
			
			diagonals.get(diagonal).add(node);
			setDiagonals(node.getLeft(), diagonal+1, diagonals);
			setDiagonals(node.getRight(), diagonal, diagonals);
		}
	}
}
