package sorting;

/***************************************************************************
* Problem No. : 
* Problem Name: Array Partition
* Problem URL : 
* Date        : Oct 25 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an integer array and an integer k, I want you to partition the array such that all the
* 		integers < k will be moved to the left, and all the integers >= k will be moved to the right.
* 	Assumption:
* 		1. k may not exist in the given array
* 		2. You don't need to preserve the relative order of integers < k or >= k
	Example:
* 	Input/Output: 
* 		Input nums array: [9, 3, -1, 12, 5] k=8
* 		One possible Output nums array: [3, -1, 5, 9, 12]
* 	Data Structure and Alg:
* 		see code comments  
* Complexity  : 
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
* 
* meta        : tag-sort, tag-two-pointers, tag-array
***************************************************************************/
public class ArrayPartition {
	/* This is actually testing your understanding of the partition module of quicksort 
	 * I am gonna present two naive solutions requiring O(n) space first, then the in-place solutions */
	
	/**
	 * Solution 1:
	 *  Open a new array of size n, use 2 pointers in total and total 4 passes (explaind below).
	 *  1st pass: use the pointer of the original nums array to traverse and record elements < k and copy them into new array
	 *  2nd pass: use the pointer again to copy elements >= k into the new array
	 *  3rd pass: is the new array formation pass
	 *  4th pass: copy every element from new array back to nums
	 * Time Complexity: O(n) 
	 * 		-- but 2 passes of traverse the original array, and 1 pass of forming the new array, and
	 * 		1 pass for copying helpArray data back to nums array (cuz this is Java and you can't directly update reference and return)
	 * Space Complexity: O(n)
	 */
	public static void partition1(int nums[], int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int[] helpArray = new int[nums.length];
		int i = 0, j = 0; // i is the pointer for the nums array and j pointer of the helpArray
		for (; i < nums.length; i++) {
			if (nums[i] < k) {
				helpArray[j++] = nums[i];
			}
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] >= k) {
				helpArray[j++] = nums[i];
			}
		}
		for (i = 0; i < nums.length; i++) {
			nums[i] = helpArray[i];
		}
	}
	
	/**
	 * Solution 2:
	 *  Open a new array of size n, use 3 pointers in total and total 3 passes (explaind below).
	 *  1st pass: set two pointers left and right for helpArray, at start and end positions at the beginning.
	 *  	use a 3rd pointer i for the original nums array to traverse 
	 *  	if nums[i] < k, copy it to new array[l] and l++;
	 *  	else , copy it to new array[r] and r--
	 *  	thru this one pass traversal of the nums array, the new array can be formed per our goal.
	 *  2nd pass: the new array formation pass
	 *  3nd pass: copy every element from new array back to nums
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public static void partition2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int[] helpArr = new int[nums.length];
		int l = 0, r = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				helpArr[l++] = nums[i];
			} else {
				helpArr[r--] = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = helpArr[i];
		}
	}
	
	/* In-place solutions:
	 * 	And I want to return the index of the first number that is >= k */
	
	/**
	 * Solution 3:
	 * 	Use two pointers, starting from the two ends of nums array.
	 * while (l <= r)
	 * 	if nums[l] < k, l++
	 * 	if nums[r] >= k, r--
	 * 	otherwise, if l is still less than or equal to r,  we swap nums[l] and nums[r] then have l++ and r--
	 * return l cuz when the while loop finishes, l will be pointing to the 1st element that is greater than or equal to k
	 */
	public static int partition3(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			while (l < nums.length && nums[l] < k) { // this is different from partition ftn in quicksort cuz k is not from the original array, so we need condition "l < nums.length"
				l++;
			}
			while (r >=0 && nums[r] >= k) {
				r--;
			}
			if (l <= r) {
				int tmp = nums[l];
				nums[l++] = nums[r];
				nums[r--] = tmp;
			}
		}
		return l;
	}
	
	/**
	 * Solution 4: 算法导论里的思路
	 * 	Two pointers but using left pointer chasing right pointer approach.
	 * l = -1, r = 0;
	 * while (l < nums.length)
	 * 	if (nums[r] < k), then l++, swap nums[l] and nums[r]
	 * 	otherwise just r++
	 * after while loop finishes, l+1 is the index of the first element that is greater than or equal to k
	 * 
	 * I think this solution has one better point than Solution 3 that I don't need to check l < nums.length or r > nums.length in the while loops, if the given k is not from the original array.
	 * 而且代码行数 < Solution 3。
	 */
	public static int partition4(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = -1, r = 0;
		while (r < nums.length) {
			if (nums[r] < k) {
				l++;
				int tmp = nums[l];
				nums[l] = nums[r];
				nums[r] = tmp;
			}
			r++;
		}
		return l + 1;
	}
	
	public static void displayArray(int[] nums) {
		System.out.print("\nThe array after partition becomes: ");
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{9, 3, -1, 12, 5};
		int k = 8;
		
		/* Solution 1 */
		System.out.print("Solution 1");
		partition1(nums, k);
		displayArray(nums);
		nums = new int[]{9, 3, -1, 12, 5};
		partition1(nums, 16); // test already partitioned case
		displayArray(nums);
		
		/* Solution 2 */
		System.out.print("\n\nSolution 2");
		nums = new int[]{9, 3, -1, 12, 5};
		partition2(nums, k);
		displayArray(nums);
		nums = new int[]{9, 3, -1, 12, 5};
		partition2(nums, 16); // test already partitioned case
		displayArray(nums);
		
		/* Solution 3 */
		System.out.print("\n\nSolution 3");
		nums = new int[]{9, 3, -1, 12, 5};
		int index = partition3(nums, k);
		displayArray(nums);
		System.out.println("And the first index >= k is: " + index);
		
		nums = new int[]{9, 3, -1, 12, 5};
		index = partition3(nums, 16); // test already partitioned case
		displayArray(nums);
		System.out.println("And the first index >= k is: " + index);
		
		index = partition3(nums, -16); // test already partitioned case
		displayArray(nums);
		System.out.println("And the first index >= k is: " + index);
		
		/* Solution 4 */
		System.out.print("\n\nSolution 4");
		nums = new int[]{9, 3, -1, 12, 5};
		index = partition4(nums, k);
		displayArray(nums);
		System.out.println("And the first index >= k is: " + index);
		
		nums = new int[]{9, 3, -1, 12, 5};
		index = partition4(nums, 16); // test already partitioned case
		displayArray(nums);
		System.out.println("And the first index >= k is: " + index);
		
		index = partition3(nums, -16); // test already partitioned case
		displayArray(nums);
		System.out.println("And the first index >= k is: " + index);
	}
}
