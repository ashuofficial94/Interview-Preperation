package stacks;

import java.util.ArrayList;
import java.util.List;

public class Queue<Type> {

	private List<Type> queue;
	
	Queue() {
		queue = new ArrayList<Type>();
	}
	
	public boolean enqueue(Type elem) {
		return queue.add(elem);
	}
	
	public Type dequeue() {
		if(queue.size() > 0) return queue.remove(0);
		return null;
	}
	
	public List<Type> getQueue() {
		return new ArrayList<Type>(queue);
	}
	
	public boolean isEmpty() {
		return queue.size() == 0;
	}
}
