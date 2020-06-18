package treesIP;

public class ListNode {

	private int value;
	private ListNode next;
	
	ListNode(int value) {
		this.value =  value;
		next = null;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode getNext() {
		return next;
	}
}
