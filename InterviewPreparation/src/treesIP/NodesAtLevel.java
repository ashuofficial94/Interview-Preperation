package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodesAtLevel {

	private Map<BinaryNode, Integer> heights;
	
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

		NodesAtLevel node_lev = new NodesAtLevel();
		node_lev.nodesAtLevel(tree);
		
	}
	  
	*/
	public void nodesAtLevel(BinaryTree tree) {
		
		heights = new HashMap<BinaryNode, Integer>();
		nodesAtHeights(tree.getRoot(), 0);
		
		Map<Integer, List<BinaryNode>> levels = new HashMap<Integer, List<BinaryNode>>();
		
		for(BinaryNode node: heights.keySet()) {
			
			if(levels.containsKey(heights.get(node))) {
				levels.get(heights.get(node)).add(node);
			}
			
			else {
				List<BinaryNode> node_list = new ArrayList<BinaryNode>();
				node_list.add(node);
				levels.put(heights.get(node), node_list);
			}
		}
		
		for(int level : levels.keySet()) {
			System.out.print("Level " + level + " : ");
			
			for(BinaryNode node: levels.get(level)) {
				System.out.print(node.getValue() + " ");
			}
			
			System.out.println();
		}
		
		return;
	}
	
	private void nodesAtHeights(BinaryNode node, int level) {
		
		if(node == null)
			return;
		
		heights.put(node, level++);
		
		nodesAtHeights(node.getLeft(), level);
		nodesAtHeights(node.getRight(), level);
	}
}
