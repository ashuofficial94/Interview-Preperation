package graphs;

import java.util.ArrayList;
import java.util.List;

public class Queue {

	private List<Node> queue;
	
	Queue() {
		queue = new ArrayList<Node>();
	}
	
	Queue(Node node) {
		queue = new ArrayList<Node>();
		queue.add(node);
	}
	
	public List<Node> getQueue() {
		return queue;
	}
	
	public boolean enqueue(Node node) {
		return queue.add(node);
	}
	
	public Node dequeue() {
		
		if(queue.size() > 0)
			return queue.remove(0);
		
		return null;
	}
}
