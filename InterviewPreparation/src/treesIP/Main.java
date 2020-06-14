package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

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
}
