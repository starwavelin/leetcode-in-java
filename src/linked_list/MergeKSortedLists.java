package linked_list;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;

import utility.LinkedList;
import utility.ListNode;
/***************************************************************************
* Problem No. : 23
* Problem Name: Merge k Sorted Lists
* Problem URL : https://leetcode.com/problems/merge-k-sorted-lists/description/
* Date        : Oct 31 2017
* Author      :	@codingbro
* Notes       : 
* 	Scenario: 
* 		Merge k sorted linked lists and return it as one sorted list.
* 	Assumption:
* 		1. A list can be a null list.
	Example:
* 	Input:	2->4->null
* 			3->null
* 			1->null
* 	Output: 1->2->3->4->null
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-linked-list, tag-priority-queue
***************************************************************************/
public class MergeKSortedLists {

	/**
	 * Solution: 
	 * 	We need a data structure to compare k heads and remove the minimum head among k, and append
	 * this removed head into the new sorted linkedlist. When a head is moved from one list, we want its next node
	 * to be pushed in to be the new head to join the comparison until such a list is empty.
	 * 	minHeap is the data structure we are looking for, and it is implemented via PriorityQueue in Java.
	 * 
	 * Time Complexity: O(nk) -- each list has average size of n, and k lists
	 * Space Complexity: O(k) -- the size of priority queue
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		/* form the min heap */
		Queue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> ( a.val - b.val ));
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {	//注意checking condition，一个list可能一开始就是null
				minHeap.offer(lists[i]);
			}
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (!minHeap.isEmpty()) {	//the following steps similar to CopyList
			ListNode node = minHeap.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null) {	//fill in the list heads that are gonna be compared
				minHeap.offer(node.next);
			}
		}
		return dummy.next;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Merge K Sorted Lists Driver ***");
		Scanner sc = new Scanner(System.in);
		
		/* Maybe I need to use something like Thread.wait() to make sure 
		 * the list formation code executes after user input some integers. For the timing, I gave up for now. */
		/*
		System.out.print("How many lists you want to create: ");
		int numLists = sc.nextInt();
		
		LinkedList[] lists = new LinkedList[numLists];
		ListNode[] listHeads = new ListNode[numLists]; //listHeads is the argument being used in mergeKLists()
		
		for (int k = 0; k < numLists; k++) {
			lists[k] = new LinkedList(); // array of object type, each element needs initialization
			System.out.print("Input your integer array, leave each number by space: ");
			String[] strs = sc.next().split(" ");
			int[] testArray = new int[strs.length];
			for (int i = 0; i < strs.length; i++) {
				testArray[i] = Integer.parseInt(strs[i]);
				lists[k].insertLast(testArray[i]);
			}
			listHeads[k] = lists[k].getHead();
		}
		*/
		
		LinkedList[] lists = new LinkedList[3];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList();
		}
		/* 如果上面的lists array每个元素的初始化过程改为Iterable的简化初始化过程
		 * for (LinkedList l : lists) {
		 * 	l = new LinkedList();
		 * }
		 * 则下面的给每个特定元素插入Node的过程会出 java.lang.NullPointerException, 
		 * 要用传统的loop counter i 赋值法。
		 * */
		lists[0].insertLast(2);
		lists[0].insertLast(4);
		lists[1].insertLast(3);
		lists[2].insertLast(1);
		
		ListNode[] listHeads = new ListNode[lists.length];
		for (int i = 0; i < listHeads.length; i++) {
			listHeads[i] = lists[i].getHead();
		}
		System.out.print("\nThe newly formed sorted list will be: ");
		new LinkedList().displayLinkedList(mergeKLists(listHeads));
	}
}
