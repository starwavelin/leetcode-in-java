package array;
/***************************************************************************
* Problem No. : 
* Problem Name: Get the 2nd smallest number in an array
* Problem URL : 
* Date        : Jan 2 2018
* Author      : Xian Lin
* Notes       : 
* 	Scenario: 
* 		
* 	Assumption:
* 		1. Need to clarify with the person giving out this question, 
* 		does the given array have duplication, esp duplication on the smallest one?
* 		If it has duplication on the smallest number, what counts as the 2nd smallest number?
* 		ie. [-1, -1, 0, -1, 2] surely the smallest number is -1. Then what is the 2nd smallest.
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
* meta        : tag-array, tag-two-pointers
***************************************************************************/
public class SecondSmallest {
	
	public static class Sol {
		/*
		 * 关键点：
		 * 	Loop中的第一个条件判断： second = first; 再去update first.
		 * 	second要紧跟first.
		 * 
		 * Following the Assumption part above, duplication is allowed.
		 * And in a given array like [-1, -1, 0, -1, 2], the 2nd smallest number is 0.
		 * 
		 * This denies solutions like using Heap or directly sort the given array.
		 * 
		 * If there is no 2nd smallest integer in the array, we return Integer.MAX_VALUE as an indicator.
		 * 
		 * Idea:
		 * 	traverse the array once,
		 * 	如果某元素小于smallest, secSmallest = smallest, smallest = 当前元素
		 * 	如果某元素大于smallest 但小于 secSmallest, update secSmallest to 当前元素
		 * */
		public int get2ndSmallest(int[] nums) {
			if (nums == null || nums.length == 0) {
				return Integer.MAX_VALUE;
			}
			int smallest = Integer.MAX_VALUE, secSmallest = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] < smallest) {
					secSmallest = smallest; 
					smallest = nums[i];
				} else if (nums[i] > smallest && nums[i] < secSmallest) {
					secSmallest = nums[i];
				}
			}
			return secSmallest;
		}
	}
	
	public static void main(String[] args) {
		Sol s = new Sol();
		int[] nums1 = new int[]{1, 1, 1}; // should return Integer.MAX_VALUE
		int[] nums2 = new int[]{3, 8, 9, -1, -1}; // should return 3
		int[] nums3 = new int[]{4, -18, 9, 5, 4}; // should return 4
		System.out.println("The 2nd smallest number is: " + s.get2ndSmallest(nums1));
		System.out.println("The 2nd smallest number is: " + s.get2ndSmallest(nums2));
		System.out.println("The 2nd smallest number is: " + s.get2ndSmallest(nums3));
	}
	
}
