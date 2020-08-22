package dp;
/***************************************************************************
* Problem No. : 91
* Problem Name: Decode Ways
* Problem URL : https://leetcode.com/problems/decode-ways/description/
* Date        : Jan 10 2018
* Author      :	@codingbro
* Notes       :
* 	Scenario:
*
* 	Assumption:
*
	Example:
* 	Input: s = "12"
* 	Output: 2  (cuz decoded to AB or L)
*
* 	Data Structure and Alg:
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-dp, tag-string
***************************************************************************/
public class DecodeWays {
	public static class Solution {
		public int numDecodings(String s) {
			if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) {
				return 0;
			}

			int n = s.length();
			int[] dp = new int[n + 1];
			dp[0] = 1;
			for (int i = 1; i <= n; i++) {
				dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
				if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
					dp[i] += dp[i - 2];
				}
			}
			return dp[n];
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "1003";
		System.out.println("No. of Ways: " + sol.numDecodings(s)); // 0
		s = "0023";
		System.out.println("No. of Ways: " + sol.numDecodings(s)); // 0
		s = "103";
		System.out.println("No. of Ways: " + sol.numDecodings(s)); // 1 (JC)
		s = "1034";
		System.out.println("No. of Ways: " + sol.numDecodings(s)); // 1
		s = "1025";
		System.out.println("No. of Ways: " + sol.numDecodings(s)); // 2
		s = "3025";
		System.out.println("No. of Ways: " + sol.numDecodings(s)); // 0 (cuz beginning 30 is already invalid)
 	}
}
