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
		
		while(true) {
			
			System.out.print("Enter the Level : ");
			BinaryNode target = new BinaryNode(Integer.parseInt(br.readLine()));
			System.out.println("Level : " + node_lev.levelNode(tree, target));		
		}
	}
	 */
	public int levelNode(BinaryTree tree, BinaryNode target) {
		
		int[] level = {-1};
		
		preorder(tree.getRoot(), level, target, 1);
		
//		level = getLevel(tree.getRoot(), target, 1);
		return level[0];
	}
	
	private void preorder(BinaryNode node, int[] level, BinaryNode target, int height) {

		if(node != null) {
			
			if(node.getValue() == target.getValue()) {
				level[0] = height;
				return;
			}
			
			preorder(node.getLeft(), level, target, height+1);
			preorder(node.getRight(), level , target, height+1);
		}
	}
	
	//RBR Solution
	
	@SuppressWarnings("unused")
	private int getLevel(BinaryNode node, BinaryNode target, int level) {
		
		if(node == null)
			return -1;
		
		if(node.getValue() == target.getValue())
			return level;
		
		int level2 = getLevel(node.getLeft(), target, level+1);
		
		if(level2 != -1)
			return level2;
		
		return getLevel(node.getRight(), target, level+1);
	}

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
		
		while(true) {
			
			System.out.print("\nEnter the Level : ");
			
			int level = Integer.parseInt(br.readLine());
			List<BinaryNode> nodes  = node_lev.getNodes(tree, level);	
			
			System.out.print("Nodes at level " + level + " -> ");
			for(BinaryNode node : nodes) {
				System.out.print(node.getValue() + " ");
			}
			
			System.out.println();
		}
	}
	 */
	public List<BinaryNode> getNodes(BinaryTree tree, int level) {
		
		List<BinaryNode> nodes = new ArrayList<BinaryNode>();
		getNodes(tree.getRoot(), 1, nodes, level);
		return nodes;
	}
	
	private void getNodes(BinaryNode node, int level, List<BinaryNode> nodes, int t_level) {
		
		if(node != null) {
			
			if(t_level == level) {
				nodes.add(node);
				return;
			}

			getNodes(node.getLeft(), level+1, nodes, t_level);
			getNodes(node.getRight(), level+1, nodes, t_level);
		}
	}
}
