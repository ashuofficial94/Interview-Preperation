package treesIP;

import java.util.ArrayList;
import java.util.List;

public class Queue {

	private List<BinaryNode> queue;
	
	Queue() {
		queue = new ArrayList<BinaryNode>();
	}
	
	Queue(BinaryNode node) {
		queue = new ArrayList<BinaryNode>();
		queue.add(node);
	}
	
	public List<BinaryNode> getQueue() {
		return queue;
	}
	
	public boolean enqueue(BinaryNode node) {
		return queue.add(node);
	}
	
	public BinaryNode dequeue() {
		
		if(queue.size() > 0)
			return queue.remove(0);
		
		return null;
	}
}