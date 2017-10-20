package math;

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
* meta        : tag-array, tag-math
***************************************************************************/
public class PlusOne {

	/**
	 * Solution 1:
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
		/* 优化： 在Java中，初始化一个Array后，每个格子自动赋值0， 所以，下面这个for loop累赘了*/
//		for (int i = 1; i < res.length; i++) {
//			res[i] = 0;
//		}
		return res;
	}
	
	/**
	 * Solution 2:
	 * Instead of looking into each digit and see if it is 9, we can deal with carry (进位数) in this problem.
	 * For this problem, since the number being added and the number could be carried on is both 1, we can use one var
	 * carry to represent them. 
	 * We still want to traverse the digits from right to left, 
	 * 	and each time when adding a carry, we calculate the current sum and the carry
	 * 		if carry is 0, return the array;
	 * 		if not, continue with the array to calculate next sum and the new carry
	 * Similar to solution 1, if the for loop finishes execution without returning the function, we encounter the all-9s case
	 * 	just open a new space of a new array of size nums.length + 1 and sets its significant digit to be 1.
	 * 
	 * Time Complexity: O(n) cuz we may traverse the whole array
	 * Space Complexity: O(n) cuz we may open a new space
	 */
	public static int[] plusOne2(int[] nums) {
		int carry = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			int sum = nums[i] + carry;
			nums[i] = sum % 10;
			carry = sum / 10;
			/* Once carry is 0 we can return the nums, so put this checking right after sum, nums[i] and carry calculations */
			if (carry == 0) { 
				return nums;
			}
		}
		int[] res = new int[nums.length + 1];
		res[0] = carry;
		return res;
	}
	
	/**
	 * Creative problem, N is a 0-9 digit | 变种题，N 为单位数数字
	 * The following solution again let N serve as the number being added, and the carry.
	 * Time Complexity O(n)
	 * Space Complexity O(n)
	 */
	public static int[] plusN(int[] nums, int N) {
		for (int i = nums.length - 1; i >= 0; i--) {
			int sum = nums[i] + N;
			nums[i] = sum % 10;
			N = sum / 10;
			if (N == 0) {
				return nums;
			}
		}
		int[] res = new int[nums.length + 1];
		res[0] = 1;
		/* It is plus N now, so besides the leftmost significant digit is 1,
		 * the digits on the right may not be all 0s.
		 * Instead, we should copy the partial results from nums into res. */
		for (int i = 1; i < res.length; i++) {
			res[i] = nums[i - 1];
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
//		System.out.println("Array [0] plus one becomes " + displayArray(plusOne(new int[]{0})));
//		System.out.println("Array [1, 9] plus one becomes " + displayArray(plusOne(new int[]{1, 9})));
//		System.out.println("Array [9, 9] plus one becomes " + displayArray(plusOne(new int[]{9, 9})));
//		
		System.out.println("Array [0] plus one becomes " + displayArray(plusOne2(new int[]{0})));
		System.out.println("Array [1, 9] plus one becomes " + displayArray(plusOne2(new int[]{1, 9})));
		System.out.println("Array [9, 9] plus one becomes " + displayArray(plusOne2(new int[]{9, 9})));
		

		System.out.println("Array [0] plus 9 becomes " + displayArray(plusN(new int[]{0}, 9)));
		System.out.println("Array [1, 9] plus 9 becomes " + displayArray(plusN(new int[]{1, 9}, 9)));
		System.out.println("Array [9, 9] plus 9 becomes " + displayArray(plusN(new int[]{9, 9}, 9)));
		System.out.println("Array [1, 0, 9] plus 9 becomes " + displayArray(plusN(new int[]{1, 0, 9}, 9)));
	}
}
