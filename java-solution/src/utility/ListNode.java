package utility;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int val) {
		this.val = val;
		next = null;
	}
	
	public void displayNode() {
		System.out.print("{" + val + "}");
	}
}
