package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOperations {
	
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

	public int height(BinaryNode curr) {
		
		if(curr == null)
			return -1;
		
		if(curr.getLeft() == null) {
			if(curr.getRight() == null)
				return 0;
			
			else
				return 1 + height(curr.getRight());
		}
		
		else {
			if(curr.getRight() == null)
				return 1 + height(curr.getLeft());
			
			else 
				return 1 + Integer.max(height(curr.getLeft()), height(curr.getRight()));
		}
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

	public List<BinaryNode> getPreorder() {
		
		List<BinaryNode> preorder = new ArrayList<BinaryNode>();
		preorderTraversal(tree.getRoot(), preorder);
		return preorder;
	}
	
	private void preorderTraversal(BinaryNode curr, List<BinaryNode> preorder) {
		
		if(curr != null) {
			preorder.add(curr);
			preorderTraversal(curr.getLeft(), preorder);
			preorderTraversal(curr.getRight(), preorder);
		}
	}
	
	public List<BinaryNode> getInorder() {
		
		List<BinaryNode> inorder = new ArrayList<BinaryNode>();
		inorderTraversal(tree.getRoot(), inorder);
		return inorder;
	}
	
	private void inorderTraversal(BinaryNode curr, List<BinaryNode> inorder) {
		
		if(curr != null) {
			inorderTraversal(curr.getLeft(), inorder);
			inorder.add(curr);
			inorderTraversal(curr.getRight(), inorder);
		}
	}
	
	public List<BinaryNode> getPostorder() {
		
		List <BinaryNode> postorder = new ArrayList<BinaryNode>();
		postorderTraversal(tree.getRoot(), postorder);
		return postorder;
	}
	
	private void postorderTraversal(BinaryNode curr, List<BinaryNode> postorder) {
		
		if(curr != null) {
			postorderTraversal(curr.getLeft(), postorder);
			postorderTraversal(curr.getRight(), postorder);
			postorder.add(curr);
		}
	}
}
