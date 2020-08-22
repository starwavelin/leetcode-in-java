package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/***************************************************************************
* Problem No. : 239
* Problem Name: Sliding Window Maximum
* Problem URL : https://leetcode.com/problems/sliding-window-maximum/description/
* Date        : Dec 15 2017
* Author      :	@codingbro
* Notes       :
* 	Scenario:
*
* 	Assumption:
* 		1.
	Example:
* 	Input:
* 	Output:
*
* 	Data Structure and Alg:
* 		See Code Comments
* Complexity  :
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
*
* meta        : tag-array, tag-two-pointers, tag-deque
***************************************************************************/

public class SlidingWindowMaximum {

	/**
	 * Solution 1:
	 * Nested for loop two pointers solution.
	 * O(n^2)
	 */
	public static int[] maxSlidingWindow1(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int n = nums.length;
		int[] res = new int[n - k + 1]; //we can calculate the size of the result array

		for (int i = 0; i + k <= nums.length; i++) {
			int max = nums[i];
			for (int j = i; j < i + k; j++) {
				if (nums[j] > max) {
					max = nums[j];
				}
			}
			res[i] = max;
		}
		return res;
    }

	/**
	 * Solution 2:
	 * Solution 1 has some repeated calculations which can be optimized,
	 * 	ie. input = [1, 3, 5, 2, 1] k = 3, from [1, 3, 5], we know the max is 5;
	 * then from [3, 5, 2] Sol 1 still starts with max = 3, is there a way to let 5 being noted and just compare 5 with the newly
	 * added element 2?
	 *
	 * 既是要时复为O(n)，则要每次以O(1)找到range k中的最大值
	 * So, Solution 2 is
	 * 	保证deque的头永远是最大值, deque内存有的数字一定是降序。
	 * 	Deque里面存的是index,处理越界方便。
	 *
	 * 解释时间复杂度为什么是O(n)?
	 * 	在deque的入、出操作中，每个元素最多被touch 2次（进deque和出deque）
	 * 	O(2n) = O(n)
	 * 为什么只能用Deque而不能用Queue？
	 * 	因为既要有pollLast() 也要有pollFirst(),
	 * 	ie. 5， -1， 4， when 4 comes in we wanna pop out -1 in which we use pollLast()
	 */
	public static int[] maxSlidingWindow2(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return new int[0];
		}

		int n = nums.length;
		int[] res = new int[n - k + 1];
		int index = 0; //res index

		Deque<Integer> q = new ArrayDeque<>(); // use deque to store index of each number
		for (int i = 0; i < n; i++) {
			// remove the head of the q if it is out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.pollFirst();
			}

			// remove smaller number in range k from the end of the deque
			// when newly added nums[i] is greater than the number at the end of the deque
			while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
				q.pollLast();
			}

			// deque contains the index of elements and deque's head contains the index of the max
			// res contains the content. When i >= k-1 we start to fill the res
			q.offer(i);
			if (i >= k - 1) {
				res[index++] = nums[q.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, -1, -3, 5, 3, 4, 7};
		int k = 3;
		int[] res = maxSlidingWindow2(nums, k); //toggle here to change methods
		System.out.print("The max sliding window is: ");
		for (int i : res) {
			System.out.print(i + " "); //should output 3 3 5 5 5 7
		}

		nums = new int[] {5, 3, 2, -1, 6, 11};
		res = maxSlidingWindow2(nums, k); //toggle here to change methods
		System.out.print("The max sliding window is: ");
		for (int i : res) {
			System.out.print(i + " "); //should output 5 3 6 11
		}
	}
}
