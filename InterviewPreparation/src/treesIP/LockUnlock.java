package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//lock and unlock resources that are arranged in a k-ary tree

public class LockUnlock {
	
	private Map<NaryNode, Boolean> lock_data = new HashMap<NaryNode, Boolean>();
	
	private void initializeLocks(NaryNode node) {
		lock_data.put(node, false);
		for(NaryNode child : node.getChildren()) initializeLocks(child);
	}
	
	public void lockUnclock(NaryTree tree) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		initializeLocks(tree.getRoot());
		System.out.println("\nEnter the node and unlock/lock (0/1): \n");
		
		while(true) {
			
			List<NaryNode> path = new ArrayList<NaryNode>();
			
			String[] input = br.readLine().split(" ");
			int value = Integer.parseInt(input[0]);
			int lock = Integer.parseInt(input[1]);
			
			if(lock == 0) {
				
				NaryNode node = tree.getNode(new NaryNode(value));
				
				if(node != null) {
					
					if(!lock_data.get(node)) {
						System.out.println(node.getValue() + " already unlocked.\n");
						continue;
					}
					
					System.out.println(node.getValue() + " unlocked.\n");
					lock_data.replace(node, false);
				}
				
				else {
					System.out.println("Node doesn't exist.\n");
				}
				
				continue;
			}
			
			else if(lock == 1) {
			
				findPath(tree.getRoot(), value, path);
				
				List<NaryNode> ancestors = path.subList(1, path.size());
				List<NaryNode> descendants = new ArrayList<NaryNode>();
				findDescendants(path.get(0), descendants);
				
				if(lock_data.get(path.get(0))) {
					System.out.println(path.get(0).getValue() + " already locked.\n");
					continue;
				}
				
				boolean ancestor_locked = false;
				boolean descendant_locked = false;
				
				for(NaryNode ancestor : ancestors) {
					if(lock_data.get(ancestor)) {
						System.out.println("Can't be locked as " + ancestor.getValue() + " is locked.\n");
						ancestor_locked = true;
						break;
					}
				}
				
				if(ancestor_locked) continue;
				
				for(NaryNode descendant : descendants) {
					if(lock_data.get(descendant)) {
						System.out.println("Can't be locked as " + descendant.getValue() + " is locked.\n");
						descendant_locked = true;
						break;
					}
				}
				
				if(descendant_locked) continue;
				
				lock_data.replace(path.get(0), true);
				System.out.println(path.get(0).getValue() + " locked.\n");
			}
		}
		
	}
	
	public void findDescendants(NaryNode node, List<NaryNode> descendants) {
		
		for(NaryNode child : node.getChildren()) {
			descendants.add(child);
			findDescendants(child, descendants);
		}
	}
	
	public boolean findPath(NaryNode node, int target, List<NaryNode> path) {
		
		if(node.getValue() == target) {
			path.add(node);
			return true;
		}
		
		for(NaryNode child : node.getChildren()) {
			
			if(findPath(child, target, path)) {
				path.add(node);
				return true;
			}
		}
		
		return false;
	}
}
