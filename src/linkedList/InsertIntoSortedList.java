package linkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;

public class InsertIntoSortedList {

	public static ListNode insertIntoSortedList(ListNode head, int val) {
		ListNode node = new ListNode(val);
		// Case 1: empty list
		if (head == null) {
			head = node;
			return head;
		}
		
		// Case 2: non-empty list with only one element
		if (head.next == null) {
			if (node.val <= head.val) {
				node.next = head;
				head = node;
			} else {
				head.next = node;
			}
			return head;
		}
		
		// Case 3: non-empty list with at least 2 elements already
		if (node.val <= head.val) {
			node.next = head;
			head = node;
		} else {
			ListNode p1 = head;
			ListNode p2 = p1.next;
			while (p2.next != null) {
				if (node.val > p1.val && node.val <= p2.val) {
					p1.next = node; 
					node.next = p2;
				}
				p1 = p1.next;
				p2 = p1.next;
			}
			if (node.val > p1.val && node.val <= p2.val) {
				p1.next = node; 
				node.next = p2;
			} else if (node.val > p2.val) {
				p2.next = node;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Insert an Element into A Sorted Linked List Driver ***");
		
		LinkedList ll = new LinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \nin Ordered Sequence, and leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			ll.insertLast(testArray[i]);
		}		
		ll.displayLinkedList();
		
		System.out.print("Enter an integer you wanna insert into the "
				+ "list you just created: ");
		int valToInsert = sc.nextInt();
		
		
		ListNode head = ll.getHead();
		ListNode newHead = insertIntoSortedList(head, valToInsert);
		ll.displayLinkedList(newHead);
	}
}
