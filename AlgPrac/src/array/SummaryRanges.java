package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utility.ListUtil;
/***************************************************************************
* Problem No. : 228
* Problem Name: Summary Ranges
* Problem URL : https://leetcode.com/problems/summary-ranges/description/
* Date        : Oct 31 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a sorted integer array without duplicates, return the summary of its ranges.
* 	Assumption:
* 		1. Integers in the array can be negative.
* 		2. Array is sorted
* 		3. No duplicate integers
* 		4. The given integer can be in the range [Integer.MIN_VALUE, Integer.MAX_VALUE] inclusively.
* 			[-2,147,483,648, 2,147,483,647]
	Example:
* 	Input/Output: 
* 		Input: [0,2,3,4,6,8,9]
		Output: ["0","2->4","6","8->9"]
* 	Data Structure and Alg:
* 		User two pointers one pass;
*  		two pointers var cur and pointer i.
*  		  cur starts from nums[i], i moves gradually
*  		The comparisons between nums[i+1] and nums[i] is one of the key points of when to summary range.
*  		After dealing with defensive checking on 0 elements and 1 element in nums,
*  		The general case comes in :
*  			i starts with index 0 and cur starts with nums[0], use i to traverse the while loop.
*  			Core question, when to summary a range?
*  				1. when index i reaches the last index
*  				2. when the difference between nums[i + 1] and nums[i] is greater than 1
*  				3. when nums[i + 1] is positive and nums[i] is negative -- this case is to handle the overflow of 
*  					the difference of two numbers whose absolute values are large
*  					ie. (2147483647 - (-2147483647)) will give you -2 in Java, due to overflow
*  				当确定要Summary的时候，就剩两种情况：summary单个数，还是Summary一个范围。这两种情况通过nums[i]与cur的比较而获得。
*  			Then update cur to i+1 if i+1 is within the index range after finishing a range summary.
*  		Return the result.
*  
* Complexity  : 
* 	Time Complexity: O(n) -- traverse the given array one pass
* 	Space Complexity: O(1) -- Just two extra pointers
* 
* meta        : tag-array, tag-two-pointers, tag-google
* 
* Pain Point: 1. handle the overflow of the difference of two numbers whose absolute values are very large
***************************************************************************/
public class SummaryRanges {
	/**
	 * Note: the slow pointer chasing the fast pointer.
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1) {
			res.add(nums[0] + "");
			return res;
		}
		int i = 0, cur = nums[0];
		while (i < nums.length) {
			if ((i + 1 == nums.length) || (nums[i + 1] - nums[i] >= 2) || (nums[i+1] > 0 && nums[i] < 0) ) { 
					//(nums[i+1] > 0 && nums[i] < 0) to handle overflow of two large subtraction like 2147483647 - (-2147483647) which gives us -2 in Java
				if (nums[i] == cur) {
					res.add(cur + "");
				} else {
					res.add(cur + "->" + nums[i]);
				}
				if (i + 1 < nums.length) { //only update cur after a summary
					cur = nums[i + 1];
				}
			}
			i++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Summary Ranges Test ***");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		ListUtil.display(summaryRanges(testArray));
		
		//System.out.println(2147483647 + 2147483647);
	}
}
