package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Not completely correct checkStack() needs improvement
//Need to get the max_stack2 right

public class DiameterBinary {

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

		DiameterBinary db = new DiameterBinary();
		System.out.print("Diameter : ");
		
		for(BinaryNode diameter : db.diameterListBinary(tree)) {
			System.out.print(diameter.getValue() + " ");
		}
		
		System.out.println();
		System.out.print("Length : " + (db.diameterBinary(tree)-1));
		
	}
	 */
	//State of the stack in depth first traversal 
	//is the path from root to top of the stack in the tree
	
	private List<BinaryNode> max_stack1 = new ArrayList<BinaryNode>();
	private List<BinaryNode> max_stack2 = new ArrayList<BinaryNode>();
	private int max_diameter = 0;
	private BinaryNode diameter_root;
	
	public List<BinaryNode> diameterListBinary(BinaryTree tree) {
		
		depthFirstTraversal(tree);
		List<BinaryNode> diameter = getDiameter(max_stack1, max_stack2);
		return diameter;
	}
	
	private List<BinaryNode> getDiameter(List<BinaryNode> max_stack1, List<BinaryNode> max_stack2) {
		
		List<BinaryNode> diameter = new ArrayList<BinaryNode>();
		List<BinaryNode> max = new ArrayList<BinaryNode>();
		max.addAll(max_stack1);
		
		System.out.println("Max 1 -");
		printList(max_stack1);
		
		System.out.println("Max 2 -");
		printList(max_stack2);
		
		while(true) {
			
			if(max_stack1.size() > 1 && max_stack2.size() > 1) {
				
				if(max_stack1.get(1).equals(max_stack2.get(1))) {
					max_stack1.remove(0);
					max_stack2.remove(0);
					continue;
				}	
				else {
					for(int i=max_stack1.size()-1; i>0; i--)
						diameter.add(max_stack1.get(i));
					
					diameter.addAll(max_stack2);
					break;
				}
					
			}	
			else {
				diameter = max;
				break;
			}
		}
		return diameter;
	}
	
	private void printList(List<BinaryNode> list) {
	
		System.out.print("List : ");
		for(BinaryNode node: list)
			System.out.print(node.getValue() + " ");
		System.out.println();
	}
	
	private void depthFirstTraversal(BinaryTree tree) {
		
		Map<BinaryNode, Boolean> visited = new HashMap<BinaryNode, Boolean>();
		
		for(BinaryNode node: tree.getNodeList()) {
			visited.put(node, false);
		}
		
		Stack stack = new Stack();
		stack.push(tree.getRoot());
		visited.replace(tree.getRoot(), true);
		boolean check = true;
		System.out.println("Stack - ");
		
		while(stack.getStack().size() != 0) {

			BinaryNode node = stack.getTop();
			printList(stack.getStack());
			
			if(node.getLeft() != null && !visited.get(node.getLeft())) {
				
				stack.push(node.getLeft());
				visited.replace(node.getLeft(), true);
				check = true;
				continue;
			}
			
			if(node.getRight() != null && !visited.get(node.getRight())) {
				
				stack.push(node.getRight());
				visited.replace(node.getRight(), true);
				check = true;
				continue;
			}
	
			boolean left_traversed = (node.getLeft() != null && visited.get(node.getLeft())) || node.getLeft() == null;
			boolean right_traversed = (node.getRight() != null && visited.get(node.getRight())) || node.getRight() == null;
			
			if(left_traversed && right_traversed) {
				
				if(check)
					checkStack(stack.getStack());
				stack.pop();
				check = false;
			}
			
		}
	}
	
	private void checkStack(List<BinaryNode> temp_stack) {
		
		int max1 = max_stack1.size();
		int max2 = max_stack2.size();
		
		if(temp_stack.size() > max1) {
			
			max_stack2 = new ArrayList<BinaryNode>();
			max_stack2.addAll(max_stack1);
			
			max_stack1 = new ArrayList<BinaryNode>();
			max_stack1.addAll(temp_stack);
		}
		
		else if(temp_stack.size() < max1 && temp_stack.size() >= max2) {

			max_stack2 = new ArrayList<BinaryNode>();
			max_stack2.addAll(temp_stack);
			
		}
	}

	//RBR solution
	
	public int diameterBinary(BinaryTree tree) {

		preorder(tree.getRoot());
		System.out.println("D_Root : " + diameter_root.getValue());
		return max_diameter;
	}
	
	private void preorder(BinaryNode node) {

		if(node != null) {
			
			int diameter = height(node.getLeft()) + height(node.getRight()) + 1;
			if(max_diameter < diameter) {
				max_diameter = diameter;
				diameter_root = node;
			}	
			
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	private int height(BinaryNode node) {
		
		if(node == null)
			return -1;
		
		if(node.getLeft() == null) {	
			if(node.getRight() != null)
				return 1 + height(node.getRight());
			else 
				return 0;
		}
		
		else {
			if(node.getRight() != null) 
				return 1 + Integer.max(height(node.getLeft()), height(node.getRight()));
			else 
				return 1 + height(node.getLeft());
		}
	}
}
