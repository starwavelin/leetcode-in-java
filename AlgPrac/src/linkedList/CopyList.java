package linkedList;

import java.util.Scanner;

import utility.LinkedList;
import utility.ListNode;
/***************************************************************************
* Problem No. : 
* Problem Name: Copy List
* Problem URL : The Pre-requisite question of Copy List with Random Pointer
* Date        : Oct 30 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a linked list, make a deep copy of it and return the head of the deep-copied new linked list.
* 	Assumption:
* 		1. Singly linked list
	Example:
* 	Input: 5->2->6
* 	Output: Copied 5->2->6 return Node 5
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-linked-list, tag-two-pointers
***************************************************************************/
public class CopyList {

	/**
	 * Solution 1: Iterative Solution
	 * 	Use head pointer to traverse the original list, and when traversing the original list,
	 * use cur and next pointers to form the deep copied list.
	 * 
	 * Time Complexity: O(n) - traverse the original list once
	 * Space Complexity: O(n) - the newly formed list should be the same size as the original list
	 * 
	 * 关键点：对于新链表，先要做出nextNode, 再连接，移cur, 原链表指针的移动是最后进行的。
	 */
	public static ListNode copy1(ListNode head) {
		if (head == null) {
			return null;
		}
		//Copy the first node first
		ListNode newH = new ListNode(head.data);
		ListNode cur = newH;
		ListNode next;
		//Copy the following nodes if exist //口诀：做nextNode,连cur与next,cur指next,移原指针。
		while (head.next != null) {
			next = new ListNode(head.next.data);
			cur.next = next;
			cur = next;
			head = head.next;
		}
		return newH;
	}
	
	/**
	 * Solution 2: Recursive Solution
	 * 	Form the current node and then recursively call copy function to form cur's next node.
	 * 
	 * Space Complexity: O(n) -- recursion stack
	 * Time Complexity: O(n)
	 */
	public static ListNode copy2(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = new ListNode(head.data);
		cur.next = copy2(head.next);
		return cur;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Copy List Driver ***");
		LinkedList ll = new LinkedList();
		Scanner sc = new Scanner(System.in);
		
		/* Test Solutions */
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			ll.insertLast(testArray[i]);
		}
		System.out.print("The original list: ");
		ll.displayLinkedList();
		ListNode head = ll.getHead();
		ListNode newHead = copy2(head); /* Toggle here to test between solutions */
		System.out.print("The deep copied list: ");
		ll.displayLinkedList(newHead);
	}
}