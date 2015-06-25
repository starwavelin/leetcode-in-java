package singlyLinkedList;

import java.util.Scanner;

/**
 * 
 * http://www.lintcode.com/en/problem/reverse-linked-list-ii/
 *
 */

public class ReverseLinkedListII {
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ "Reverse Linked List II Driver ***");
		
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
		System.out.print("Give the starting point of reverse: ");
		int m = sc.nextInt();
		System.out.print("Give the ending point of reverse: ");
		int n = sc.nextInt();
		
		Node head = ll.getHead();
		
		System.out.print("The given linked list after reverse is: ");
		Node newHead = reverse(head, m, n);
		ll.displayLinkedList(newHead);
	}
	
	/**
	 * 
	 * @param head: the original head of the list
	 * @param m: starting point to do the reverse
	 * @param n: ending point to do the reverse
	 * @return the new head of the new linked list after reverse
	 */
	public static Node reverse(Node head, int m, int n) {
		if (m >= n || head == null) {
			return head;
		}
		
		Node dummy = new Node(-1);
		dummy.next = head;
		head = dummy;
		for (int i = 1; i < m; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		
		// Mark involved nodes
		Node premNode = head;
		Node mNode = head.next;
		Node nNode = mNode;
		Node postnNode = mNode.next;
		for (int i = m; i < n; i++) {
			if (postnNode == null) {
				return null;
			}
			Node tmp = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;
			postnNode = tmp;
		}
		premNode.next = nNode;
		mNode.next = postnNode;
		return dummy.next;
	}
}
