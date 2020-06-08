package treesIP;

import java.util.ArrayList;
import java.util.List;

public class NaryStack {

	private List<NaryNode> stack;
	
	public NaryStack() {
		stack = new ArrayList<NaryNode>();
	}
	
	public List<NaryNode> getStack(){
		return stack;
	}
	
	public NaryNode getTop() {
		if(stack.size() > 0)
			return stack.get(stack.size() - 1);
		
		return null;
	}
	
	public boolean push(NaryNode NaryNode) {
		return stack.add(NaryNode);
	}
	
	public NaryNode pop() {
		if(stack.size() > 0)
			return stack.remove(stack.size()-1);
		
		return null;
	}
}
