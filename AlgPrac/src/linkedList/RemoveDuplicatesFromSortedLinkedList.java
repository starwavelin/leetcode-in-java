package linkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;
/**
 * @author benjaminlin
 * When there is an element with duplicates, just leave one copy of this element
 */

public class RemoveDuplicatesFromSortedLinkedList {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		while (node.next != null) {
			if (node.data == node.next.data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Remove Duplicates From A Sorted Linked List Driver ***");

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
