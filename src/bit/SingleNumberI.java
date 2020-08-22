package bit;

import java.util.Scanner;
/**
 * LeetCode 136. Single Number
 * https://leetcode.com/problems/single-number/description/
 * 
 * LintCode
 * http://www.lintcode.com/en/problem/single-number/
 * 
 * The properties of XOR;
 * 1. a ^ b = c => a ^ c = b, b ^ c = a
 * 2. a ^ a = 0 
 * 3. a ^ 0 = a
 * 4. (a ^ b) ^ c = a ^ (b ^ c)
 */

public class SingleNumberI {
	
	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int res = 0;
		for (int n : nums) {
			res = res ^ n;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Single Number I Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int result = singleNumber(testArray);
		System.out.println("The single number in your given int array is " + result);
	}
	
}
