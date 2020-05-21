package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
				System.out.println("Left Child : " + parent_node.getLeft().getValue());
				System.out.println("Right Child : " + parent_node.getRight().getValue());
				continue;
			}
			
			if(parent_node.getLeft() == null) {
			
				System.out.print("Left Child : ");
				String l_child = br.readLine();
				
				if(valid.isNumber(l_child)) {
					BinaryNode l_node = new BinaryNode(Integer.parseInt(l_child));
					
					if(tree.getNode(l_node) == null) {
						parent_node.setLeft(l_node);
					}	
					else {
						System.out.println(l_child + " already exists");
						continue;
					}
				}
			}
			
			else {
				System.out.println("Left Child : " + parent_node.getLeft().getValue());
			}
			
			if(parent_node.getRight() == null) {
				
				System.out.print("Right Child : ");
				String r_child = br.readLine();
				
				if(valid.isNumber(r_child)) {
					BinaryNode r_node = new BinaryNode(Integer.parseInt(r_child));
					
					if(tree.getNode(r_node) == null) {
						parent_node.setRight(r_node);
					}				
					else {
						System.out.println(r_child + " already exists");
						continue;
					}
				}
				
			}
			
			else {
				System.out.println("Right Child : " + parent_node.getRight().getValue());
			}
		}
		
		return tree;
	}
	
	public void printTree(BinaryTree tree) {
		
		List<BinaryNode> list = new ArrayList<BinaryNode>();
		list.add(tree.getRoot());
		
		while(list.size() > 0) {
			
			if(list.get(0).getLeft() == null && list.get(0).getRight() == null) {
				list.remove(0);
				continue;
			}
			
			System.out.print(list.get(0).getValue() + " : ");
			
			if(list.get(0).getLeft() != null) {
				list.add(list.get(0).getLeft());
				System.out.print(list.get(0).getLeft().getValue() + " ");
			}
			
			else
				System.out.print("x ");
				
			if(list.get(0).getRight() !=  null) {
				list.add(list.get(0).getRight());
				System.out.println(list.get(0).getRight().getValue());
			}
				
			else
				System.out.println("x");
			
			list.remove(0);
		}
		System.out.println();
		return;
	}
}
