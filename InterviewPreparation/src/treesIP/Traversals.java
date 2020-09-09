package treesIP;

public class Traversals {

	public String traversals(BinaryTree tree) {
		
		Stack stack = new Stack();
		String preorder = "";
		stack.push(tree.getRoot());
		
		while(!stack.isEmpty()) {
			
			BinaryNode node = stack.getTop();
			preorder += node.getValue()+"";
			
			if(node.getLeft() != null) {
				stack.push(node.getLeft());
				continue;
			}
			
			else stack.pop();
			
			node = stack.getTop();
			preorder += node.getValue()+"";
			
			if(node.getRight() != null) {
				stack.push(node.getRight());
				continue;
			}
			
			else stack.pop();
		}
		
		return preorder;
	}
}
