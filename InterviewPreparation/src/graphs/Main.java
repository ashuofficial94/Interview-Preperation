package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Graph graph = new Graph();
		System.out.println("\nEnter only a single value to add a vertex");
		System.out.println("Or Pair values to add edge Or -1 to save.\n");

		
		while(true) {
			
			String[] input = br.readLine().trim().split(" ");
			int x = Integer.parseInt(input[0]);
			
			if(x == -1) {
				System.out.println("Graph Initialized.");
				break;
			}
			
			Node x_node = graph.getNode(x);
			
			if(x_node == null) {
				
				x_node = new Node(x);
				graph.addVertex(x_node);
				System.out.println(x_node.getValue() + " is added as a vertex");
			}
			
			else {
				
				if(input.length == 1) {
					System.out.println(x_node.getValue() + " is already a vertex.\n");
					continue;
				}
			}
			
			
			int y = Integer.parseInt(input[1]);
			
			Node y_node = graph.getNode(y);
			
			if(y_node == null) {
				
				y_node = new Node(y);
				graph.addVertex(y_node);
				System.out.println(y_node.getValue() + " is added as a vertex");
			}
			
			if(x_node.addAdjacent(y_node) && y_node.addAdjacent(x_node))
				System.out.println(x + " <-> " + y + " Edge Added.\n");
			
		}
		
	}
}
