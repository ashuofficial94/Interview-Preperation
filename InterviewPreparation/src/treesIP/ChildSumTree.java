package treesIP;

public class ChildSumTree {

	public BinaryTree childSumTree(BinaryTree tree) {
		
		buildTreeByIncrement(tree.getRoot());
		return tree;
	}
	
	
	//Only Increments
	private int buildTreeByIncrement(BinaryNode node) {
		
		if(node != null) {
			
			int left_sum = buildTreeByIncrement(node.getLeft());
			int right_sum = buildTreeByIncrement(node.getRight());
			
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
					buildTreeByIncrement(node.getLeft());	
				}
			}
			
			return node.getValue();
				
		}
		
		return 0;
	}
}
