package treesIP;

public class DeletePaths {
	
	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - ");
		init.printTree(tree);
		
		System.out.print("Enter the path to be deleted - (less than)");
		int path_length = Integer.parseInt(br.readLine());
		DeletePaths del = new DeletePaths();
		tree = del.deletePaths(tree, path_length);
		
		init.printTree(tree);
	}
	*/
	
	public BinaryTree deletePaths(BinaryTree tree, int path_length) {
	
		removeNodes(tree, tree.getRoot(), path_length);
		return tree;
	}
	
	//RBR Solution
	
	public BinaryNode removeNodes(BinaryTree tree, BinaryNode node, int path_length) {
		
		if(path_length == 0)
			return node;
		
		if(node == null)
			return null;
		
		node.setLeft(removeNodes(tree, node.getLeft(), path_length-1));
		node.setRight(removeNodes(tree, node.getRight(), path_length-1));
		
		if(node.getLeft() == null && node.getRight() == null) {

			BinaryNode parent = tree.getParent(node);
			
			if(parent.getLeft() != null && parent.getLeft().equals(node))
				parent.setLeft(null);
			
			else if(parent.getRight() != null && parent.getRight().equals(node))
				parent.setRight(null);
			
			return null;
		}
		
		return node;
	}
	
	//My solution - Almost wrong
	
	public boolean checkPath(BinaryTree tree, BinaryNode node, int path_length) {
		
		if(node != null) {
			
			boolean leaf = node.getLeft() == null && node.getRight() == null;
			if(leaf && path_length > 0) {
				
				BinaryNode parent = tree.getParent(node);
				
				if(parent.getLeft() != null && parent.getLeft().equals(node))
					parent.setLeft(null);
				
				else if(parent.getRight() != null && parent.getRight().equals(node))
					parent.setRight(null);
				
				return true;
			}
			
			
			boolean left_del = checkPath(tree, node.getLeft(), path_length-1);
			boolean right_del = checkPath(tree, node.getRight(), path_length-1);
				
			if(left_del && right_del) {

				BinaryNode parent = tree.getParent(node);
				if(parent.getLeft().equals(node)) parent.setLeft(null);
				else parent.setRight(null);
				return true;
			}
				
			return false;
		}
		
		return false;
	}
}
