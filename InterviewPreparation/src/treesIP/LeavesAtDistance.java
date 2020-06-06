package treesIP;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

//Print all the nodes that are at a distance 'k' from any leaf

public class LeavesAtDistance {

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
		
		System.out.print("Enter the distance from leaves: ");
		int distance = Integer.parseInt(br.readLine());
		
		LeavesAtDistance ld = new LeavesAtDistance();
		System.out.print("Nodes : ");
		for(BinaryNode node: ld.leavesAtDistance(tree, distance)) System.out.print(node.getValue()+" ");
	}
	*/
	
	public Set<BinaryNode> leavesAtDistance(BinaryTree tree, int distance) {
		
		Set<BinaryNode> result = new HashSet<BinaryNode>();
		Stack stack = new Stack();
		stack.push(tree.getRoot());
		
		Map<BinaryNode, Boolean> visited = new HashMap<BinaryNode, Boolean>();
		for(BinaryNode node: tree.getNodeList()) visited.put(node, false);
		
		visited.replace(tree.getRoot(), true);
		
		while(stack.getStack().size() > 0) {
			
			BinaryNode node = stack.getTop();
			boolean has_left = node.getLeft() != null;
			boolean has_right = node.getRight() != null;
			boolean leaf = !has_left && !has_right;
			
			if(has_left && !visited.get(node.getLeft())) {
				visited.replace(node.getLeft(), true);
				stack.push(node.getLeft());
				continue;
			}
			
			if(has_right && !visited.get(node.getRight())) {
				visited.replace(node.getRight(), true);
				stack.push(node.getRight());
				continue;
			}
			
			if(leaf && stack.getStack().size() > distance) 
				result.add(stack.getStack().get(stack.getStack().size() - 1 - distance));
			
			stack.pop();
		}
		
		return result;
	}
	
}
