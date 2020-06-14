package treesIP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//incomplete

public class AncestorMatrix {

	private Map<Integer, List<BinaryNode>> count_map = new HashMap<Integer, List<BinaryNode>>();
	
	public BinaryTree ancestorMatrix(List<List<Integer>> ancestor_matrix) {
		
		for(int i=0; i<ancestor_matrix.size(); i++) {
			
			BinaryNode node = new BinaryNode(i+1);
			int count = 0;
			for(int x : ancestor_matrix.get(i)) {
				if(x==1) count++;
			}
			if(!count_map.containsKey(count)) 
				count_map.put(count, new ArrayList<BinaryNode>());
			
			count_map.get(count).add(node);
		}
		
		List<Integer> keys = new ArrayList<Integer>(count_map.keySet());
		Collections.sort(keys);
		BinaryNode root = count_map.get(keys.get(keys.size()-1)).get(0);
		BinaryTree tree = new BinaryTree(root);
		
		while(keys.size() > 0) {
			
			BinaryNode node = count_map.get(keys.get(0)).get(0);
			List<Integer> ancestor_data = ancestor_matrix.get(node.getValue()-1);
			
			for(int i=0; i<ancestor_data.size(); i++)
				if(ancestor_data.get(i) == 1) {
					
				}
				
		}
	
		return tree;
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
		init.printTree(tree);
	}
	*/
}
