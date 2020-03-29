package bit;

import java.util.Scanner;
/**
 * LeetCode 260. Single Number III
 * https://leetcode.com/problems/single-number-iii/description/
 * 
 * Example
 * 	Input: Given nums = [1, 2, 1, 3, 2, 5]
 * 	Output: return [3, 5]
 * 
 * http://www.lintcode.com/en/problem/single-number-iii/
 * In an int array with 2n+2 numbers, only two distinct numbers occur only once, others
 * occur exactly twice. Find the two distinct numbers.
 * 
 * Method: 
 * Divide this problem into a 2n+1 problem, and then use the method in Single Number I.
 * 
 */
public class SingleNumberIII {
	
	public static int[] singleNumber(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		
		int[] ret = new int[2];
		int x = 0;
		for (int num : nums) {
			x = x ^ num;
		}
		
		x = x & (~(x-1)); // Group dividing pivot
		
		// Divide the two numbers we wanna obtain into two diff groups
		for (int num : nums) {
			if ((num & x) != 0) {
				ret[0] = ret[0] ^ num;
			} else {
				ret[1] = ret[1] ^ num; 
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Single Number III Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int[] results = singleNumber(testArray);
		System.out.println("The single number in your given int array are " + results[0] 
				+ " and " + results[1]);
	}
}
