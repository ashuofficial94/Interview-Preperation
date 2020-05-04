package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class BinaryTreeOperations {
	
	private List<BinaryNode> prefix;
	private List<BinaryNode> postfix;
	private List<BinaryNode> infix;
	
	public BinaryTree initializeTree(BinaryTree tree) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("5Enter -1 as a Parent to save.");
		System.out.println("Parent can only be the nodes which already exist.");
		System.out.println("Enter any alphabet as a null child.");
		
		Validation valid = new Validation();
		int parent;
		
		while(true) {
			
			System.out.print("\nParent : ");
			
			try {
				parent = Integer.parseInt(br.readLine());
			}
			
			catch(NumberFormatException e) {
				System.out.println("No such node exists");
				continue;
			}
			
			if(parent == -1) {
				System.out.println("Tree Saved.");
				break;
			}
			
			BinaryNode parent_node = new BinaryNode(parent);
			parent_node = tree.getNode(parent_node);
			
			if(parent_node == null) {
				System.out.println("No such node exists");
				continue;
			}
			
			System.out.print("Left Child : ");
			String l_child = br.readLine();
			
			if(valid.isNumber(l_child)) {
				BinaryNode l_node = new BinaryNode(Integer.parseInt(l_child));
				parent_node.setLeft(l_node);
				tree.addNode(l_node);
			}
			
			System.out.print("Right Child : ");
			String r_child = br.readLine();
			
			if(valid.isNumber(r_child)) {
				BinaryNode r_node = new BinaryNode(Integer.parseInt(r_child));
				parent_node.setRight(r_node);
				tree.addNode(r_node);
			}
		}
		
		return tree;
	}

	public void printTree(BinaryTree tree) {
		
		for(BinaryNode node: tree.getNodeList()) {
			System.out.print(node.getValue() + " : ");
			
			if(node.getLeft() != null) 
				System.out.print(node.getLeft().getValue() + " ");
			
			else
				System.out.print("N ");
			
			if(node.getRight() != null) 
				System.out.print(node.getRight().getValue() + " ");
			
			else
				System.out.print("N ");
			
			System.out.println();
		}
		
		return;
	}

	public List<BinaryNode> getPrefix(BinaryTree tree) {
		
		prefix = new ArrayList<BinaryNode>();
		prefixTraversal(tree, tree.getRoot());
		return prefix;
	}
	
	private void prefixTraversal(BinaryTree tree, BinaryNode curr) {
		
		if(curr != null) {
			prefix.add(curr);
			prefixTraversal(tree, curr.getLeft());
			prefixTraversal(tree, curr.getRight());
		}
	}
	
	public List<BinaryNode> getInfix(BinaryTree tree) {
		
		infix = new ArrayList<BinaryNode>();
		infixTraversal(tree, tree.getRoot());
		return infix;
	}
	
	private void infixTraversal(BinaryTree tree, BinaryNode curr) {
		
		if(curr != null) {
			infixTraversal(tree, curr.getLeft());
			infix.add(curr);
			infixTraversal(tree, curr.getRight());
		}
	}
	
	public List<BinaryNode> getPostfix(BinaryTree tree) {
		
		postfix = new ArrayList<BinaryNode>();
		postfixTraversal(tree, tree.getRoot());
		return postfix;
	}
	
	private void postfixTraversal(BinaryTree tree, BinaryNode curr) {
		
		if(curr != null) {
			postfixTraversal(tree, curr.getLeft());
			postfixTraversal(tree, curr.getRight());
			postfix.add(curr);
		}
	}
}
