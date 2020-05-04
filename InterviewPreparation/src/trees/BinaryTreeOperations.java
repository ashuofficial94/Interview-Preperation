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
	private BinaryTree tree;
	
	BinaryTreeOperations(BinaryTree tree) {
		this.tree = tree;
	}
	
	public BinaryTree initializeTree() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter -1 as a Parent to save.");
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

	public void printTree() {
		
		for(BinaryNode node: tree.getNodeList()) {
			System.out.print(node.getValue() + " : ");
			
			if(node.getLeft() != null) 
				System.out.print(node.getLeft().getValue() + " ");
			
			else
				System.out.print("x ");
			
			if(node.getRight() != null) 
				System.out.print(node.getRight().getValue() + " ");
			
			else
				System.out.print("x ");
			
			System.out.println();
		}
		
		return;
	}

	public List<BinaryNode> getPrefix() {
		
		prefix = new ArrayList<BinaryNode>();
		prefixTraversal(tree.getRoot());
		return prefix;
	}
	
	private void prefixTraversal(BinaryNode curr) {
		
		if(curr != null) {
			prefix.add(curr);
			prefixTraversal(curr.getLeft());
			prefixTraversal(curr.getRight());
		}
	}
	
	public List<BinaryNode> getInfix() {
		
		infix = new ArrayList<BinaryNode>();
		infixTraversal(tree.getRoot());
		return infix;
	}
	
	private void infixTraversal(BinaryNode curr) {
		
		if(curr != null) {
			infixTraversal(curr.getLeft());
			infix.add(curr);
			infixTraversal(curr.getRight());
		}
	}
	
	public List<BinaryNode> getPostfix() {
		
		postfix = new ArrayList<BinaryNode>();
		postfixTraversal(tree.getRoot());
		return postfix;
	}
	
	private void postfixTraversal(BinaryNode curr) {
		
		if(curr != null) {
			postfixTraversal(curr.getLeft());
			postfixTraversal(curr.getRight());
			postfix.add(curr);
		}
	}
}
