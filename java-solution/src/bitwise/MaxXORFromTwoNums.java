package bitwise;

import java.util.HashSet;
import java.util.Set;

/***************************************************************************
* Problem No. : 421
* Problem Name: Maximum XOR of two numbers in an array
* Problem URL : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
* Date        : Jan 16 2018
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
*
* 	Assumption:
* 		1.
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
* meta        : tag-bit
***************************************************************************/
public class MaxXORFromTwoNums {
	/*
	 * Properties:
	 * a ^ 0 = a;
	 *
	 * nums = [5, 25, 8]
	 *
	 * 5 =  000101
	 * 25 = 011001
	 * 8 =  001000
	 *
	 * The maximum is contributed from 5^25 = 28 (011100); 5^8 = 13, 8^25 = 17.
	 *
	 * For convenience, just assume we use 6 digits to represent these three integers
	 *
	 * #1 mask 是用于取最高位的1， num & mask
	 * #2 candidate 是通过 res | (1 << i), res的逐步叠加而形成。
	 * 所以有
	 *
	 * 5 =  000101  = (4 + 1)
	 * 25 = 011001  = (16 + 8 + 1)
	 * 8 =  001000  = (8)
	 *
	 * #3 set.contains(prefix ^ candidate)
	 * 是利用性质 if a ^ b = c, then a ^ c = b, b ^ c = a.
	 *
	 * 所以，28 是当 i=2 时，由 4 ^ 24 = 28形成，且我们判断到 4 ^ 28 = 24 which is in the set, so res = 28有效。
	 *
	 * 当继续叠加candidate = 28 | (1 << i) where i = 1, we get candidate = 29 and set = {4, 24, 8}, 性质无法满足故29无效。
	 * 当继续叠加candidate = 29 | (1 << i) where i = 0, we get candidate = 30 and set = {5, 25, 8}, 性质无法满足故30无效。
	 *
	 * so final result is 28.
	 *
	 * */
	public static class Solution {
		
		public int findMaximumXOR(int[] nums) {
			int res = 0, mask = 0;
			for (int i = 31; i >= 0; i--) {
				mask = mask | (1 << i);
				Set<Integer> set = new HashSet<>();
				for (int num : nums) {
					set.add(num & mask);
				}
				int candidate = res | (1 << i);
				for (int prefix : set) {
					if (set.contains(candidate ^ prefix)) {
						res = candidate;
						break;
					}
				}
			}
			return res;
		}
		
		public int findMaximumXOR_Testing(int[] nums) {
			if (nums == null || nums.length == 0) {
				return 0;
			}
			int res = 0, mask = 0;
			for (int i = 5; i >= 0; i--) {  // HERE, i = 5 is for testing, Looking-into-detail only, right sol has i = 31 !!!
				mask = mask | (1 << i);
//				System.out.println(" mask is: " + mask); //DEBUG

				Set<Integer> set = new HashSet<>();
				for (int num : nums) {
					set.add(num & mask);  //Note here we use num & mask to extract prefix of a number
				}
//				displaySet(i, set); //DEBUG

				int candidate = res | (1 << i);
//				displayCandidate(candidate); //DEBUG

				for (int prefix : set) {
					if (set.contains(prefix ^ candidate)) {
						res = candidate;
//						System.out.println(" res is: " + res); //DEBUG
						break;
					}
				}
			}
			return res;
		}

		private void displaySet(int i, Set<Integer> set) {
			System.out.print("When i is in position " + i + ", Current numbers in the set are: ");
			for (int el: set) {
				System.out.print(el + "\t");
			}
			System.out.println();
		}

		private void displayCandidate(int candidate) {
			System.out.println(" Candidate is: " + candidate);
		}
 	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {5, 25, 8};
		System.out.println("The maximum XOR is: " + s.findMaximumXOR_Testing(nums));
	}
}
