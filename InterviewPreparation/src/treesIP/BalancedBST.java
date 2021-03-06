package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Construct a balanced BST with sorted input

public class BalancedBST {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		List<Integer> values = new ArrayList<Integer>();
		for(String elem: input) values.add(Integer.parseInt(elem));
		
		BinaryNode root = constructBST(values, 0, values.size()-1);
		BinaryTree tree = new BinaryTree(root);
		
		InitializeTree init = new InitializeTree();
		init.printTree(tree);
		
	}
	
	public static BinaryNode constructBST(List<Integer> values, int start, int end) {
		
		if(start <= end) {
			int mid = (start+end)/2;
			BinaryNode node = new BinaryNode(values.get(mid));
			node.setLeft(constructBST(values, start, mid-1));
			node.setRight(constructBST(values, mid+1, end));
			return node;
		}
		
		return null;
	}
}
