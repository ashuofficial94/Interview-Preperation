package stacks;

public class RedundantBrackets {

	public String redundantBrackets(String expression) {
		
		StringBuilder builder = new StringBuilder(expression);
		Stack<Character> char_stack = new Stack<Character>();
		Stack<Integer> index_stack = new Stack<Integer>();
		
		for(int index=0; index<builder.length(); index++) {
				
			if (builder.charAt(index) == ')') {
				if(!char_stack.isEmpty() && char_stack.getTop() == '(' ) {
					int index1 = index_stack.pop();
					char_stack.pop();
					builder.delete(index, index+1);
					builder.delete(index1, index1+1);
					index-=2;
				}
				
				else {
					while(!char_stack.isEmpty() && char_stack.getTop() != '(') {
						char_stack.pop();
						index_stack.pop();
					}
					
					char_stack.pop();
					index_stack.pop();
				}
			}
			
			else {
				char_stack.push(builder.charAt(index));
				index_stack.push(index);
			}
		}
		
		return builder.toString();
	}
}
