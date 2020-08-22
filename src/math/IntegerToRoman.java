package math;
/***************************************************************************
* Problem No. : 12
* Problem Name: Integer to Roman
* Problem URL : https://leetcode.com/problems/integer-to-roman/description/
* Date        : Feb 15 2018
* Author      : @codingbro
* 
* A very cultural dependent question. 
*
* Firstly, we need to know:
* 	罗马字符 与 阿拉伯数字对应关系
* 	I - 1， V - 5， X - 10， L - 50， C - 100， D - 500， M - 1000。
* 	
* Assumption  : 	
* 	1. The input string is between 1 and 3999. 
*  
* meta        : tag-math, tag-hash
***************************************************************************/
public class IntegerToRoman {
	/**
	 * Use the hashmap idea similar to Solution 2 of Problem "Roman to Integer"
	 * Mapping concept:  Integer -> String
	 *  int[] stores values from the large to the small, and we only care about the regular values and 9xx, 4xx ones 
	 *  		(cuz these have smaller Roman value on the left of a larger one)
	 * Then, 从0到n-1 traverse the values array. 
	 *   while (num >= values[i]) {} 
	 *   
	 * 总的来讲，做mapping的目标就是允许sb从左到右append strs[i] 去生成答案。
	 */
	private static class Solution {
		public String intToRoman(int num) {
			if (num < 1 || num > 3999) {
				return "";
			}
			StringBuilder sb = new StringBuilder();
			int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
			String[] strs = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
			for (int i = 0; i < values.length; i++) {
				while (num >= values[i]) {
					num -= values[i];
					sb.append(strs[i]);
				}
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.intToRoman(621)); // output: DCXXI
		System.out.println(s.intToRoman(3999)); // output: DCXXI
		
	}
}
