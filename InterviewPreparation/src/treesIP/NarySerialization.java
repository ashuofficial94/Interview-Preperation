package treesIP;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarySerialization {

	/*
	public static void main(String arge[]) throws IOException{
		
		NaryInit init = new NaryInit();
		NaryTree nary = init.initialize();
		init.printTree(nary);
		
		NarySerialization obj = new NarySerialization();
		List<Integer> serial = obj.narySerialization(nary);
		
		System.out.println();
		for(int node : serial) {
			System.out.print(node + " ");
		}
		
		NaryTree deserialized = obj.naryDeserialization(serial);
		System.out.println();
		init.printTree(deserialized);
		
	}
	*/
	//SERIALIZATION WITH RECURSION
	public List<Integer> narySerialization(NaryTree nary) {
		
		List<Integer> serial = new ArrayList<Integer>();
		preorder(nary.getRoot(), serial);
		return serial;
	}
	
	private void preorder(NaryNode node, List<Integer> serial) {
		
		serial.add(node.getValue());
		for(NaryNode child : node.getChildren()) preorder(child, serial);
		serial.add(0);
	}
	
	//DESERIALIZATION WITH RECURSION
	public NaryTree naryDeserialization(List<Integer> serial) {
		
		NaryNode root = new NaryNode(serial.remove(0));
		NaryTree nary = new NaryTree(root);
		buildTree(root, serial);
		return nary;
	}
	
	private boolean buildTree(NaryNode node, List<Integer> serial) {

		NaryNode child = new NaryNode(serial.remove(0));
		if(child.getValue() == 0) return false;
		node.addChild(child);
		
		while(!buildTree(child, serial)) {
			child = new NaryNode(serial.remove(0));
			if(child.getValue() == 0) return false;
			node.addChild(child);
		}
		
		return true;
	}
	
	//SERIALIZATION WITHOUT RECURSION(USING STACK)
	
	/*
	public List<Integer> narySerialization(NaryTree nary) {
		
		List<Integer> serial = new ArrayList<Integer>();
		
		Map<NaryNode, Boolean> visited = new HashMap<NaryNode, Boolean>();
		for(NaryNode node: nary.getNodeList()) visited.put(node, false);
		visited.replace(nary.getRoot(), true);
		
		NaryStack stack = new NaryStack();
		stack.push(nary.getRoot());
		serial.add(nary.getRoot().getValue());
		
		while(stack.getStack().size() > 0) {
			
			NaryNode node = stack.getTop();
			boolean child_visited = true;
			
			for(NaryNode child : node.getChildren()) {
				if(!visited.get(child)) {
					
					stack.push(child);
					serial.add(child.getValue());
					child_visited = false;
					visited.replace(child, true);
					break;
				}
			}
			
			if(child_visited) {
				serial.add(0);
				stack.pop();
			}
		}
		
		return serial;
	}
	*/
	
	//DESERIALIZATION WITHOUT RECURSION (USING STACK)
	/*
	public NaryTree naryDeserialization(List<Integer> serial) {
		
		NaryNode root = new NaryNode(serial.get(0));
		NaryTree nary = new NaryTree(root);
		
		NaryStack stack = new NaryStack();
		stack.push(nary.getRoot());
		serial.remove(0);
		
		for(Integer value: serial) {
			
			NaryNode parent = stack.getTop();
			
			if(value == 0) {
				stack.pop();
				continue;
			}
			
			NaryNode child = new NaryNode(value);
			parent.addChild(child);
			stack.push(child);
		}
		
		return nary;
	}
	*/	
}
