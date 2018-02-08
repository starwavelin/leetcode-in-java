package sorting;

/***************************************************************************
* Problem No. : 88
* Problem Name: Merge Sorted Array
* Problem URL : https://leetcode.com/problems/merge-sorted-array/description/
* Date        : Oct 18 2017
* Author      : Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
* 	Assumption:
* 		1. Are nums1 and nums2 already sorted? YES, the question says "two sorted array".
* 		*2. Does nums1 have enough space to hold elements from nums2? YES, you can assume this.
* 		3. Are there any duplicate elements in nums1 or nums2? This doesn't matter.
* 		*4. Could I open a new space to merge these two arrays then let nums1 reference to this new space?
* Or, do I have to in-place move elements from nums2 to nums1? 
* 			You can do non-in-place solution first, then the in-place solution.
	Example:
* 	Input: 
* 		nums1: [-1, 1, 2, 4]	m=4 (# of elements initialized in nums1, NOT nums1's length!!)
* 		nums2: [-3, 0, 1, 4, 9]	n=5 
* 	Output:
* 		nums1: [-3, -1, 0, 1, 1, 2, 4, 4, 9]
* 		nums2: [-3, 0, 1, 4, 9]
*  
* 	Data Structure and Alg:
* 		See code comments
* 		  
* Complexity  : 
* 	Time Complexity: O() -- See code comments
* 	Space Complexity: O() -- See code comments
* 
* meta        : tag-array, tag-two-pointers
* 
* Note: Merge K Sorted Arrays will use PriorityQueue
***************************************************************************/
public class MergeSortedArray {
	
	/**
	 * Solution 1:
	 * In-place merge integers into nums1, 3 pointers, i for nums1, j for nums2, k for starting writing point of nums1.
	 * i and j starts from the end element of nums1 and nums2, respectively. k starts from the m+n-1 index of nums1
	 * 
	 * Core Alg:
	 * 	Compare nums1[i] and nums2[j], the larger one should be written to nums1[k], then the corresponding index-- and k--.
	 * 	Do this till one int array is empty, 
	 * 		if the int array being empty is nums1, copy the elements left in nums2 onto nums1;
	 * 		else the elements left are in nums1 and since nums1 is already sorted, done. 
	 * 
	 * Time Complexity: O(m+n)
	 * Space Complexity: O(1) - just declare an extra scanner
	 */
	public static class Solution1 {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			if (m <= 0 && n <= 0) {
				return;
			}
			int k = m + n -1;
			m--; n--;
			while (m >= 0 && n >= 0) {
				nums1[k--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
			}
			// Deal with the case we have elements left in nums2 didn't merge into nums1
			while (n >= 0) {
				nums1[k--] = nums2[n--];
			}
		}
	}
	
	/**
	 * Solution 2:
	 * 利用归并排序中的merge arrays代码块，然后把merge完的结果赋值回nums1.
	 */
	public static class Solution2 {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			if (m <= 0 && n <= 0) {
				return;
			}
			int[] tmp = new int[m + n];
			int i = 0, j = 0, k = 0;
			
			/* 归并排序 mergeArray 部分代码块 */
			while (i < m && j < n) {
				tmp[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
			}
			while (i < m) {
				tmp[k++] = nums1[i++];
			}
			while (j < n) {
				tmp[k++] = nums2[j++];
			}
			
			//Assign values from tmp back to nums1
			for (int c = 0; c < tmp.length; c++) {
				nums1[c] = tmp[c];
			}
		}
	}
	
	public static void main(String[] args) {
		Solution1 sol1 = new Solution1();
		Solution2 sol2 = new Solution2();
		
		int[] nums1 = new int[18];
		int[] nums2 = new int[]{-3, 0, 1, 4, 9};
		nums1[0] = -1; nums1[1] = 1; nums1[2] = 2; nums1[3] = 4;
		sol2.merge(nums1, 4, nums2, 5);	//Toggle here to switch methods
		System.out.print("Now nums1 becomes: ");
		for (int i = 0; i < 4+5; i++) {
			System.out.print(nums1[i] + " "); //expect -3, -1, 0, 1, 1, 2, 4, 4, 9
		}
		
		nums1 = new int[10];
		nums1[0] = -2; nums1[1] = 25;
		sol2.merge(nums1, 2, nums2, 5); //Toggle here to switch methods
		System.out.print("\nNow nums1 becomes: ");
		for (int i = 0; i < 2+5; i++) {
			System.out.print(nums1[i] + " "); //expect -3, -2, 0, 1, 4, 9, 25 
		}
		
		nums1 = new int[10];
		nums1[0] = -7; nums1[1] = 11;
		sol2.merge(nums1, 2, nums2, 5); //Toggle here to switch methods
		System.out.print("\nNow nums1 becomes: ");
		for (int i = 0; i < 2+5; i++) {
			System.out.print(nums1[i] + " "); //expect -7, -3, 0, 1, 4, 9, 11 
		}
	}
}
