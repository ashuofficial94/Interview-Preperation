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

		while(true) {
			System.out.print("\nEnter the first number : ");
			int val = Integer.parseInt(br.readLine());
			Node node1 = new Node(val);
			
			System.out.print("Enter the second number : ");
			val = Integer.parseInt(br.readLine());
			Node node2 = new Node(val);
			
			LastComAncestor lca = new LastComAncestor();
			Node com = lca.lastCommAncestor(tree, node1, node2);
			
			System.out.println("Least Common Node : " + com.getValue());
		}
	}
}
