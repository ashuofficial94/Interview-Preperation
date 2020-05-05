package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphOperations {
	
	private Map<Node, Boolean> visited;
	private Graph graph;
	
	GraphOperations(Graph graph) {
		this.graph = graph;
	}
	
	public Graph initializeGraph() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

			if(x_node != null) 
				System.out.println(x_node.getValue() + " is already a vertex");
			
			else {
				
				x_node = new Node(x);
				graph.addVertex(x_node);
				System.out.println(x_node.getValue() + " is added as a vertex");
			}
			
			if(input.length == 1) {
				System.out.println();
				continue;
			}
			
			int y = Integer.parseInt(input[1]);
			
			Node y_node = graph.getNode(y);
			
			if(y_node == null) {
				
				y_node = new Node(y);
				graph.addVertex(y_node);
				System.out.println(y_node.getValue() + " is added as a vertex");
			}
			
			else
				System.out.println(y_node.getValue() + " is already a vertex");
			
			if(x_node.addAdjacent(y_node) && y_node.addAdjacent(x_node))
				System.out.println(x + " <-> " + y + " Edge Added.\n");
			
		}
		
		return graph;
	}

	public void printGraph() {
		
		System.out.println("\nGraph - [Vertex : Adjacents]");
		
		for(Node vertex : graph.getVertices()) {
			
			System.out.println();
			System.out.print(vertex.getValue() + " : ");
			
			for(Node adjacents: vertex.getAdjacents()) {
				System.out.print(adjacents.getValue() + " ");
			}
		}
		return;
	}
	
	public List<Node> breadthFirst(int source) {
		
		Node s_node = graph.getNode(source);
		
		if(s_node == null) {
			System.out.println("No such vertex exists");
			return null;
		}
			
		List<Node> bfs = new ArrayList<Node>();
		Queue queue = new Queue(s_node);
		bfs.add(s_node);
		visited.replace(s_node, true);
		
		while(queue.getQueue().size() != 0) {
			
			Node node = queue.dequeue();
			
			for(Node adj: node.getAdjacents()) {
				if(!bfs.contains(adj)) {
					queue.enqueue(adj);
					bfs.add(adj);
					visited.replace(adj, true);
				}
			}
		}
		
		return bfs;
	}
	
	public List<Node> depthFirst(int source) {
		
		Node s_node = graph.getNode(source);
		
		if(s_node == null) {
			System.out.println("No such vertex exists");
			return null;
		}
			
		List<Node> dfs = new ArrayList<Node>();
		Stack stack = new Stack(s_node);
		
		initializeVisited();
		visited.replace(s_node, true);
		
		while(stack.getStack().size() != 0) {
			
			boolean remaining = false;
			
			Node node = stack.getTop();
			dfs.add(node);
			
			for(Node adj: node.getAdjacents()) {
				
				if(!visited.get(adj)) {
					
					visited.replace(adj, true);
					stack.push(adj);
					remaining = true;
					break;
				}
			}
			
			if(!remaining)
				stack.pop();
		}
		
		return dfs;
	}

	public List<List<Node>> connComponents() {
		
		List<List<Node>> components = new ArrayList<List<Node>>();
		
		initializeVisited();
		Node unvisited = notVisited();
		
		while(unvisited != null) {	
			List<Node> connected = breadthFirst(unvisited.getValue());
			components.add(connected);
			unvisited = notVisited();
		}
		
		System.out.println("\nNo. of connected Components in the Graph : " + components.size());
		return components;
	}
	
	public Node notVisited() {
		
		for(Node node: visited.keySet()) {
			if(!visited.get(node))
				return node;
		}
		
		return null;
	}
	
	private void initializeVisited() {
		
		visited = new HashMap<Node, Boolean>();
		for(Node node: graph.getVertices()) {
			visited.put(node, false);
		}
		return;
	}
}

