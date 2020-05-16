package treesIP;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class VerticalOrder {

	public List<BinaryNode> verticalOrder(BinaryTree tree) {
		
		Map<Integer, List<BinaryNode>> map = new HashMap<Integer, List<BinaryNode>>();
		List<BinaryNode> vertical = new ArrayList<BinaryNode>();
		
		horizontalDistance(tree.getRoot(), 0, map);
		int min=0, max=0;
		
		for(int key: map.keySet()) {
			if(key < min) min = key;
			if(key > max) max = key;
		}
		
		for(int key = min; key<=max; key++)
			vertical.addAll(map.get(key));
		
		return vertical;
		
	}
	
	private void horizontalDistance(BinaryNode node, int hor_dis, Map<Integer, List<BinaryNode>> map) {
		
		if(node != null) {
			
			if(map.containsKey(hor_dis))
				map.get(hor_dis).add(node);
			
			else {
				List<BinaryNode> nodes = new ArrayList<BinaryNode>();
				nodes.add(node);
				map.put(hor_dis, nodes);
			}
				
			horizontalDistance(node.getLeft(), hor_dis-1, map);
			horizontalDistance(node.getRight(), hor_dis+1, map);
		}
	}
}
