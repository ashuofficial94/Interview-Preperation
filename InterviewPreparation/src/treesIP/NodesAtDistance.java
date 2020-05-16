package treesIP;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistance {

	/*
	public static void main(String arge[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Root : ");
		int root_val = Integer.parseInt(br.readLine());
		BinaryTree tree = new BinaryTree(new BinaryNode(root_val));
		
		InitializeTree init = new InitializeTree();
		tree = init.initializeTree(tree);
		
		System.out.println("Tree - \n");
		init.printTree(tree);

		NodesAtDistance nd = new NodesAtDistance();
		
		while(true) {
			
			System.out.print("\nEnter the Node: ");
			BinaryNode target = new BinaryNode(Integer.parseInt(br.readLine()));
			System.out.print("Enter the Distance : ");
			int distance = Integer.parseInt(br.readLine());
			
			List<BinaryNode> nodes = nd.nodesAtDistance(tree, target, distance);
			
			for(BinaryNode node : nodes) {
				System.out.print(node.getValue() + " ");
			}
			System.out.println();
		}
	}
	 */
	public List<BinaryNode> nodesAtDistance(BinaryTree tree, BinaryNode target, int distance) {
		
		List<BinaryNode> nodes = new ArrayList<BinaryNode>();
		target = tree.getNode(target);
		
		if(target == null) return null;
		
		distanceNodes(tree.getRoot(), target, distance, nodes);
		return nodes;
	}
	
	private void downNodes(BinaryNode node, int distance, List<BinaryNode> nodes) {
		
		if(distance < 0 || node == null)
			return;
		
		if(distance == 0) {
			nodes.add(node);
			return;
		}

		downNodes(node.getLeft(), distance-1, nodes);
		downNodes(node.getRight(), distance-1, nodes);
		
	}
	
	private int distanceNodes(BinaryNode node, BinaryNode target, int distance, List<BinaryNode> nodes) {
		
		if(node == null)
			return -1;
		
		if(node.equals(target)) {
			downNodes(node, distance, nodes);
			return 0;
		}
			
		int dl = distanceNodes(node.getLeft(), target, distance, nodes);
		
		if(dl != -1) {
			
			if(dl+1 == distance) nodes.add(node);
			else downNodes(node.getRight(), distance-dl-2, nodes);	
			return 1+dl;
		}
		
		int dr = distanceNodes(node.getRight(), target, distance, nodes); 
		
		if(dr != -1) {
			
			if(dr+1 == distance) nodes.add(node);
			else downNodes(node.getLeft(), distance-dr-2, nodes);
			
			return 1+dr;
		}
		
		return -1;
	}
}
