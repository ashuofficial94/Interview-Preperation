package treesIP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelSpiral {

	public List<BinaryNode> levelSpiral(BinaryTree tree) {
		
		List<BinaryNode> list = new ArrayList<BinaryNode>();
		
		/*
		Map<Integer, List<BinaryNode>> map = new HashMap<Integer, List<BinaryNode>>();
		
		map.put(1, new ArrayList<BinaryNode>());
		map.get(1).add(tree.getRoot());
		int level=1;
		
		while(true) {
			
			level++;
			map.put(level, new ArrayList<BinaryNode>());
			
			for(int i=map.get(level-1).size()-1; i>=0; i--) {
				
				boolean has_left = map.get(level-1).get(i).getLeft() != null;
				boolean has_right = map.get(level-1).get(i).getRight() != null;
				
				if(level%2 == 1) {
					if(has_right) map.get(level).add(map.get(level-1).get(i).getRight());
					if(has_left) map.get(level).add(map.get(level-1).get(i).getLeft());
				}
				
				else {
					if(has_left) map.get(level).add(map.get(level-1).get(i).getLeft());
					if(has_right) map.get(level).add(map.get(level-1).get(i).getRight());
				}
			}
			
			if(map.get(level).size() == 0) break;
		}

		for(int key : map.keySet()) list.addAll(map.get(key));
		*/
		
		//RBR Solution
		//Even_Stack contains node at even level, root at 0
		//Odd_Stack contains node at odd level
		
		Stack odd_stack = new Stack();
		Stack even_stack = new Stack();
		even_stack.push(tree.getRoot());
		
		while(odd_stack.getStack().size() != 0 || even_stack.getStack().size() != 0) {
			
			while(even_stack.getStack().size() != 0) {
				
				BinaryNode node = even_stack.pop();
				list.add(node);
				BinaryNode left = node.getLeft();
				BinaryNode right = node.getRight();
				
				if(right != null) odd_stack.push(right);
				if(left != null) odd_stack.push(left);
			}
			
			while(odd_stack.getStack().size() != 0) {

				BinaryNode node = odd_stack.pop();
				list.add(node);
				BinaryNode left = node.getLeft();
				BinaryNode right = node.getRight();

				if(left != null) even_stack.push(left);
				if(right != null) even_stack.push(right);
			}
		}
		
		return list;
	}
}
