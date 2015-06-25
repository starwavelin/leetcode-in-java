package singlyLinkedList;

import java.util.Scanner;

public class SortList {
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ "Sort List Driver ***");
		
		LinkedList ll = new LinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n"
				+ "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			ll.insertLast(testArray[i]);
		}		
		ll.displayLinkedList();
				
		Node head = ll.getHead();
		
		System.out.print("The given linked after sorting is: ");
		Node newHead = sortList(head);
		ll.displayLinkedList(newHead);
	}
	
	public static Node sortList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node mid = findMid(head);
		Node right = sortList(mid.next);
		mid.next = null;
		Node left = sortList(head);
		return merge(left, right);
	}
	
	private static Node findMid(Node head) {
		Node slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private static Node merge(Node head1, Node head2) {
		Node dummy = new Node(-1);
		Node tail = dummy;
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		if (head1 != null) {
			tail.next = head1;
		} else {
			tail.next = head2;
		}
		return dummy.next;
	}
	
}
