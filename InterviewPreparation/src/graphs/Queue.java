package graphs;

import java.util.ArrayList;
import java.util.List;

public class Queue {

	private List<Node> queue;
	
	Queue() {
		queue = new ArrayList<Node>();
	}
	
	public boolean enqueue(Node node) {
		return queue.add(node);
	}
	
	public Node dequeue(Node node) {
		
		if(queue.size() > 1)
			return queue.remove(0);
		
		else
			return null;
	}
}
