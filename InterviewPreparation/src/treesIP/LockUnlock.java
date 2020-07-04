package treesIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//lock and unlock resources that are arranged in a k-ary tree.
//A node can't be locked if any of its ancestors or descendants are locked.

public class LockUnlock {
	
	/*
	public static void main(String arge[]) throws IOException{
		
		NaryInit init = new NaryInit();
		NaryTree tree = init.initialize();
		init.printTree(tree);
		
		LockUnlock lu = new LockUnlock();
		lu.lockUnlockLog(tree);
//		lu.lockUnlock(tree);
		
	}
	*/
	
	private Map<NaryNode, Boolean> locks = new HashMap<NaryNode, Boolean>();
	
	private void setParents(NaryNode parent, Map<NaryNode, NaryNode> parents) {
		
		for(NaryNode child : parent.getChildren()) {
			parents.put(child, parent);
			setParents(child, parents);
		}
	}
	
	private void initializeLocks(NaryNode node) {
		
		locks.put(node, false);
		for(NaryNode child : node.getChildren()) initializeLocks(child);
	}
	
	private void initializeCount(NaryNode node, Map<NaryNode, Integer> lock_count) {
		
		lock_count.put(node, 0);
		for(NaryNode child : node.getChildren()) initializeCount(child, lock_count);
	}
	
	public void lockUnlockLog(NaryTree tree) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		initializeLocks(tree.getRoot());

		Map<NaryNode, NaryNode> parents = new HashMap<NaryNode, NaryNode>();
		parents.put(tree.getRoot(), null);
		setParents(tree.getRoot(), parents);
		
		Map<NaryNode, Integer> lock_count = new HashMap<NaryNode, Integer>();
		initializeCount(tree.getRoot(), lock_count);
		
		System.out.println("\nEnter the node and unlock/lock (0/1): \n");
		
		while(true) {
			
			String[] input = br.readLine().split(" ");
			int value = Integer.parseInt(input[0]);
			int lock = Integer.parseInt(input[1]);
			
			NaryNode node = tree.getNode(new NaryNode(value));
			if(node == null) {
				System.out.println("No such node.\n");
				continue;
			}
			
			if(lock == 0 && !locks.get(node))
				System.out.println(node.getValue() + " already unlocked.\n");
			
			else if(lock == 0 && locks.get(node)) {
				locks.replace(node, false);
				NaryNode parent = parents.get(node);
				
				while(parent != null) {
					int count = lock_count.get(parent);
					lock_count.replace(parent, count-1);
					System.out.println(parent.getValue() + " lock count : " + lock_count.get(parent));
					parent = parents.get(parent);
				}
				
				System.out.println(node.getValue() + " unlocked.\n");
			}
			
			else if(lock == 1 && locks.get(node))
				System.out.println(node.getValue() + " already locked.\n");
			
			else if(lock == 1 && !locks.get(node)) {
				
				if(lock_count.get(node) > 0) {
					System.out.println("Can't be locked. Lock Count : " + lock_count.get(node) + ".\n");
					continue;
				}
				
				boolean parent_locked = false;
				NaryNode parent = parents.get(node);
				
				while(parent != null) {
					
					if(locks.get(parent)) {
						System.out.println("Can't be locked. Parent Locked : " + parent.getValue() + ".\n");
						parent_locked = true;
						break;
					}
					
					parent = parents.get(parent);
				}
				
				if(parent_locked) continue;
				
				locks.replace(node, true);
				parent = parents.get(node);

				while(parent != null) {
					int count = lock_count.get(parent);
					lock_count.replace(parent, count+1);
					System.out.println(parent.getValue() + " lock count : " + lock_count.get(parent));
					parent = parents.get(parent);
				}

				System.out.println(node.getValue() + " locked.\n");
			}
		}
	}
	
	public void lockUnlock(NaryTree tree) throws IOException {

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
					
					if(!locks.get(node)) {
						System.out.println(node.getValue() + " already unlocked.\n");
						continue;
					}
					
					System.out.println(node.getValue() + " unlocked.\n");
					locks.replace(node, false);
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
				
				if(locks.get(path.get(0))) {
					System.out.println(path.get(0).getValue() + " already locked.\n");
					continue;
				}
				
				boolean ancestor_locked = false;
				boolean descendant_locked = false;
				
				for(NaryNode ancestor : ancestors) {
					if(locks.get(ancestor)) {
						System.out.println("Can't be locked as " + ancestor.getValue() + " is locked.\n");
						ancestor_locked = true;
						break;
					}
				}
				
				if(ancestor_locked) continue;
				
				for(NaryNode descendant : descendants) {
					if(locks.get(descendant)) {
						System.out.println("Can't be locked as " + descendant.getValue() + " is locked.\n");
						descendant_locked = true;
						break;
					}
				}
				
				if(descendant_locked) continue;
				
				locks.replace(path.get(0), true);
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
