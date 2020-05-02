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
		opr.printGraph(graph);
		
		System.out.print("Enter the source for BFS : ");
		int source = Integer.parseInt(br.readLine());
		
		List<Node> bfs_traversal = opr.breadthFirst(graph, source);
		System.out.print("\nBreadth First Traversal - ");
		
		for(Node node: bfs_traversal) {
			System.out.print(node.getValue() + " ");
		}
		
		System.out.print("\n\nEnter the source for DFS : ");
		source = Integer.parseInt(br.readLine());
		
		List<Node> dfs_traversal = opr.depthFirst(graph, source);
		System.out.print("\nDepth First Traversal - ");
		
		for(Node node: dfs_traversal) {
			System.out.print(node.getValue() + " ");
		}
	}
	
	
}
