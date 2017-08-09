package singlyLinkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;

public class PartitionList {
	
	public static ListNode partition(ListNode head, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummyLeft = new ListNode(-1);
		ListNode dummyRight = new ListNode(-1);
		ListNode left = dummyLeft, right = dummyRight;
		while (head != null) {
			if (head.data < n) {
				left.next = head;
				left = left.next;
			} else {
				right.next = head;
				right = right.next;
			}
			head = head.next;
		}
		right.next = null;
		left.next = dummyRight.next;
		return dummyLeft.next;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Partition List Driver ***");
		
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
		
		System.out.print("Input an integer that you want to be the pivot: ");
		int num = sc.nextInt();
		
		ListNode head = ll.getHead();
		
		System.out.print("The given linked list after reverse is: ");
		ListNode newHead = partition(head, num);
		ll.displayLinkedList(newHead);
	}
}
