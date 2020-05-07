package binarysearchtreeIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Elements - \n" );
		
		String[] input = br.readLine().trim().split(" ");
		List<Integer> elem = new ArrayList<Integer>();
		
		for(String in: input) {
			elem.add(Integer.parseInt(in));
		}
		
		InitializeTree init = new InitializeTree();
		Tree tree = init.initializeTree(elem);
		init.printTree(tree);
		
	}
}
