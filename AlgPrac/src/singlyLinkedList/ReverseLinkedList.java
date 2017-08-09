package singlyLinkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;

public class ReverseLinkedList {
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Reverse Linked List I (iterative way) Driver ***");
		
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
		
		System.out.print("The given linked list after reverse is: ");
		ListNode newHead = reverse(head);
		ll.displayLinkedList(newHead);
	}
}