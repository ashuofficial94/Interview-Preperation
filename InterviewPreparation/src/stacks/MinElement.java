package stacks;

public class MinElement {
	
	Stack<Integer> stack = new Stack<Integer>();
	int curr_min = Integer.MAX_VALUE;
	
	/*
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MinElement me = new MinElement();
		
		while(true) {
			String[] buffer = br.readLine().split(" ");
			List<Integer> input = new ArrayList<Integer>();
			for(String str : buffer) input.add(Integer.parseInt(str));
			
			switch(input.remove(0)) {
			
			case 1:
				for(Integer elem : input) {
					me.push(elem);
					System.out.println("Pushed : " + elem);
				}
				break;
				
			case 2:
				int pops = input.size() == 0 ? 1 : input.get(0);
				for(int i=0; i<pops; i++) {
					System.out.println("Popped");
					me.pop();
				}
				break;
				
			case 3:
				System.out.println("Current Min in Stack : " + (me.curr_min));
				break;
				
			case 4:
				System.out.println(me.stack.getStack());
				
			default:
				System.out.println("Enter 1 for push; 2 for pop and 3 to get min");
			}
		}
	}
	*/
	
	public void push(int value) {
		
		if(stack.isEmpty()) {
			stack.push(value);
			curr_min = value;
			return;
		}
		
		if(value < curr_min) {
			stack.push(value - curr_min);
			curr_min = value;
			return;
		}
		
		else if(value > curr_min) stack.push(value);
	}
	
	public int pop() {
		
		if(stack.isEmpty()) {
			curr_min = Integer.MAX_VALUE;
			return stack.pop();
		}
		
		else {
			if(curr_min < stack.getTop()) return stack.pop();
			else {
				curr_min = curr_min - stack.getTop();
				return stack.pop();
			}
		}
	}
}
