package singlyLinkedList;

import java.util.Scanner;

public class PartitionList {
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ "Partition List Driver ***");
		
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
		
		System.out.print("Input an integer that you want to be the pivot: ");
		int num = sc.nextInt();
		
		Node head = ll.getHead();
		
		System.out.print("The given linked list after reverse is: ");
		Node newHead = partition(head, num);
		ll.displayLinkedList(newHead);
	}
	
	public static Node partition(Node head, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		Node dummyLeft = new Node(-1);
		Node dummyRight = new Node(-1);
		Node left = dummyLeft, right = dummyRight;
		while (head != null) {
			if (head.data < n) {
				left.next = head;
				left = left.next;
			} else {
				right.next = head;
				right = right.next;
			}
			head = head.next;
		}
		right.next = null;
		left.next = dummyRight.next;
		return dummyLeft.next;
	}
	
}
