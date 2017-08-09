package utility;

public class ListNode {
	public int data;
	public ListNode next;
	
	public ListNode(int data) {
		this.data = data;
		next = null;
	}
	
	public void displayNode() {
		System.out.print("{" + data + "}");
	}
}
