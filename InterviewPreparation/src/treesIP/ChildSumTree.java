package treesIP;

public class ChildSumTree {

	public BinaryTree childSumTree(BinaryTree tree) {
		
		buildTree(tree.getRoot());
		return tree;
	}
	
	private int buildTree(BinaryNode node) {
		
		if(node != null) {
			
			int left_sum = buildTree(node.getLeft());
			int right_sum = buildTree(node.getRight());
			
			if(node.getValue() <= left_sum + right_sum) 
				node.setValue(left_sum + right_sum);
			
			else {
				boolean has_left = node.getLeft() != null;
				boolean has_right = node.getRight() != null;
				
				if(!has_left && has_right) {
					node.getRight().setValue(node.getValue());
					return node.getValue();
				}
				
				else if(has_left && !has_right) {
					node.getLeft().setValue(node.getValue());
					return node.getValue();
				}
				
				else if(has_left && has_right){
					node.getLeft().setValue(node.getValue() - right_sum);
					buildTree(node.getLeft());	
				}
			}
			
			return node.getValue();
				
		}
		
		return 0;
	}
}
