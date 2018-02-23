package linkedList;

import utility.ListNode;
/***************************************************************************
* Problem No. : 234
* Problem Name: Palindrome Linked List
* Problem URL : https://leetcode.com/problems/palindrome-linked-list/description/
* Date        : Feb 23 2018
* Author      : Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a singly linked list, determine if it is a palindrome.
* 	Assumption:
* 		1. A list can be a null list.
	Example:
* 	Input:	
* 	Output: boolean value
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-linked-list
***************************************************************************/
public class IsPalindrome {

	/**
	 * Solution 1: Time Complexity O(n) Space Complexity O(1) solution
	 * Reverse Linked Lis Code Snippet is used inside this solution
	 */
	private static class Solution {
		public boolean isPalindrome(ListNode head) {
	        if (head == null || head.next == null)
	            return true;
	        ListNode fast = head, slow = head;
	        while (fast.next != null && fast.next.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        
	        // reverse the remaining linkedlist from slow.next to the end node
	        slow.next = reverse(slow.next);
	        
	        ListNode pre = head;
	        while (slow.next != null) {
	            slow = slow.next;
	            if (pre.data != slow.data)
	                return false;
	            pre = pre.next;
	        }
	        return true;
	    }
	    
	    private ListNode reverse(ListNode cur) {
	        if (cur.next == null) {
	            return cur;
	        }
	        ListNode prev = null, next = null;
	        while (cur != null) {
	            next = cur.next;
	            cur.next = prev;
	            prev = cur;
	            cur = next;
	        }
	        return prev;
	    }
	}
}
