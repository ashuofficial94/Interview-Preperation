package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		GraphOperations opr = new GraphOperations();
		Graph graph = opr.initializeGraph();

		System.out.println("1. Initialize a Graph");
		System.out.println("2. Print the Graph");
		System.out.println("3. Breadth First Traversal");
		System.out.println("4. Depth First Traversal");
		boolean exit = false;
		
		while(!exit) {
			
			System.out.print("\nEnter a choice: ");
			int choice = Integer.parseInt(br.readLine());

			switch(choice) {
			
			case 1:
				
				graph = opr.initializeGraph();
				break;
				
			case 2:
				
				opr.printGraph(graph);
				break;
				
			case 3:
				
				System.out.print("\nEnter the source for BFS : ");
				int source = Integer.parseInt(br.readLine());
				
				List<Node> bfs_traversal = opr.breadthFirst(graph, source);
				System.out.print("\nBreadth First Traversal - ");
				
				for(Node node: bfs_traversal) {
					System.out.print(node.getValue() + " ");
				}
				break;
				
			case 4:
				
				System.out.print("\nEnter the source for DFS : ");
				source = Integer.parseInt(br.readLine());
				
				List<Node> dfs_traversal = opr.depthFirst(graph, source);
				System.out.print("\nDepth First Traversal - ");
				
				for(Node node: dfs_traversal) {
					System.out.print(node.getValue() + " ");
				}
				break;
				
			default:
				exit = true;
				System.out.println("Thanks for using Graphs. Bye.");
				break;
			}
			
			System.out.println();
		}
	}
	
	
}
