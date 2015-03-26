package singlyLinkedList;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedLinkedList {
	
	public static void main(String[] args) {
		
		System.out.println("*** Welcome to Ben's "
				+ "Remove Duplicates From A Sorted Linked List Driver ***");

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
		
		
		Node head = ll.getHead();
		Node newHead = deleteDuplicates(head);
		ll.displayLinkedList(newHead);
	}
	
	
	public static Node deleteDuplicates(Node head) {
		if (head == null) {
			return null;
		}
		Node node = head;
		while (node.next != null) {
			if (node.data == node.next.data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}
	
}
