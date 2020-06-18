package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

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
}
