package treesIP;

import java.util.ArrayList;
import java.util.List;

public class Serialization {
	
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
		
		Serialization obj = new Serialization();
		List<BinaryNode> serial = obj.serialization(tree);
		
		for(BinaryNode node: serial)
			System.out.print(node.getValue() + " ");
		
		System.out.println("\n\nDeserialized Tree - \n");
		init.printTree(obj.deserialize(serial));
	}
	*/
	
	public List<BinaryNode> serialization(BinaryTree tree) {
		
		List<BinaryNode> serial = new ArrayList<BinaryNode>();
		preorder(tree.getRoot(), serial);
		return serial;
	}
	
	private void preorder(BinaryNode node, List<BinaryNode> serial) {
		
		serial.add(node);
		
		if(node.getLeft() == null) serial.add(new BinaryNode(0));
		else preorder(node.getLeft(), serial);
		
		if(node.getRight() == null) serial.add(new BinaryNode(0));
		else preorder(node.getRight(), serial);
	}
	
	public BinaryTree deserialize(List<BinaryNode> serial) {
		
		BinaryTree tree = new BinaryTree(buildTree(serial));
		return tree;
	}
	
	private BinaryNode buildTree(List<BinaryNode> serial) {
		
		BinaryNode node = serial.remove(0);
		
		if(node.getValue() != 0) {
			
			node.setLeft(buildTree(serial));
			node.setRight(buildTree(serial));
			return node;
		}
		
		return null;
	}
}
