package treesIP;

public class TreeToDLinkList {

	/*private DLinkList list = null;
	
	public DLinkList treeToDLinkList(BinaryTree tree) {

		inorder(tree.getRoot());
		return list;
	}
	
	private void inorder(BinaryNode node) {
		
		if(node != null) {
			
			inorder(node.getLeft());
			
			if(list == null) {
				list = new DLinkList();
			}
			
			list.addNodeEnd(new DLinkNode(node.getValue()));
			inorder(node.getRight());
		}
	}
	*/
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

		TreeToDLinkList t2d = new TreeToDLinkList();
		BinaryNode head = t2d.treeToDLinkList(tree);

		System.out.println();
		for(BinaryNode node = head; node != null; 
				System.out.print(node.getValue() + " "),node = node.getRight());
		
	}*/
	
	public BinaryNode treeToDLinkList(BinaryTree tree) {
		
		BinaryNode node = inplaceNsquare(tree.getRoot());
		BinaryNode head;
		
		for(head = node; head.getLeft() != null; head = head.getLeft());
		
		return head;
	}
	
	private BinaryNode inplaceNsquare(BinaryNode node) {
		
		if(node.getLeft() != null) {
			
			BinaryNode left_sub = inplaceNsquare(node.getLeft());
			while(left_sub.getRight() != null)
				left_sub = left_sub.getRight();
			
			node.setLeft(left_sub);
			left_sub.setRight(node);
		}
		
		if(node.getRight() != null) {
		
			BinaryNode right_sub = inplaceNsquare(node.getRight());
			while(right_sub.getLeft() != null)
				right_sub = right_sub.getLeft();
			
			node.setRight(right_sub);
			right_sub.setLeft(node);
		}

		return node;
	}
	
	
}
