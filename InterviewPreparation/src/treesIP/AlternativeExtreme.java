package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Extreme Nodes at Each level in alternative order

public class AlternativeExtreme {

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
		
		System.out.print("Alternative extremes : ");
		
		AlternativeExtreme ae = new AlternativeExtreme();
		for(BinaryNode node: ae.alternativeExtreme(tree)) System.out.print(node.getValue()+" ");
	}
	*/
	
	public List<BinaryNode> alternativeExtreme(BinaryTree tree) {
		
		Map<Integer, List<BinaryNode>> levels = new HashMap<Integer, List<BinaryNode>>();
		List<BinaryNode> base = new ArrayList<BinaryNode>();
		base.add(tree.getRoot());
		int level = 1;
		
		levels.put(level, base);

		while(true) {
			List<BinaryNode> nodes = new ArrayList<BinaryNode>();
			level++;
			
			for(BinaryNode node: levels.get(level-1)) {
				if(node.getLeft() != null) nodes.add(node.getLeft());
				if(node.getRight() != null) nodes.add(node.getRight());
			}
			
			if(nodes.size() == 0) break;
			levels.put(level, nodes);
		}
		
		List<BinaryNode> result = new ArrayList<BinaryNode>();
		
		for(int i=1; i<level; i++) {
			if(i%2 == 1) result.add(levels.get(i).get(0));
			else result.add(levels.get(i).get(levels.get(i).size() - 1));
		}
		
		return result;
	}
}
