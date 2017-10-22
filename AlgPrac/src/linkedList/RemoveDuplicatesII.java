package linkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;

/***************************************************************************
* Problem No. : 82
* Problem Name: Remove Duplicates from Sorted List II
* Problem URL : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
* Date        : Oct 21 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a sorted linked list, delete all nodes that have duplicate numbers, 
* 		leaving only distinct numbers from the original list.
* 	Assumption:
* 
	Example:
* 	Input/Output:
* 		For example,
			Given 1->1->2->3, return 1->2->3.
			Given 1->1->2->3->3, return 2->null.
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-linked-list
***************************************************************************/
public class RemoveDuplicatesII {

	/**
	 * Since the head of the resulted linked list is not determined, we use a dummy node to help.
	 * 
	 * Solution:
	 * 	Single pointer solution using head (if we don't count dummy node), and use another var to store the value of the nodes
	 * that should be removed.
	 * Note: This problem cannot be done via two-pointers method cuz when removing all consecutive nodes from list, 
	 * 	the removal process has something to do with the previous node and next node of the all consecutive nodes being removed.
	 * 	ie. 
	 * 		ex1. dummy -> 1 -> 1 -> 1 -> 2 -> 3  should return 2->3
	 * 		ex2. dummy -> 1 -> 1 -> 1 -> 2 -> 2 -> 3  should return 3
	 * Surely I can set prev = dummy and cur = head at the beginning, but how can I know when I shall update prev to cur or shall not do it.
	 * As the solution below, record the val of the nodes being removed can help. Then one traveler pointer head is good enough.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * 口诀: head从dummy始，先删同，再移head
	 */
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
				while (head.next != null && head.next.data == dataToRemove) { /* Core: Rm all the same nodes */ 
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Remove Duplicates From A Sorted Linked List II Driver ***");
		LinkedList ll = new LinkedList();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input your integer array, leave each number by space: ");
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
