package array;

/***************************************************************************
* Problem No. : 88
* Problem Name: Merge Sorted Array
* Problem URL : https://leetcode.com/problems/merge-sorted-array/description/
* Date        : Oct 18 2017
* Author	  :	Xian Lin
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
	 * Solution 2:
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
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
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
	
	/**
	 * m - # of elements initialized in nums1; 
	 * n - # of elements initialized in nums2.
	 * 
	 * Solution 1:
	 * 	result will be saved in a new array and let nums1 refer to this new array
	 * Process:
	 * Set two pointers i, j, starting from the index 0 of nums1 and nums2 respectively.
	 * when comparing nums1[i] and nums2[j], always pull the smaller one into the new array
	 * if nums1 has integers left, pull all of them into the new array; 
	 * 	otherwise it must be nums2 having integers left, pull them into the new array.
	 * 
	 * Time Complexity: O(m+n) cuz you still need to traverse both arrays
	 * Space Complexity: O(m+n) cuz you open a new array of m+n length
	 */
	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		if (m <= 0 && n<= 0) {
			return;
		}
		int[] tmp = new int[m + n];
		int i = 0, j = 0, k = 0;
		for (; k < m+n; k++) {
			if (i < m && j < n) { /* handle the simple case like ([1], 1, [], 0) */
				if (nums1[i] < nums2[j]) {
					tmp[k] = nums1[i++];
				} else {
					tmp[k] = nums2[j++];
				}
			} else if (i >= m && j < n) {
				tmp[k] = nums2[j++];
			} else if (i < m && j >= n) {
				tmp[k] = nums1[i++];
			}
		}
		
		/* Why if I just use nums1 = tmp will not give me updated nums1 after invoking this function?
		 * This is cuz Java is passed by value!! We can view it as Java replicated a handler nums1',
		 * and pass nums1' into this function, manipulate it and then let nums1' refer to a new array tmp
		 * Then, when finishing invoking this function and print the nums1 variable outside of this function 
		 * nothing changes!
		 * */
		//nums1 = tmp;
		
		/* How can we make it work? We can assign all elements from tmp to nums1', since each element 
		 * within the array changes, and nums1 and nums1' refer to the same memory allocation for the array, 
		 * nums1 will give us updated elements when retrieving it after finishing this method! */
		for (k = 0; k < m + n; k++) {
			nums1[k] = tmp[k];
		}
	}
	
	/**
	 * 当然如果不是力扣原题那么呆板，我们把return type直接设为int[]即可省去Solution 1最后的Copy O(n)步骤。
	 */
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		if (m <= 0 && n <= 0) {
			return null;
		}
		int[] tmp = new int[m + n];
		int i = 0, j = 0, k = 0;
		while (k < m + n) {
			if (i < m && j < n) {
				tmp[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
			} else if (i >= m && j < n) {
				tmp[k++] = nums2[j++];
			} else if (i < m && j >= n) {
				tmp[k++] = nums1[i++];
			}
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[18];
		int[] nums2 = new int[]{-3, 0, 1, 4, 9};
		nums1[0] = -1; nums1[1] = 1; nums1[2] = 2; nums1[3] = 4;
		merge2(nums1, 4, nums2, 5);	//Toggle here to switch methods
		System.out.print("Now nums1 becomes: ");
		for (int i = 0; i < 4+5; i++) {
			System.out.print(nums1[i] + " "); //expect -3, -1, 0, 1, 1, 2, 4, 4, 9
		}
		
		nums1 = new int[10];
		nums1[0] = -2; nums1[1] = 25;
		merge2(nums1, 2, nums2, 5); //Toggle here to switch methods
		System.out.print("\nNow nums1 becomes: ");
		for (int i = 0; i < 2+5; i++) {
			System.out.print(nums1[i] + " "); //expect -3, -2, 0, 1, 4, 9, 25 
		}
		
		nums1 = new int[10];
		nums1[0] = -7; nums1[1] = 11;
		nums1 = merge(nums1, 2, nums2, 5); //Toggle here to switch methods
		System.out.print("\nNow nums1 becomes: ");
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + " "); //expect -7, -3, 0, 1, 4, 9, 11 
		}
	}
}
