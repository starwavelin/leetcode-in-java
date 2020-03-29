package bitwise;

/***************************************************************************
* Problem No. : 
* Problem Name: Single Number 4 (Self-created)
* Problem URL : 
* Date        : Jan 17 2018
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		This is a question created by me, similar to Single Number II.
* 		Given an integer array of 4n+1 numbers, all numbers appear exactly 4 times except one number that appears only once.
* 		Find that number
* 	Assumption:
* 		1. non-empty array, no defensive checking needed.
* 		2. integers can be negative
	Example:
* 	Input: [-1, 0, -1, 0, -1, -1, 3, 0, 0]
* 	Output: 3
* 		
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-bit
***************************************************************************/
public class SingleNumberIV {

	/**
	 * Method: Cancel out every 4 repetitive numbers
	 * 0123
	 * 0123
	 * 0123
	 * 0123
	 * ----  4XOR
	 * 0000
	 * 
	 * Time Complexity: O(n*32) = O(n)
	 * Space Coplexity: O(1)
	 */
	public static class Solution {
		
		public int findSingle(int[] nums) {
			int res = 0; 
			for (int i = 0; i <= 31; i++) {
				int sum = 0;
				for (int num : nums) {
					sum += (num >> i) & 1;
					sum %= 4; // every 4 identical numbers
				}
				res |= (sum << i);
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[] nums = new int[] {-1, 0, -1, 0, -1, -1, 3, 0, 0};
		System.out.println(s.findSingle(nums)); // 3
		
		nums = new int[] {-128, 29, 30, -128, -128, -128, 29, 29, 29};
		System.out.println(s.findSingle(nums)); // 30
	}
}
