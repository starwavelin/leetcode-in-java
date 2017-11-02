package linkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;
/***************************************************************************
* Problem No. : 206
* Problem Name: Reverse Linked List
* Problem URL : https://leetcode.com/problems/reverse-linked-list/description/
* Date        : Nov 2 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Reverse a linked list and return the head of the reversed linked list
* 	Assumption:
* 		
	Example:
* 	Input:	1->2->4
* 	Output: 4->2->1
* 			
* 	Data Structure and Alg:
* 		See code comments
* 		  
* Complexity  : 
* 	Time Complexity: O() -- See code comments
* 	Space Complexity: O() -- See code comments
* 
* meta        : tag-linked-list
* 
* 考点: 双或多指针；递归。
***************************************************************************/
public class ReverseLinkedList {
	
	/**
	 * Solution 1: Iterative solution:
	 * 	Use var next to keep head's next node,
	 * 	Use var prev to keep head's previous node,
	 *  Use head to traverse the linked list till head reaches null, return prev.
	 * Tips: You can see the pattern within the while loop
	 * 
	 * Time Complexity: O(n) one pass
	 * Space Complexity: O(1)
	 */
	public static ListNode reverse1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null, next;
		while (head != null) {
			next = head.next; //抓住绳子，记下head的下一个节点
			head.next = prev;
			prev = head;	//这两步为实际的指针移动
			head = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Reverse Linked List Driver ***");
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
		System.out.print("The given linked list after reverse is: ");
		ll.displayLinkedList(reverse1(head)); /* Toggle solutions */
	}
}