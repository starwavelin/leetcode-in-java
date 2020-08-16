package stack;

/***************************************************************************
* Problem No. : 
* Problem Name: 
* Problem URL : 
* Date        : Oct 15 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 1. Use Array to implement a queue, rotation is enabled.
* 
* 
* meta        : tag-queue
***************************************************************************/
public class Queue {
	public static class ArrayQueue {
		int[] arr;
		int first; // the pointer for dequeuing the first element of the queue
		int last; // the pointer for enqueuing an element into the queue
		int size; // record the current size of the queue
		private final int MAX_SIZE = 4;
		
		public ArrayQueue() {
			arr = new int[MAX_SIZE];
			first = last = size = 0;
		}
		
		/**
		 * only move the last pointer
		 * @param val the element to be pushed into the queue
		 */
		public void enqueue(int val) {
			if (size == MAX_SIZE) {
				throw new ArrayIndexOutOfBoundsException("Array is full so cannot enqueuing.");
			}
			arr[last++] = val;
			size++;
			last = (last == MAX_SIZE) ? 0 : last;
		}
		
		/**
		 * only move the first pointer when dequeuing
		 * @return the element being dequeued.
		 */
		public Integer dequeue() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("Array is empty so no dequeuing.");
			}
			int elementToPoll = arr[first++];
			size--;
			first = (first == MAX_SIZE) ? 0 : first;
			return elementToPoll;
		}
		
		public Integer peek() {
			return arr[first];
		}
		
		public void displayQueue() {
			System.out.println("\nThe queue is: ");
			int tmpIndex = first;
			int count = size;
			while (count > 0) {
				tmpIndex = (tmpIndex == MAX_SIZE) ? 0 : tmpIndex;
				System.out.print(arr[tmpIndex++] + " ");
				count--;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Queue implemented by Array Test ***");
		ArrayQueue q = new ArrayQueue();
		
		q.enqueue(4);
		q.enqueue(1024);
		q.enqueue(18);
		q.enqueue(-5);
		q.displayQueue(); // should display 4, 1024, 18, -5
//		System.out.println("\nDEBUG now last is: " + q.last + " and first is: " + q.first);
		
		q.dequeue();
		q.dequeue();
		q.enqueue(-37);
		System.out.println("\nThe head of the queue is: " + q.peek()); // should be 18
		q.displayQueue(); // should be 18, -5, -37;
		System.out.println("\nThe size of the queue is: " + q.size); // should be 3
//		System.out.println("\nDEBUG now last is: " + q.last + " and first is: " + q.first);

		q.enqueue(7799);
		q.displayQueue(); // should be 18, -5, -37, 7799;
		System.out.println("\nThe size of the queue is: " + q.size); // should be 4
	}
}
