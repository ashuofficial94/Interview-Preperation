package treesIP;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	private List<BinaryNode> stack;
	
	public Stack() {
		stack = new ArrayList<BinaryNode>();
	}
	
	public Stack(BinaryNode BinaryNode) {
		stack = new ArrayList<BinaryNode>();
		stack.add(BinaryNode);
	}
	
	public List<BinaryNode> getStack(){
		return stack;
	}
	
	public BinaryNode getTop() {
		if(stack.size() > 0)
			return stack.get(stack.size() - 1);
		
		return null;
	}
	
	public boolean push(BinaryNode BinaryNode) {
		return stack.add(BinaryNode);
	}
	
	public BinaryNode pop() {
		if(stack.size() > 0)
			return stack.remove(stack.size()-1);
		
		return null;
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}
}
