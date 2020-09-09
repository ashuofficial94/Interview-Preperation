package stacks;

//Reverse the stack without using extra iterative stack but only recursive stack

public class StackReversal<Type> {

	/*
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<String>();
		
		while(true) {
			List<String> input= Arrays.asList(br.readLine().split(" "));
			switch(Integer.parseInt(input.get(0))) {
			
			case 1:
				for(String elem : input.subList(1, input.size())) {
					stack.push(elem);
					System.out.println("Pushed - " + elem);
				}
				break;
				
			case 2:
				int pops = input.size() == 1 ? 1 : Integer.parseInt(input.get(1));
				for(int i=0; i<pops; i++) System.out.println("Popped - " + stack.pop());
				break;
				
			case 3:
				System.out.println(stack.getStack());
				break;
			
			case 4:
				StackReversal<String> rev = new StackReversal<String>();
				rev.reverse(stack);
				System.out.println("Stack Reversed.");
				break;
				
			default:
				System.out.println("Enter 1 for push; 2 for pop; 3 to get stack and 4 to reverse");
			}
		}
	}
	*/
	
	public void reverse(Stack<Type> stack) {
		if(stack.isEmpty()) return;
		Type item = stack.pop();
		reverse(stack);
		insertAtBottom(stack, item);
	}
	
	private void insertAtBottom(Stack<Type> stack, Type item) {
		if(stack.isEmpty()) {
			stack.push(item);
			return;
		}
		Type top = stack.pop();
		insertAtBottom(stack, item);
		stack.push(top);
	}
}
