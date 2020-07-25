package stacks;

//Get the minimum element in the stack in O(1)

public class MinStack {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	MinStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void push(int elem) {
		
		int min;
		if(stack2.getTop() == null) min = elem;
		else min =  elem <= stack2.getTop() ? elem : stack2.getTop();
		
		stack1.push(elem);
		stack2.push(min);
	}
	
	public void pop() {
		
		if(!stack1.isEmpty()) stack1.pop();
		if(!stack2.isEmpty()) stack2.pop();	
	}
	
	public int getMin() {
	
		if(!stack2.isEmpty()) return stack2.getTop();
		return Integer.MAX_VALUE;
	}
}
