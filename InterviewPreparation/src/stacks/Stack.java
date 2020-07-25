package stacks;

import java.util.ArrayList;
import java.util.List;

public class Stack<Type> {

	private List<Type> stack;
	
	Stack() {
		stack = new ArrayList<Type>();
	}
	
	public boolean push(Type elem) {
		return stack.add(elem);
	}
	
	public Type pop() {
		if(stack.size() > 0) return stack.remove(stack.size() - 1);
		return null;
	}
	
	public Type getTop() {	
		if(stack.size() > 0) return stack.get(stack.size() - 1);
		return null;
	}
	
	public List<Type> getStack() {
		return new ArrayList<Type>(stack);
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}
		
}
