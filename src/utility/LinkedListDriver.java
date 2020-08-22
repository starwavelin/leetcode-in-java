package utility;

import java.util.Scanner;

public class LinkedListDriver {

	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's LinkedList Driver ***");

		LinkedList linkedlist = new LinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n"
				+ "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
			
			linkedlist.insertLast(testArray[i]);
		}		
		linkedlist.displayLinkedList();
		
		System.out.print("Input a num to be inserted at head: ");
		int numAtHead = sc.nextInt();
		linkedlist.insertFirst(numAtHead);		
		linkedlist.displayLinkedList();
		
		System.out.println("Try remove Last twice!");
		linkedlist.removeLast();
		linkedlist.removeLast();		
		linkedlist.displayLinkedList();
		
		System.out.println("Try remove First once!");
		linkedlist.removeFirst();
		linkedlist.displayLinkedList();
		
		System.out.print("Ok. Enough!");
	}
}
