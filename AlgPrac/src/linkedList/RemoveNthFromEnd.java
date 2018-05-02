package linkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;

/***************************************************************************
* Problem No. : 19
* Problem Name: Remove Nth Node From End of List
* Problem URL : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
* Date        : May 2, 2018
* Author      : Xian Lin
* Notes       :
* 	Scenario:
* 		Remove the Nth node from the end of the list.
* 	Assumption:
*
	Example:
* 	Input/Output:
*
* 	Data Structure and Alg:
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-linked-list, tag-
***************************************************************************/
public class RemoveNthFromEnd {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (n <= 0) {
			return null;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode preDel = dummy;
		for (int i = 0; i < n; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		while (head != null) {
			preDel = preDel.next;
			head = head.next;
		}
		preDel.next = preDel.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Remove Nth from End of List Driver ***");

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

		System.out.print("Input an integer represent the Nth position from the end: ");
		int num = sc.nextInt();

		ListNode head = ll.getHead();

		System.out.print("The given linked list after remove Nth is: ");
		ListNode newHead = removeNthFromEnd(head, num);
		ll.displayLinkedList(newHead);
	}
}
