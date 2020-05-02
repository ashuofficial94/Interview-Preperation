package graphs;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	private List<Node> stack;
	
	Stack() {
		stack = new ArrayList<Node>();
	}
	
	Stack(Node node) {
		stack = new ArrayList<Node>();
		stack.add(node);
	}
	
	public List<Node> getStack(){
		return stack;
	}
	
	public boolean push(Node node) {
		return stack.add(node);
	}
	
	public Node pop() {
		if(stack.size() > 0)
			return stack.remove(stack.size()-1);
		
		return null;
	}
}
