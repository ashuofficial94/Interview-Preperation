package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Graph graph = new Graph();
		GraphOperations opr = new GraphOperations(graph);
		
		graph = opr.initializeGraph();

		boolean exit = false;
		
		while(!exit) {
			
			System.out.println("\n1. Add to the Existing Graph");
			System.out.println("2. Print the Graph");
			System.out.println("3. Add a New Graph");
			System.out.println("4. Breadth First Traversal");
			System.out.println("5. Depth First Traversal");
			System.out.println("6. Connected Components\n");
			
			System.out.print("Enter a choice: ");
			int choice = Integer.parseInt(br.readLine());

			switch(choice) {
			
			case 1:
				
				graph = opr.initializeGraph();
				break;
				
			case 2:
				
				opr.printGraph();
				break;
				
			case 3:

				graph = new Graph();
				opr = new GraphOperations(graph);
				opr.initializeGraph();
				break;
				
			case 4:

				System.out.print("\nEnter the source for BFS : ");
				int source = Integer.parseInt(br.readLine());
				
				List<Node> bfs_traversal = opr.breadthFirst(source);
				System.out.print("\nBreadth First Traversal - ");
				
				for(Node node: bfs_traversal) {
					System.out.print(node.getValue() + " ");
				}
				break;
				
			case 5:
				
				System.out.print("\nEnter the source for DFS : ");
				source = Integer.parseInt(br.readLine());
				
				List<Node> dfs_traversal = opr.depthFirst(source);
				System.out.print("\nDepth First Traversal - ");
				
				for(Node node: dfs_traversal) {
					System.out.print(node.getValue() + " ");
				}
				break;
				
			case 6:
				
				List<List<Node>> components = opr.connComponents();
				System.out.println();
				
				for(List<Node> connected : components) {
					
					System.out.print("( ");
					for(Node node: connected) {
						System.out.print(node.getValue() + " ");
					}
					System.out.print(") ");
				}
				
				break;
				
			default:
				exit = true;
				System.out.println("\nThanks for using Graphs. Bye.");
				break;
			}
			
			System.out.println();
		}
	}
	
	
}
