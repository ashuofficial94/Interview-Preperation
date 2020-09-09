package stacks;

//Total number of bracket reversals required to make the expression balanced

public class BracketReversal {
	
	public int bracketReversal(String brackets) {
		
		Stack<Character> stack = new Stack<Character>();
		if(brackets.length() % 2 == 1) return -1;
				
		for(int i=0; i<brackets.length(); i++) {
			
			if(brackets.charAt(i) == '}' && !stack.isEmpty()) {
				
				if(stack.getTop() == '{') stack.pop();
				else stack.push(brackets.charAt(i)); 
			}
			
			else stack.push(brackets.charAt(i));
		}
		
		int unbal_length = stack.getStack().size();
		int n = 0;

		while(!stack.isEmpty() && stack.getTop() == '{') {
			stack.pop();
			n++;
		}
		
		
		return (unbal_length/2 + n%2);
	}

}
