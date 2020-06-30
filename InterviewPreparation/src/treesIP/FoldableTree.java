package treesIP;

public class FoldableTree {
	
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

		FoldableTree fold = new FoldableTree();
		if(fold.foldableTree(tree)) System.out.println("Foldable");
		else System.out.println("Not Foldable");;
	
	} 
	*/

	public boolean foldableTree(BinaryTree tree) {
		
		BinaryNode root = tree.getRoot();
		
		if(root.getLeft() != null && root.getRight() != null)
			return checkMirror(root.getLeft(), root.getRight());
		
		return false;
	}
	
	private boolean checkMirror(BinaryNode root_left, BinaryNode root_right) {

		if(root_left != null && root_right != null) {
			
			boolean check_left = checkMirror(root_left.getLeft(), root_right.getRight());
			boolean check_right = checkMirror(root_right.getLeft(), root_left.getRight());
			return check_left && check_right;
		}
		
		else if(root_left == null && root_right == null) 
			return true;
		
		else 
			return false;
	}
}
