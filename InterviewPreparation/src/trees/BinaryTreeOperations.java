package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTreeOperations {

	public BinaryTree initializeTree(BinaryTree tree) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter -1 as a Parent to save.");
		System.out.println("Parent can only be the nodes which already exist.");
		System.out.println("Enter any alphabet as a null child.");
		
		Validation valid = new Validation();
		int parent;
		
		while(true) {
			
			System.out.println("\nParent : ");
			
			try {
				parent = Integer.parseInt(br.readLine());
			}
			
			catch(NumberFormatException e) {
				System.out.println("No such node exists");
				continue;
			}
			
			if(parent == -1) {
				System.out.println("Tree Saved.\n");
				continue;
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
			}
			
			System.out.print("Right Child : ");
			String r_child = br.readLine();
			
			if(valid.isNumber(r_child)) {
				BinaryNode r_node = new BinaryNode(Integer.parseInt(r_child));
				parent_node.setRight(r_node);
			}
		}
	}
}
