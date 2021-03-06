package utility;

public class LinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int size;		// record the number of nodes in this linked list
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void insertFirst(int data) {
		ListNode node = new ListNode(data);
		if (isEmpty()) {
			head = node;
			tail = node;
			size++;
			return;
		}
		
		node.next = head;
		head = node;
		size++;
		return;		
	}
	
	public void insertLast(int data) {
		ListNode node = new ListNode(data);
		if (isEmpty()) {
			head = node;
			tail = node;
			size++;
			return;
		}
		
		tail.next = node;
		tail = node;
		size++;
		return;
	}
	
	public void removeFirst() throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("List is empty, no node to be removed.");
		}
		if (size == 1) {
			head = null;
			tail = null;
			size--;
			return;
		}
		head = head.next;
		size--;
		return;
	}
	
	/* In a singly linked list, no prev pointer, so removeLast() is O(n) in time, not recommended */
	public void removeLast() throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("List is empty, no node to be removed.");
		}
		if (size == 1) {
			head = null;
			tail = null;
			size--;
			return;
		}		
		// double pointers
		ListNode p1 = head;
		ListNode p2 = p1.next;
		while (p2 != tail) {
			p1 = p1.next;
			p2 = p1.next;			
		}
		p1.next = null;
		tail = p1;
		size--;
		return;
	}
	
	public void displayLinkedList() {
		if (isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		ListNode p1 = head;
		while (p1 != null) {
			p1.displayNode();
			p1 = p1.next;
		}
		System.out.println();
	}
	
	
	// For coding exam purpose
	public void displayLinkedList(ListNode head) {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		ListNode p1 = head;
		while (p1 != null) {
			p1.displayNode();
			p1 = p1.next;
		}
		System.out.println();
	}
	
	public ListNode getHead() {
		return head;
	}
	
	public ListNode getTail() {
		return tail;
	}
	
}
