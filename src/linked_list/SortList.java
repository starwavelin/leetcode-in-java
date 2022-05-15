package linked_list;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;

/***************************************************************************
* Problem No. : 148
* Problem Name: Sort List
* Problem URL : https://leetcode.com/problems/sort-list/description/
* Date        : May 1, 2018
* Author      : @codingbro
* Notes       :
* 	Scenario:
*
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
public class SortList {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}

	private static ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private static ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
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

	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Sort List Driver ***");

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

		ListNode head = ll.getHead();

		System.out.print("The given linked after sorting is: ");
		ListNode newHead = sortList(head);
		ll.displayLinkedList(newHead);
	}
}
