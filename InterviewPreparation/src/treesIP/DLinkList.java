package treesIP;

public class DLinkList {

	private DLinkNode head;
	
	DLinkList(DLinkNode head) {
		this.head = head;
	}
	
	DLinkList() {
		head = null;
	}
	
	public DLinkNode getHead() {
		return head;
	}
	
	public DLinkNode addNodeEnd(DLinkNode node) {
		
		DLinkNode curr = head;
		
		if(curr == null) {
			head = node;
			return head;
		}
		
		for(; curr.next != null; curr = curr.next);
		curr.next = node;
		node.prev = curr;
		
		return head;
	}
	
	public DLinkNode addNodeHead(DLinkNode node) {
		
		if(head == null) {
			head = node;
			return head;
		}
		
		node.next = head;
		head.prev = node;
		head = node;
		return head;
		
	}
	
	public void printAll() {
		
		System.out.print("\nList : ");
		
		for(DLinkNode curr = head; curr != null; 
				System.out.print(curr.value + " "), curr = curr.next);
		
		System.out.println();
	}
	
	public void printReverse() {
		
		DLinkNode curr;
		System.out.print("\nReversed : ");
		
		for(curr = head; curr.next != null; curr = curr.next);
		for(; curr != null ; System.out.print(curr.value + " "), curr = curr.prev);
		
		System.out.println();
	}
}
