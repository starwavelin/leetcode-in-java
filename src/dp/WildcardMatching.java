package dp;
/***************************************************************************
* Problem No. : 44
* Problem Name: Wildcard Matching
* Problem URL : https://leetcode.com/problems/wildcard-matching/
* Date        : Jan 10 2017
* Author      :	@codingbro
* Notes       : 
* 	Scenario:
* 		
* 	Assumption:
* 		
	Example:
* 	Input: s = "abcd", p = "*"
* 	Output: true
* 		
* 	Data Structure and Alg:
* 		see code comments  
* Complexity  : 
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
* 
* meta        : tag-dp, tag-string, tag-two-pointers
***************************************************************************/
public class WildcardMatching {
	
	/**
	 * DP Solution 
	 * Time Complexity and Space Complexity: O(mn)
	 */
	public static class Solution {
		public boolean isMatch(String s, String p) {
	        int m = s.length();
	        int n = p.length();
	        
	        boolean[][] dp = new boolean[m + 1][n + 1];
	        dp[0][0] = true;
	        for (int j = 1; j <= n; j++) {
	            if (p.charAt(j - 1) == '*') {
	                dp[0][j] = dp[0][j - 1];    
	            }
	        }
	        
	        for (int i = 1; i <= m; i++) {
	            for (int j = 1; j <= n; j++) {
	                if (p.charAt(j - 1) != '*') {
	                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1];
	                } else {
	                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
	                }
	            }
	        }
	        return dp[m][n];
	    }
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s1 = "abcd", s2 = "*";
		System.out.println("Does s2 match s1? " + sol.isMatch(s1, s2)); //("abcd", "*"), true
		s1 = "";
		System.out.println("Does s2 match s1? " + sol.isMatch(s1, s2)); //("", "*"), true
		s2 = "k*";
		System.out.println("Does s2 match s1? " + sol.isMatch(s1, s2)); //("", "k*"), false
	}
}
