package treesIP;

import java.util.ArrayList;
import java.util.List;

public class SubTree {

	//SubTree nodes will come together in the inorder, preorder and postorder
	//and in the same sequence as the traversal sequence of the subtree
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
		
		while(true) {
			System.out.print("Enter Root : ");
			root_val = Integer.parseInt(br.readLine());
			BinaryTree sub_tree = new BinaryTree(new BinaryNode(root_val));
	
			sub_tree = init.initializeTree(sub_tree);
			
			System.out.println("Sub Tree - ");
			init.printTree(sub_tree);
			
			SubTree sub = new SubTree();
			System.out.println(sub.subTree(sub_tree, tree) + "\n");
		}
	}
	*/
	
	public boolean subTree(BinaryTree sub, BinaryTree tree) {

		List<BinaryNode> tree_in = new ArrayList<BinaryNode>();
		List<BinaryNode> tree_pre = new ArrayList<BinaryNode>();
		List<BinaryNode> sub_in = new ArrayList<BinaryNode>();
		List<BinaryNode> sub_pre = new ArrayList<BinaryNode>();
		
		inPre(tree.getRoot(), tree_in, tree_pre);
		inPre(sub.getRoot(), sub_in, sub_pre);

		System.out.print("Inorder Tree: ");
		printList(tree_in);
		System.out.print("Preorder Tree: ");
		printList(tree_pre);
		System.out.print("Inorder Sub: ");
		printList(sub_in);
		System.out.print("Preorder Sub: ");
		printList(sub_pre);
		
		boolean found = false;
		
		for(int i=0; i<=tree_in.size() - sub_in.size()+1; i++) {
			
			if(tree_in.get(i).getValue() == sub_in.get(0).getValue()) {
				
				found = true;
				for(int j=0; j<sub_in.size(); j++, i++) {	
					System.out.println();
					if(sub_in.get(j).getValue() != tree_in.get(i).getValue()) {
						found = false;
						break;
					}
				}
				if(found)
					break;
			}
		}
		
		if(!found)
			return false;
		
		for (int i = 0; i <= tree_pre.size() - sub_pre.size()+1; i++) {

			if (tree_pre.get(i).getValue() == sub_pre.get(0).getValue()) {

				found = true;
				for (int j = 0; j < sub_pre.size(); j++, i++) {
					if (sub_pre.get(j).getValue() != tree_pre.get(i).getValue()) {
						found = false;
						break;
					}
				}
				if(found)
					break;
			}
		}
		
		return found;
		
	}
	
	private void printList(List<BinaryNode> list) {
		for(BinaryNode node: list) {
			System.out.print(node.getValue() + " ");
		}
		System.out.println();
	}
	
	private void inPre(BinaryNode node, List<BinaryNode> inorder, List<BinaryNode> preorder) {
		
		if(node != null) {

			preorder.add(node);
			inPre(node.getLeft(), inorder, preorder);
			inorder.add(node);
			inPre(node.getRight(), inorder, preorder);
		}
		return;
	}
	
	public boolean subTree2(BinaryNode sub_root, BinaryNode tree_root) {
		
		if(sub_root == null)return true;
		if(tree_root == null) return false;
		
		IdenticalTrees iden = new IdenticalTrees();
		if(iden.identicalTrees(sub_root, tree_root)) return true;
		
		return subTree2(sub_root, tree_root.getLeft()) || subTree2(sub_root, tree_root.getRight());
	}
}
