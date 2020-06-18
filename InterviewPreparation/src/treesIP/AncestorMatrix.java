package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Construct a Binary Tree using Ancestor Matrix

/*
Input - 

0 1 1 1 1 1
0 0 0 0 0 1
0 0 0 1 1 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

*/

public class AncestorMatrix {
	
	public BinaryTree ancestorMatrix(List<List<Integer>> ancestor_matrix) {
	
		List<BinaryNode> node_list = new ArrayList<BinaryNode>();
		Map<Integer, List<BinaryNode>> count_map = new HashMap<Integer, List<BinaryNode>>();
		Map<BinaryNode, Boolean> parented = new HashMap<BinaryNode, Boolean>();
		
		for(int i=0; i<ancestor_matrix.size(); i++) {
			
			BinaryNode node = new BinaryNode(i+1);
			int count = 0;
			for(int x : ancestor_matrix.get(i)) {
				if(x==1) count++;
			}
			if(!count_map.containsKey(count)) 
				count_map.put(count, new ArrayList<BinaryNode>());
			
			count_map.get(count).add(node);
			parented.put(node, false);
		}
		
		List<Integer> keys = new ArrayList<Integer>(count_map.keySet());
		Collections.sort(keys);
		int max_key = keys.get(keys.size()-1);
		
		BinaryNode root = count_map.get(max_key).get(0);
		BinaryTree tree = new BinaryTree(root);
		
		node_list.addAll(count_map.get(0));
		keys.remove(0);
		
		for(int key : keys) {
			for(BinaryNode parent : count_map.get(key)) {
				
				List<Integer> ancestor_data = ancestor_matrix.get(parent.getValue()-1);
				node_list.add(parent);
				for(int i=0; i<ancestor_data.size(); i++) {
					
					if(ancestor_data.get(i) == 1) {
						BinaryNode child = getNode(i+1, node_list);
						
						if(!parented.get(child)) {
							
							if(parent.getLeft() == null) parent.setLeft(child);
							else parent.setRight(child);
							
							parented.replace(child, true);
						}
					}
				}
			}
		}
		
		return tree;
	}
	
	private BinaryNode getNode(int value, List<BinaryNode> node_list) {
		
		for(BinaryNode node : node_list) {
			if(node.getValue() == value) return node;
		}
		
		return null;
	}
	
	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the matrix - \n");
		
		String[] input = br.readLine().split(" ");
		int n = input.length;
		List<List<Integer>> ancestorMatrix = new ArrayList<List<Integer>>();
		List<Integer> first_input = new ArrayList<Integer>();
		
		for(String elem : input) first_input.add(Integer.parseInt(elem));
		ancestorMatrix.add(first_input);
		
		for(int i=1; i<n; i++) {
			input = br.readLine().split(" ");
			List<Integer> temp = new ArrayList<Integer>();
			for(String elem : input) temp.add(Integer.parseInt(elem));
			ancestorMatrix.add(temp);
		}
		
		AncestorMatrix am = new AncestorMatrix();
		BinaryTree tree = am.ancestorMatrix(ancestorMatrix);
		InitializeTree init = new InitializeTree();
		System.out.println("\nTree\n");
		init.printTree(tree);
	}
	*/
}
