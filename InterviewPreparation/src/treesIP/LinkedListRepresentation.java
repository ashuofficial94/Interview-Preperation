package treesIP;

import java.util.ArrayList;
import java.util.List;

//Construct a complete BinaryTree from Linked List Representation

public class LinkedListRepresentation {

	/*
	
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the nodes as List - \n");
		
		String[] input = br.readLine().split(" ");
		ListNode head = new ListNode(Integer.parseInt(input[0]));
		ListNode curr = head;
		
		for(int i=1; i<input.length; i++) {
			ListNode node = new ListNode(Integer.parseInt(input[i]));
			curr.setNext(node);
			curr = curr.getNext();
		}
		
		LinkedListRepresentation llr = new LinkedListRepresentation();
		
		BinaryTree tree = llr.buildTreeQ(head);
//		BinaryTree tree = llr.buildTree(head);
		
		InitializeTree init = new InitializeTree();
		System.out.println("\nTree\n");
		init.printTree(tree);
	}
	*/
	
	//RBR Solution
	public BinaryTree buildTreeQ(ListNode head) {
		
		BinaryNode root = new BinaryNode(head.getValue());
		BinaryTree tree = new BinaryTree(root);
		
		List<BinaryNode> queue = new ArrayList<BinaryNode>();
		queue.add(root);
		ListNode curr = head.getNext();
		
		while(queue.size() > 0 && curr != null) {
			
			BinaryNode parent = queue.remove(0);
			
			BinaryNode l_child = new BinaryNode(curr.getValue());
			parent.setLeft(l_child);
			curr = curr.getNext();
			queue.add(l_child);
			
			if(curr != null) {
				BinaryNode r_child = new BinaryNode(curr.getValue());
				parent.setRight(r_child);
				curr = curr.getNext();
				queue.add(r_child);
			}				
		}
		
		return tree;
	}
	
	//My Solution
	public BinaryTree buildTree(ListNode head) {
		
		BinaryNode root = new BinaryNode(head.getValue());
		BinaryTree tree = new BinaryTree(root);
		
		List<BinaryNode> parent_list = new ArrayList<BinaryNode>();
		List<BinaryNode> child_list = new ArrayList<BinaryNode>();
		parent_list.add(root);
		ListNode curr = head.getNext();
		int parent_index = 0;
		
		while(curr != null) {
			
			if(parent_index < parent_list.size()) {
				
				BinaryNode child = new BinaryNode(curr.getValue());
				
				if(parent_list.get(parent_index).getLeft() == null) {
					parent_list.get(parent_index).setLeft(child);
					child_list.add(child);
					curr = curr.getNext();
					continue;
				}
				
				if(parent_list.get(parent_index).getRight() == null) {
					parent_list.get(parent_index).setRight(child);
					child_list.add(child);
					curr = curr.getNext();
					parent_index++;
					continue;
				}
			}
			
			parent_index = 0;
			parent_list = child_list;
		}
		
		return tree;
	}
}
