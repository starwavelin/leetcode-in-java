package singlyLinkedList;

import java.util.Scanner;

public class InsertIntoSortedList {

	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ "Insert an Element into A Sorted Linked Driver ***");
		
		LinkedList ll = new LinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n"
				+ "in Ordered Sequence, and \n"
				+ "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			
			ll.insertLast(testArray[i]);
		}		
		ll.displayLinkedList();
		
		System.out.print("Enter an integer you wanna insert into the "
				+ "list you just created: ");
		int valToInsert = sc.nextInt();
		
		
		Node head = ll.getHead();
		Node newHead = insertIntoSortedList(head, valToInsert);
		ll.displayLinkedList(newHead);
	}
	
	public static Node insertIntoSortedList(Node head, int val) {
		Node node = new Node(val);
		// Case 1: empty list
		if (head == null) {
			head = node;
			return head;
		}
		
		// Case 2: non-empty list with only one element
		if (head.next == null) {
			if (node.data <= head.data) {
				node.next = head;
				head = node;
			} else {
				head.next = node;
			}
			return head;
		}
		
		// Case 3: non-empty list with at least 2 elements already
		if (node.data <= head.data) {
			node.next = head;
			head = node;
		} else {
			Node p1 = head;
			Node p2 = p1.next;
			while (p2.next != null) {
				if (node.data > p1.data && node.data <= p2.data) {
					p1.next = node; 
					node.next = p2;
				}
				p1 = p1.next;
				p2 = p1.next;
			}
			if (node.data > p1.data && node.data <= p2.data) {
				p1.next = node; 
				node.next = p2;
			} else if (node.data > p2.data) {
				p2.next = node;
			}
		}
		return head;
	}
}
