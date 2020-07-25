package stacks;

import java.util.List;

//Implement the stack using two queues

public class QueueStack {

	/*
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		QueueStack qs = new QueueStack();
		
		while(true) {
			System.out.println("Stack Operations - \n1.Push\n2.Pop");
			System.out.print("Enter Choice : ");
			int input = Integer.parseInt(br.readLine());
			
			if(input == 1) {
				
				System.out.print("\nEnter Elements : ");
				String[] buffer = br.readLine().trim().split(" ");
				List<Integer> elements = new ArrayList<Integer>();
				
				for(String elem : buffer) elements.add(Integer.parseInt(elem));
				qs.push(elements);
			}
			
			else if(input == 2) {
				System.out.println("Pop : " + qs.pop() + "\n");
			}
		}
	}
	*/
	
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
	
	QueueStack() {
		queue1 = new Queue<Integer>();
		queue2 = new Queue<Integer>();
	}
	
	public void push(List<Integer> elements) {
		
		for(int elem : elements) {
			
			if(queue1.isEmpty()) {	
				queue1.enqueue(elem);
				while(!queue2.isEmpty()) queue1.enqueue(queue2.dequeue());
			}
			
			else if(queue2.isEmpty()) {
				queue2.enqueue(elem);
				while(!queue1.isEmpty()) queue2.enqueue(queue1.dequeue());
		
			}
		}
		
		System.out.println("Pushed.\n");
	}
	
	public int pop() {
		
		if(queue1.isEmpty() && queue2.isEmpty()) {
			System.out.println("\nUnderflow\n");
			return -1;
		}
		
		else if(queue1.isEmpty() && !queue2.isEmpty()) {
			return queue2.dequeue();
		}
		
		else {
			return queue1.dequeue();
		}
	}
}
