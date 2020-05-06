package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InitializeTree {

	public BinaryTree initializeTree(BinaryTree tree) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter -1 as a Parent to save.");
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
				System.out.println("Tree Saved.\n");
				break;
			}
			
			BinaryNode parent_node = new BinaryNode(parent);
			parent_node = tree.getNode(parent_node);
			
			if(parent_node == null) {
				System.out.println("No such node exists");
				continue;
			}
			
			if(parent_node.getLeft() != null && parent_node.getRight() != null) {
				System.out.println("Parent already have both childs");
				continue;
			}
			
			if(parent_node.getLeft() == null) {
			
				System.out.print("Left Child : ");
				String l_child = br.readLine();
				
				if(valid.isNumber(l_child)) {
					BinaryNode l_node = new BinaryNode(Integer.parseInt(l_child));
					
					if(tree.getNode(l_node) == null) {
						parent_node.setLeft(l_node);
						tree.addNode(l_node);
					}	
					else {
						System.out.println(l_child + " already exists");
						continue;
					}
				}
			}
			
			if(parent_node.getRight() == null) {
				
				System.out.print("Right Child : ");
				String r_child = br.readLine();
				
				if(valid.isNumber(r_child)) {
					BinaryNode r_node = new BinaryNode(Integer.parseInt(r_child));
					
					if(tree.getNode(r_node) == null) {
						parent_node.setRight(r_node);
						tree.addNode(r_node);
					}				
					else {
						System.out.println(r_child + " already exists");
						continue;
					}
				}
				
			}
		}
		
		return tree;
	}
	
	public void printTree(BinaryTree tree) {
		
		System.out.println();
		
		for(BinaryNode node: tree.getNodeList()) {
			
			if(node.getLeft() == null && node.getRight() == null)
				continue;
			
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
		
		System.out.println();
		return;
	}
}
