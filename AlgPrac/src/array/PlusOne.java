package array;

/***************************************************************************
* Problem No. : 66
* Problem Name: Plus One
* Problem URL : https://leetcode.com/problems/plus-one/description/
* Date        : Oct 19 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
* 	Assumption:
* 		1. Non-negative integer array. If negative integer allowed, we need to care
* 			(1) sign "-" "+" 
* 			(2) when it is negative int, then -3 + 1 = -2 
* 				so you know keep the sign and actually do minus for the digit
* 				ie. Keep the "-" sign, and the digit will be 3 - 1 = 2. 
* 		2. non-empty array, so we don't need to do the checking of nums == null || nums.length == 0
* 		3. assume no leading zeros and the most significant digit is at the head of the array.
	Example:
* 	Input/Output: 
* 		Input [0] output [1]
* 		Input [1, 9] output [2, 0]
* 		Input [9, 9] output [1, 0, 0]
* 	Data Structure and Alg:
* 		See code comments  
* Complexity  : 
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
* 
* meta        : tag-array
***************************************************************************/
public class PlusOne {

	/**
	 * (1) Handle non-all-9s case 
	 * Use a for loop to traverse every digit of the input array from right to left,
	 * if the digit is a 9, replace it with 0
	 * if the digit is a non-9 digit, increment it by 1 and return this array.
	 * (2) Handle all-9s case
	 * If this for loop finishes and we don't have the function returned when executing the for loop, it means we are having the "all digits are 9" case. 
	 * So we just open a new array of size (nums.length + 1), and sets its index 0 to be 1 and all the rest indices to be 0.
	 * 
	 * Time Complexity: O(n)  cuz we may traverse all the digits
	 * Space Complexity: O(n) cuz we may need to open a new array of size of the old array plus one.
	 */
	public static int[] plusOne(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 9) {
				nums[i] = 0;
			} else {
				nums[i]++;
				return nums;
			}
		}
		int[] res = new int[nums.length + 1];
		res[0] = 1;
		for (int i = 1; i < res.length; i++) {
			res[i] = 0;
		}
		return res;
	}
	
	private static String displayArray(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int num : nums) {
			sb.append(num + " ");
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println("Array [0] plus one becomes " + displayArray(plusOne(new int[]{0})));
		System.out.println("Array [1, 9] plus one becomes " + displayArray(plusOne(new int[]{1, 9})));
		System.out.println("Array [9, 9] plus one becomes " + displayArray(plusOne(new int[]{9, 9})));
	}
}
