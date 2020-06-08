package treesIP;

import java.util.ArrayList;
import java.util.List;

public class NaryTree {

	private NaryNode root;
	
	NaryTree(NaryNode root) {
		this.root = root;
	}
	
	public NaryNode getRoot() {
		return root;
	}
	
	public NaryNode getNode(NaryNode target) {
		
		List<NaryNode> queue = new ArrayList<NaryNode>();
		queue.add(root);
		
		while(queue.size() > 0) {
			
			NaryNode node = queue.remove(0);
			if(node.getValue() == target.getValue()) return node;
			queue.addAll(node.getChildren());
		}
		
		return null;
	}
	
	public List<NaryNode> getNodeList() {
		
		List<NaryNode> node_list = new ArrayList<NaryNode>();
		node_list.add(root);
		
		for(int index=0; index < node_list.size() ; index++) {
			node_list.addAll(node_list.get(index).getChildren());
		}
		
		return node_list;
	}
}
