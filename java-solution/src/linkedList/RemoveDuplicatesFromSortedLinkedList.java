package linkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;
/***************************************************************************
* Problem No. : 83
* Problem Name: Remove Duplicates from Sorted List
* Problem URL : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
* Date        : Oct 21 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a sorted linked list, delete all duplicates such that each element appear only once.
* 	Assumption:
* 
	Example:
* 	Input/Output:
* 		For example,
			Given 1->1->2, return 1->2.
			Given 1->1->2->3->3, return 1->2->3.
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-linked-list, tag-two-pointers
***************************************************************************/
public class RemoveDuplicatesFromSortedLinkedList {
	
	/**
	 * Solution 1:
	 * Use one traveler pointer, clear all the duplicated integers then move this traveler pointer forward
	 * Time Complexity: O(n) - traverse the list
	 * Space Complexity: O(1) - open a pointer
	 * 
	 * Solution 1 is better cuz it doesn't need to deal with the special case of having repeated integers at the end.
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		while (node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}
	
	/**
	 * Solution 2:
	 * 	Use 2 pointers:
	 * cur pointer equals prev pointer's next. When cur.val is prev.val, move cur until cur.val != prev.val.
	 * At this time, we set prev.next = cur and move prev pointer to point the same node as cur.
	 * This solution needs to handle repeated integers existing in the end of list specifically. So, 
	 * 	when cur == null, we want prev.next = cur after the while loop
	 * 
	 * Time Complexity: O(n) - traverse the whole list
	 * Space Complexity: O(1) - open two pointers
	 */
	public static ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = head, cur = prev.next;
		while (cur != null) {
			if (prev.val == cur.val) {
				cur = cur.next;
			} else {
				prev.next = cur; //delete repeated integer nodes.
				prev = cur;
			}
		}
		prev.next = cur; // deal the case of having repeated integers at the end
		return head;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Remove Duplicates From A Sorted Linked List Driver ***");
		LinkedList ll = new LinkedList();
		Scanner sc = new Scanner(System.in);
		
		/* Test Solution 1 */
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			ll.insertLast(testArray[i]);
		}
		System.out.print("List before removing duplicates: ");
		ll.displayLinkedList();
		ListNode head = ll.getHead();
		ListNode newHead = deleteDuplicates(head); /* Solution 1 */
		System.out.print("List after removing duplicates: ");
		ll.displayLinkedList(newHead);
		
		/* Test Solution 2 */
		ll = new LinkedList(); // reset ll
		System.out.print("Input your integer array, leave each number by space: ");
		strs = sc.nextLine().split(" ");
		testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			ll.insertLast(testArray[i]);
		}
		System.out.print("List before removing duplicates: ");
		ll.displayLinkedList();
		head = ll.getHead();
		newHead = deleteDuplicates2(head); /* Solution 2 */
		System.out.print("List after removing duplicates: ");
		ll.displayLinkedList(newHead);
	}
}
