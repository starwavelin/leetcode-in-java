package singlyLinkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;

/**
 * ie. 1->1->2->3 becomes 2->3
 * 1->2->2->2->3 becomes 1->3
 * 
 */
public class RemoveDuplicatesII {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while (head.next != null && head.next.next != null) {
			if (head.next.data == head.next.next.data) {
				int dataToRemove = head.next.data;
				while (head.next != null && head.next.data == dataToRemove) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Remove Duplicates II From A Sorted Linked List Driver ***");
		
		LinkedList ll = new LinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \nleave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			ll.insertLast(testArray[i]);
		}		
		ll.displayLinkedList();
		
		
		ListNode head = ll.getHead();
		ListNode newHead = deleteDuplicates(head);
		ll.displayLinkedList(newHead);
	}	
}
