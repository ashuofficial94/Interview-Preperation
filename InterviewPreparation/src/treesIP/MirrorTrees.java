package treesIP;

public class MirrorTrees {

	private BinaryTree tree1;
	private BinaryTree tree2;
	
	private BinaryTree tree;
	private BinaryTree mirror;
	
	MirrorTrees(BinaryTree tree1, BinaryTree tree2) {
		this.tree1 = tree1;
		this.tree2 = tree2;
	}
	
	MirrorTrees(BinaryTree tree) {
		this.tree = tree;
	}
	
	public BinaryTree getMirror() {
		
		mirror = new BinaryTree(tree.getRoot());
		constructMirror(mirror.getRoot());
		return mirror;
	}
	
	private void constructMirror(BinaryNode m_node) {
		
		BinaryNode m_left, m_right;
		
		if(tree.getNode(m_node) != null) {
			
			BinaryNode t_node = tree.getNode(m_node);
			m_left = t_node.getRight();
			m_right = t_node.getLeft();
			
			m_node.setLeft(m_left);
			m_node.setRight(m_right);
			
			if(m_left != null) {		
				constructMirror(m_left);
			}
			if(m_right != null) {
				constructMirror(m_right);
			}
			
		}
	}
	
	/*	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - \n");
		init.printTree(tree);
		
		MirrorTrees mir = new MirrorTrees(tree);
		System.out.println("Mirror Tree - \n");
		init.printTree(mir.getMirror());
		
	} */
	
	public boolean mirrorTreesCheck() {
		return mirrorCheck(tree1.getRoot(), tree2.getRoot());
	}
	
	private boolean mirrorCheck(BinaryNode node1, BinaryNode node2) {
		
		if(node1 == null && node2 == null)
			return true;
		
		else if(node1 != null && node2 != null) {
		
			boolean val = (node1.getValue() == node2.getValue());
			boolean lr = mirrorCheck(node1.getLeft(), node2.getRight());
			boolean rl = mirrorCheck(node1.getRight(), node2.getLeft());
			
			return val && lr && rl;
		}	
		
		else 
			return false;
	}
	
	/*
	 	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree1 = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init1 = new InitializeTree(tree1);
		tree1 = init1.initializeTree();
		
		System.out.print("Enter Root : ");
		root_val = Integer.parseInt(br.readLine());
		BinaryTree tree2 = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init2 = new InitializeTree(tree2);
		tree2 = init2.initializeTree();
		
		System.out.println("Tree 1 - \n");
		init1.printTree();
		System.out.println("Tree 2 - \n");
		init2.printTree();
		
		MirrorTrees mir = new MirrorTrees(tree1, tree2);
		
		System.out.println(mir.mirrorTrees());
	}
	*/
}
